/* Copyright (c) SAIF AI. All rights reserved. */

package com.example.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.SaifTheme
import com.saifai.brand.SaifCredits

/**
 * The Credits sheet.
 *
 * "SAIF AI" is pinned to the top in a prominent type size, and every licence (GPL, Apache, MIT,
 * BSD, …) is rendered as a single very long line in a small font underneath. Nothing is split over
 * separate sections - there is exactly one place where the credits live.
 */
@Composable
fun CreditsSheet(
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = SaifTheme.colors.surfaceCard,
        titleContentColor = SaifTheme.colors.textPrimary,
        textContentColor = SaifTheme.colors.textSecondary,
        shape = RoundedCornerShape(22.dp),
        modifier = modifier,
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = androidx.compose.material.icons.Icons.Filled.Star,
                    contentDescription = null,
                    tint = com.example.ui.theme.PrimaryAccent,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = "Credits",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        },
        text = {
            Column(
                Modifier
                    .heightIn(max = 420.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // SAIF AI sits at the very top, large and prominent.
                Text(
                    text = SaifCredits.HEADLINE,
                    color = SaifTheme.colors.textPrimary,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Black,
                    letterSpacing = 2.sp
                )
                Text(
                    text = SaifCredits.HEADLINE_SUB,
                    color = SaifTheme.colors.textSecondary,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium
                )

                Spacer(Modifier.height(2.dp))

                // Every licence on one long, small line.
                Text(
                    text = SaifCredits.thirdPartyOneLine,
                    color = SaifTheme.colors.textSecondary.copy(alpha = 0.85f),
                    fontSize = 9.5.sp,
                    lineHeight = 14.sp
                )
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Close", color = com.example.ui.theme.PrimaryAccent)
            }
        }
    )
}
