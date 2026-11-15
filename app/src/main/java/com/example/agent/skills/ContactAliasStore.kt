package com.example.agent.skills

import android.content.Context

data class ResolvedContact(
    val name: String,
    val phoneNumber: String
)

/**
 * Contacts access has been REMOVED from this build: the address book is never read.
 *
 * Only phone-number helpers survive (WhatsApp can still open a chat with a typed number).
 * Both contact lookups return empty results without touching the Contacts provider, so the app
 * never needs READ_CONTACTS.
 */
object ContactAliasStore {

    /** Always empty: nothing is read from the device address book. */
    fun resolveContact(context: Context, query: String): List<ResolvedContact> = emptyList()

    /** Always empty: contact names are no longer used to bias speech recognition. */
    fun getSampleContactNames(context: Context): List<String> = emptyList()

    fun normalizePhoneNumber(raw: String, defaultCountryCode: String = "+91"): String {
        var digits = raw.replace(Regex("[^0-9+]"), "")
        if (digits.startsWith("+")) return digits
        if (digits.startsWith("0")) digits = digits.removePrefix("0")
        if (digits.length == 10) return "$defaultCountryCode$digits"
        return digits
    }
}
