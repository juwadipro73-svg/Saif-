/* Copyright (c) SAIF AI. All rights reserved. */

package com.example.saif.ui.chat

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.saif.data.remote.SlashCommandItem

/**
 * Autocomplete list shown above the composer while the owner types a slash command.
 * Tapping a command that is a pure app action runs it immediately; everything else is
 * inserted into the input so it can still be edited before sending.
 */
@Composable
fun SlashCommandOverlay(
    items: List<SlashCommandItem>,
    query: String,
    runsOnTap: (SlashCommandItem) -> Boolean,
    onPick: (SlashCommandItem) -> Unit,
    modifier: Modifier = Modifier
) {
    if (items.isEmpty()) return
    Surface(
        shape = RoundedCornerShape(14.dp),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 6.dp,
        shadowElevation = 8.dp,
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            Modifier
                .heightIn(max = 244.dp)
                .verticalScroll(rememberScrollState())
                .padding(vertical = 4.dp)
        ) {
            items.take(12).forEach { item ->
                SlashCommandRow(
                    item = item,
                    highlighted = item.command.removePrefix("/").startsWith(query.removePrefix("/"), ignoreCase = true),
                    runsOnTap = runsOnTap(item),
                    onClick = { onPick(item) }
                )
            }
        }
    }
}

@Composable
private fun SlashCommandRow(
    item: SlashCommandItem,
    highlighted: Boolean,
    runsOnTap: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = item.command,
            fontFamily = FontFamily.Monospace,
            fontSize = 13.sp,
            fontWeight = if (highlighted) FontWeight.SemiBold else FontWeight.Normal,
            color = if (highlighted) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
        )
        Spacer(Modifier.width(10.dp))
        Column(Modifier.weight(1f)) {
            Text(item.description, fontSize = 11.5.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
            if (item.argumentHint.isNotBlank()) {
                Text(item.argumentHint, fontSize = 10.5.sp, fontFamily = FontFamily.Monospace)
            }
        }
        if (runsOnTap) {
            Text("run", fontSize = 10.5.sp, color = MaterialTheme.colorScheme.primary)
        }
    }
}
