package com.limberup.exercises

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlin.math.absoluteValue
import androidx.compose.ui.util.lerp
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import kotlinx.serialization.json.Json.Default.configuration

val imageUrls = listOf(
    R.drawable.totalbodyflexibility,
    R.drawable.morningworkout
)

@Composable
fun ScrollingCardCarousel(navController: NavHostController) {
    val pagerState = rememberPagerState()

    Box(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            count = imageUrls.size,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 48.dp),
            itemSpacing = 0.dp
        ) { index ->
            CardContent(index, pagerState, navController)
        }
    }
}

@Composable
fun CardContent(
    index: Int,
    pagerState: PagerState,
    navController: NavHostController
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val cardWidth = screenWidth * 0.85f

    val isCurrentPage = pagerState.currentPage == index

    Card(
        shape = RoundedCornerShape(28.dp),
        elevation = 12.dp,
        backgroundColor = Color.White,
        modifier = Modifier
            .graphicsLayer {
                val pageOffset = (pagerState.currentPage - index).absoluteValue.toFloat()
                val scale = lerp(0.9f, 1f, 1f - pageOffset.coerceIn(0f, 1f))
                scaleX = scale
                scaleY = scale
                alpha = lerp(0.8f, 1f, 1f - pageOffset.coerceIn(0f, 1f))
            }
            .width(cardWidth)
            .aspectRatio(1f)
            .clickable {
                when (index) {
                    0 -> navController.navigate("MorningWorkoutRoutine")
                    1 -> navController.navigate("YogaImprovedFlexibility")
                    else -> {}
                }
            }
    ) {
        Image(
            painter = painterResource(id = imageUrls[index]),
            contentDescription = "Image $index",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScrollingCardCarouselPreview() {
    val context = LocalContext.current
    val navController = remember { NavHostController(context) }

    ScrollingCardCarousel(navController)
}



