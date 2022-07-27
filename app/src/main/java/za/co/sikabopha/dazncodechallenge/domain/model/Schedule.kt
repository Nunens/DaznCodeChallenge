package za.co.sikabopha.dazncodechallenge.data.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class Schedule(
    val title: String,
    val subtitle: String,
    val date: String,
    val timestamp: Date? = null,
    val formattedDate: String? = null,
    val imageUrl: String
):Parcelable
