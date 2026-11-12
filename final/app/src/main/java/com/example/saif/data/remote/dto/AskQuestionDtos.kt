/* Copyright (c) SAIF AI. All rights reserved. */

package com.example.saif.data.remote.dto

/** One answer the user gave to a question the agent asked before continuing. */
data class AskQuestionResponseItemDto(
    val questionId: String = "",
    val question: String = "",
    val answer: String = ""
)
