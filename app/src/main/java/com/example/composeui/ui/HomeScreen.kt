package com.example.composeui.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeui.R
import com.example.composeui.ui.theme.AquaBlue
import com.example.composeui.ui.theme.Beige1
import com.example.composeui.ui.theme.Beige2
import com.example.composeui.ui.theme.Beige3
import com.example.composeui.ui.theme.Black900
import com.example.composeui.ui.theme.BlueViolet1
import com.example.composeui.ui.theme.BlueViolet2
import com.example.composeui.ui.theme.BlueViolet3
import com.example.composeui.ui.theme.ButtonBlue
import com.example.composeui.ui.theme.DarkerButtonBlue
import com.example.composeui.ui.theme.Green900
import com.example.composeui.ui.theme.LightGreen1
import com.example.composeui.ui.theme.LightGreen2
import com.example.composeui.ui.theme.LightGreen3
import com.example.composeui.ui.theme.LightRed
import com.example.composeui.ui.theme.OrangeYellow1
import com.example.composeui.ui.theme.OrangeYellow2
import com.example.composeui.ui.theme.OrangeYellow3
import com.example.composeui.ui.theme.Pink80
import com.example.composeui.ui.theme.Pink900
import com.example.composeui.ui.theme.Teal500
import com.example.composeui.ui.theme.TextWhite

/**
 * @author : Mingaleev D
 * @data : 20.10.2023
 */

@Composable
fun HomeScreen() {

   Box(
       modifier = Modifier.fillMaxSize()
   ) {

      Column {

         GreedingSection()

         ChipSection(
             chips = listOf(
                 "Сладкий сон",
                 "Хорошие новости",
                 "Отличный день",
                 "Быть добру"
             )
         )

         CurrentMedicine()

         FeatureSection(
             features = listOf(
                 Feature(
                     title = "Сладкий сон",
                     R.drawable.ic_headphone,
                     BlueViolet1,
                     BlueViolet2,
                     BlueViolet3
                 ),
                 Feature(
                     title = "Хорошие новости",
                     R.drawable.ic_videocam,
                     LightGreen1,
                     LightGreen2,
                     LightGreen3
                 ),
                 Feature(
                     title = "Отличный день",
                     R.drawable.ic_headphone,
                     OrangeYellow1,
                     OrangeYellow2,
                     OrangeYellow3
                 ),
                 Feature(
                     title = "Быть добру",
                     R.drawable.ic_headphone,
                     Beige1,
                     Beige2,
                     Beige3
                 )
             )
         )

      }

      BtnMenu(
          items = listOf(
              BtnMenuContent(title = "Дом", R.drawable.ic_home),
              BtnMenuContent(title = "Пузырь", R.drawable.ic_bubble),
              BtnMenuContent(title = "Сон", R.drawable.ic_moon),
              BtnMenuContent(title = "Музыка", R.drawable.ic_music),
              BtnMenuContent(title = "Профиль", R.drawable.ic_profile)
          ),
          modifier = Modifier.align(Alignment.BottomCenter)
      )
   }
}

@Composable
fun GreedingSection(
) {

   Row(
       horizontalArrangement = Arrangement.SpaceBetween,
       verticalAlignment = Alignment.CenterVertically,
       modifier = Modifier
           .fillMaxWidth()
           .padding(15.dp)
   ) {

      Column(
          verticalArrangement = Arrangement.Center
      ) {

         Text(text = "Привет всем! \uD83D\uDE0A", fontSize = 40.sp)
         Text(text = "Желаем хорошего дня", fontSize = 20.sp)
      }

      Icon(
          painter = painterResource(id = R.drawable.ic_search),
          contentDescription = null,
          tint = Black900,
          modifier = Modifier.size(34.dp)
      )
   }

}

@Composable
fun ChipSection(
    chips: List<String>
) {

   var selectedChipIndex by remember { mutableStateOf(0) }

   LazyRow() {
      items(chips.size) {

         Box(
             modifier = Modifier
                 .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                 .clickable {
                    selectedChipIndex = it
                 }
                 .clip(RoundedCornerShape(10.dp))
                 .background(
                     if (selectedChipIndex == it) ButtonBlue
                     else DarkerButtonBlue
                 )
                 .padding(15.dp), contentAlignment = Alignment.Center
         ) {

            Text(text = chips[it], color = Color.White)
         }
      }
   }

}

@Composable
fun CurrentMedicine(
    color: Color = LightRed
) {

   Row(
       verticalAlignment = Alignment.CenterVertically,
       horizontalArrangement = Arrangement.SpaceBetween,
       modifier = Modifier
           .padding(15.dp)
           .clip(RoundedCornerShape(10.dp))
           .background(color)
           .padding(horizontal = 15.dp, vertical = 20.dp)
           .fillMaxWidth()
   ) {

      Column {
         Text(
             text = "Ежедневные размышления \uD83E\uDD14",
             fontSize = 22.sp,
             color = Green900
         )
         Text(
             text = "Медитация # 7-77",
             fontSize = 16.sp,
             color = Green900
         )
      }

      Box(
          contentAlignment = Alignment.Center,
          modifier = Modifier
              .size(40.dp)
              .clip(CircleShape)
              .background(ButtonBlue)
              .padding(10.dp)
      ) {
         Icon(
             painter = painterResource(id = R.drawable.ic_play),
             contentDescription = null,
             tint = LightGreen1,
             modifier = Modifier.size(16.dp)
         )

      }

   }


}

