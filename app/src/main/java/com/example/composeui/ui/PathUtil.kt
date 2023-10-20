package com.example.composeui.ui

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import kotlin.math.abs

/**
 * @author : Mingaleev D
 * @data : 20.10.2023
 */

fun Path.standartQuadTo(from: Offset, to: Offset) {
   quadraticBezierTo(
       from.x,
       from.y,
       abs(from.x + to.x) / 2f,
       abs(from.y + to.y) / 2f
   )
}