package com.example.www.app.presentation.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.www.app.R

@Composable
fun CustomImageView(
    modifier: Modifier,
    imageUrl:String,
    placeholder : Painter = painterResource(id = R.drawable.ic_image_placholder),
    contentScale :ContentScale = ContentScale.Crop,
    contentDescription:String
) {

    val painter = rememberAsyncImagePainter(
        model = imageUrl,
        placeholder = placeholder,
        error = placeholder,
        fallback = placeholder,
        contentScale = contentScale,
    )


    Image(
        modifier = modifier,
        contentScale = ContentScale.Crop,
        painter = painter,
        contentDescription = contentDescription
    )
}