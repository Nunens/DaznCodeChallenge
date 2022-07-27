package za.co.sikabopha.dazncodechallenge.domain.model

import java.util.*

data class Schedule(
    val id: String,
    val title: String,
    val subtitle: String,
    val date: String,
    val imageUrl: String,
    val timestamp: Date? = null,
    val formattedDate: String? = null,
)
