package za.co.sikabopha.dazncodechallenge.domain.model

import java.util.*

data class Event(
    val title: String,
    val subtitle: String,
    val date: String,
    val imageUrl: String,
    val videoUrl: String,
    val timestamp: Date? = null,
    val formattedDate: String? = null,
)
