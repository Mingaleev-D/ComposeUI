package com.example.composeui.ui.theme

// Set of Material typography styles to start with
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.composeui.R

val gothicA1 = FontFamily(
    listOf(
        Font(R.font.arial_rounded_mt_regular, FontWeight.Normal),
        Font(R.font.arial_rounded_mt_regular, FontWeight.Medium),
        Font(R.font.arlrdbd, FontWeight.SemiBold),
        Font(R.font.arlrdbd, FontWeight.Bold),
        Font(R.font.arial_rounded_mt_regular, FontWeight.Black),
    )
)
// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)


