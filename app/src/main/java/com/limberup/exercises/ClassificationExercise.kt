package com.limberup.exercises

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController



@Composable
fun BrowseCard(
    Title: String = "Hips",
    imageResId: Int? = null,
    backgroundColor: Color = Color.White,
    polygonColor: Color = Color.Blue,
    modifier: Modifier = Modifier,
    navController: NavController? = null,
    destination: String? = null,
) {
    Card(
        modifier = modifier
            .width(125.dp)
            .height(115.dp)
            .clickable(enabled = navController != null && destination != null) {
                navController?.navigate(destination!!)
            },
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        elevation = CardDefaults.cardElevation(6.dp) // Subtle elevation for a modern feel
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (imageResId != null) {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = "Exercise Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                        .background(polygonColor)
                )
            }

            Text(
                text = Title,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


@Composable
fun ScrollableSingleRow(navController: NavController) {
    LazyRow(
        modifier = Modifier.padding(8.dp), // Optional padding
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(1) { // We need two "groups" of BrowseCards in the row
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp) // ⬅️ vertical spacing inside the column
            )  {
                BrowseCard(Title = "Hips", polygonColor = Color.Red, navController = navController, destination = "HipsView", imageResId = R.drawable.hip_extensor_stretch_seated)
                BrowseCard(Title = "Shoulders", polygonColor = Color.Red, navController = navController, destination = "ShouldersView", imageResId = R.drawable.shoulder_flexor)
            }
        }

        items(1) { // Second group of BrowseCards
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp) // ⬅️ vertical spacing inside the column
            ) {
                BrowseCard(Title = "Upper Back", polygonColor = Color.Green, navController = navController, destination = "UpperBackView", imageResId = R.drawable.lat_stretch_with_trunk_rotation)
                BrowseCard(Title = "Lower Back", polygonColor = Color.Green, navController = navController, destination = "LowerBackView", imageResId = R.drawable.reach_and_kick_back)

            }
        }
        items(1) { // Third group of BrowseCards
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp) // ⬅️ vertical spacing inside the column
            ) {
                BrowseCard(Title = "Hamstrings", polygonColor = Color.Red, navController = navController, destination = "HamstringsView", imageResId = R.drawable.prone_hamstring_and_glute_pull)
                BrowseCard(Title = "Quads", polygonColor = Color.Yellow, navController = navController, destination = "QuadsView", imageResId = R.drawable.lunge_to_side)
            }
        }

        items(1) { // Third group of BrowseCards
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp) // ⬅️ vertical spacing inside the column
            ) {
                BrowseCard(Title = "Posture", polygonColor = Color.Red, navController = navController, destination = "PostureView", imageResId = R.drawable.cat_pose)
                BrowseCard(Title = "Chest", polygonColor = Color.Yellow, navController = navController, destination = "ChestView", imageResId = R.drawable.chest_to_ground)
            }
        }

        items(1) { // Third group of BrowseCards
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp) // ⬅️ vertical spacing inside the column
            ) {
                BrowseCard(Title = "Core", polygonColor = Color.Red, navController = navController, destination = "CoreView", imageResId = R.drawable.abdominal_lift_twist_elbows_extended)
            }
        }

    }
}






