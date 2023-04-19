package com.example.www.app.presentation.ui.composables

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun LabelText(
    modifier: Modifier = Modifier,
    label:String,
    value:String,
    fontSize : TextUnit = 14.sp
) {
    Text(
        modifier =modifier,
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color(0xFF4D4C4C),
                    fontWeight = FontWeight.Normal
                )
            ){
                append("$label: ")
            }
            withStyle(
                style = SpanStyle(
                    color = Color(0xFF181818),
                    fontWeight = FontWeight.Medium
                )
            ){
                append(value.ifEmpty { "N/A" })
            }
        },
        style = TextStyle(
            fontSize = fontSize,
        )
    )
}