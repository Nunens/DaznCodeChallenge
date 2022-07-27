package za.co.sikabopha.dazncodechallenge.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class Event(
    val title: String,
    val subtitle: String,
    val date: String,
    val timestamp: Date? = null,
    val formattedDate: String? = null,
    val imageUrl: String,
    val videoUrl: String
):Parcelable
