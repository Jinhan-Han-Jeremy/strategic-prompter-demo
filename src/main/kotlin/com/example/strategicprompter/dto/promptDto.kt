package com.example.strategicprompter.dto

import java.util.*

data class PromptDto(
    val uid: Int = UUID.randomUUID().mostSignificantBits.toInt(),
    val questionTypes: String,
    val headPrompts: String,
    val bodyPrompts: String,
    val tailPrompts: String
)