@Composable
fun FeatureSection(
    features: List<Feature>
) {

   Column(
       modifier = Modifier.fillMaxWidth()
   ) {

      Text(
          text = "Рекомендуемые",
          modifier = Modifier.padding(15.dp),
          fontSize = 20.sp,
          fontWeight = FontWeight.Bold
      )

      LazyVerticalGrid(
          columns = GridCells.Fixed(2),
          contentPadding = PaddingValues(start = 7.dp, end = 7.dp, bottom = 100.dp),
          modifier = Modifier.fillMaxHeight()
      ) {

         items(features.size) {

            FeatureItem(
                feature = features[it]
            )
         }
      }

   }
}

@Composable
fun FeatureItem(
    feature: Feature
) {

   BoxWithConstraints(
       modifier = Modifier
           .padding(7.dp)
           .aspectRatio(1f)
           .clip(RoundedCornerShape(10.dp))
           .background(feature.darkColor)
   ) {

      val width = constraints.maxWidth
      val height = constraints.maxHeight

      val mediumColoredPoint = Offset(0f, height * 0.3f)
      val mediumColoredPoint1 = Offset(width * 0.1f, height * 0.35f)
      val mediumColoredPoint2 = Offset(width * 0.4f, height * 0.05f)
      val mediumColoredPoint3 = Offset(width * 0.75f, height * 0.7f)
      val mediumColoredPoint4 = Offset(width * 1.4f, -height.toFloat())

      val mediumColoredPath = Path().apply {
         moveTo(mediumColoredPoint.x, mediumColoredPoint.y)
         standartQuadTo(mediumColoredPoint, mediumColoredPoint1)
         standartQuadTo(mediumColoredPoint1, mediumColoredPoint2)
         standartQuadTo(mediumColoredPoint2, mediumColoredPoint3)
         standartQuadTo(mediumColoredPoint3, mediumColoredPoint4)
         lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
         lineTo(-100f, height.toFloat() + 100f)
         close()

      }

      val lightPoint1 = Offset(0f, height * 0.35f)
      val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
      val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
      val lightPoint4 = Offset(width * 0.65f, height.toFloat())
      val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

      val lightColoredPath = Path().apply {
         moveTo(lightPoint1.x, lightPoint1.y)
         standartQuadTo(lightPoint1, lightPoint2)
         standartQuadTo(lightPoint2, lightPoint3)
         standartQuadTo(lightPoint3, lightPoint4)
         standartQuadTo(lightPoint4, lightPoint5)
         lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
         lineTo(-100f, height.toFloat() + 100f)
         close()
      }

      Canvas(modifier = Modifier.fillMaxSize()) {
         drawPath(
             path = mediumColoredPath,
             color = feature.mediumColor
         )
         drawPath(
             path = lightColoredPath,
             color = feature.lightColor
         )
      }

      Box(
          modifier = Modifier
              .fillMaxSize()
              .padding(15.dp)
      ) {

         Text(
             text = feature.title,
             modifier = Modifier.align(Alignment.Center),
             fontSize = 20.sp,
             lineHeight = 26.sp
         )

         Icon(
             painter = painterResource(id = feature.iconId),
             contentDescription = null,
             tint = Color.White,
             modifier = Modifier.align(Alignment.BottomStart)
         )

         Text(
             text = "Start",
             color = TextWhite,
             fontSize = 14.sp,
             fontWeight = FontWeight.Bold,
             modifier = Modifier
                 .clickable {
                    //Todo
                 }
                 .align(Alignment.BottomEnd)
                 .clip(RoundedCornerShape(10.dp))
                 .background(ButtonBlue)
                 .padding(vertical = 6.dp, horizontal = 15.dp)
         )
      }

   }

}

@Composable
fun BtnMenu(
    items: List<BtnMenuContent>,
    modifier: Modifier = Modifier,
    activeHightColor: Color = Pink80,
    activeTextColor: Color = Pink900,
    inactiveTextColor: Color = AquaBlue,
    initSelectedItemIndex: Int = 0
) {

   var selectedItemIndex by remember { mutableStateOf(initSelectedItemIndex) }

   Row(
       horizontalArrangement = Arrangement.SpaceAround,
       verticalAlignment = Alignment.CenterVertically,
       modifier = modifier
           .fillMaxWidth()
           .padding(15.dp)
           .background(MaterialTheme.colors.background)
   ) {

      items.forEachIndexed { index, btnMenuContent ->
         BtnMenuItem(
             items = btnMenuContent,
             isSelected = index == selectedItemIndex,
             activeHightColor = activeHightColor,
             activeTextColor = activeTextColor,
             inactiveTextColor = inactiveTextColor
         ) {

            selectedItemIndex = index
         }
      }

   }

}

@Composable
fun BtnMenuItem(
    items: BtnMenuContent,
    isSelected: Boolean = false,
    activeHightColor: Color = Pink80,
    activeTextColor: Color = Pink900,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {

   Column(
       horizontalAlignment = Alignment.CenterHorizontally,
       verticalArrangement = Arrangement.Center,
       modifier = Modifier.clickable { onItemClick() }
   ) {

      Box(
          contentAlignment = Alignment.Center,
          modifier = Modifier
              .clip(RoundedCornerShape(10.dp))
              .background(if (isSelected) activeHightColor else Color.Transparent)
              .padding(10.dp)
      ) {

         Icon(
             painter = painterResource(id = items.iconId),
             contentDescription = null,
             tint = if (isSelected) activeTextColor else inactiveTextColor,
             modifier = Modifier.size(20.dp)
         )

      }

      Text(
          text = items.title,
          color = if (isSelected) activeTextColor else inactiveTextColor
      )

   }

}

data class Feature(
    val title: String,
    @DrawableRes val iconId: Int,
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color,
)

data class BtnMenuContent(
    val title: String,
    @DrawableRes val iconId: Int
)