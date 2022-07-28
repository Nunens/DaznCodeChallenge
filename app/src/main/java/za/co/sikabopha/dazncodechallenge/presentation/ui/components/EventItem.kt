package za.co.sikabopha.dazncodechallenge.presentation.ui.components

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import za.co.sikabopha.dazncodechallenge.domain.model.Event
import za.co.sikabopha.dazncodechallenge.presentation.util.chromePlayer

fun formatToDate(date: String): Any {
    return try {
        var newDate = date.replace('T', ' ').substring(0, 16)
        newDate
    } catch (e: Exception) {
        //date.replace('T', ' ').substring(0, 19)
    }
}

@Composable
fun EventItem(event: Event, context: Context) {
    Card(
        modifier = Modifier
            .clickable {
                chromePlayer(event.videoUrl, context)
            }
            .padding(4.dp)
            .fillMaxWidth()
            .height(110.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp
    ) {
        Surface() {
            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {
                AsyncImage(
                    model = event.imageUrl,
                    contentDescription = "article image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(110.dp)
                        .height(110.dp),
                    alignment = Alignment.Center
                )
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
                        text = event.title,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = event.subtitle,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .padding(4.dp)
                    )
                    Text(
                        text = formatToDate(event.date).toString(),
                        style = MaterialTheme.typography.body1,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                }
            }
        }
    }
}