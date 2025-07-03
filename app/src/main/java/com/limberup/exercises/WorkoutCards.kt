package com.limberup.exercises

import android.content.Context
import android.icu.util.Calendar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.testing.TestNavHostController
import com.limberup.exercises.R


data class WorkoutRecommendation(
    val title: String,
    val duration: String,
    val imageResId: Int,
    val destination: String
)




@Composable
fun WorkoutCard(workoutName: String, durationString: String, imageResId: Int, destination: String, navController: NavHostController) {
    Card(
        modifier = Modifier
            .clickable {
                navController.navigate(destination) // ✅ Correct chaining
            }
            .size(200.dp) // ✅ continue chain
            .padding(4.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            // ✅ Circle image on the left
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "Workout Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(110.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // ✅ Text on the right
            Text(
                text = workoutName,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                fontSize = 24.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(6.dp))

            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp) // space between icon and text
            ) {

                Text(
                    text = durationString,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 16.sp,
                    color = Color.Gray,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Icon(
                    imageVector = Icons.Default.AccessTime, // ⏱️ Clock icon
                    contentDescription = "Duration",
                    tint = Color.Gray,
                    modifier = Modifier.size(18.dp)
                )

            }
        }
    }
}




@Composable
fun QuickandEasyWorkout(navController: NavHostController) {
    val recommendedItems = listOf(
        WorkoutRecommendation(
            title = "😴 Sleep Reset",
            duration = "8 Minutes",
            imageResId = R.drawable.back_rolls,
            destination = "SleepReset"
        ),
        WorkoutRecommendation(
            title = "💼 Desk Detox",
            duration = "6 Minutes",
            imageResId = R.drawable.cow_pose_1,
            destination = "DeskDetox"
        ),
        WorkoutRecommendation(
            title = "🌞 Wake & Shake",
            duration = "4 Minutes",
            imageResId = R.drawable.cat_stretch_standing_extended_forward_bend,
            destination = "WakeAndShake"
        ),
        WorkoutRecommendation(
            title = "🧘 Lower Back Relief",
            duration = "6 Minutes",
            imageResId = R.drawable.fierce_pose_3_tiptoe,
            destination = "LowerBackRelief"
        ),
        WorkoutRecommendation(
            title = "📱 Tech Neck Fix",
            duration = "5 Minutes",
            imageResId = R.drawable.back_stretch_with_arms_reaching_1,
            destination = "TechNeckFix"
        ),
        WorkoutRecommendation(
            title = "🖐️ Wrist Reset",
            duration = "3 Minutes",
            imageResId = R.drawable.garland_pose_intense_wrist_stretch,
            destination = "WristReset"
        )
    )



    LazyRow(
        modifier = Modifier.padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(recommendedItems) {workout ->
            WorkoutCard(
                workoutName = workout.title,
                durationString = workout.duration,
                imageResId = workout.imageResId,
                destination = workout.destination,
                navController = navController
            )
        }
    }

}


val weeklyWorkoutList = listOf(
    WorkoutRecommendation(
        title = "🧘 Flow for Flexibility",
        duration = "6 Minutes",
        imageResId = R.drawable.hip_raise,
        destination = "FlexibilityFlow"
    ),
    WorkoutRecommendation(
        title = "💪 More Core",
        duration = "5 Minutes",
        imageResId = R.drawable.head_to_knee_pose_both_hands_to_ankle,
        destination = "CorePower"
    ),
    WorkoutRecommendation(
        title = "🧠 Unwind & Breathe",
        duration = "4 Minutes",
        imageResId = R.drawable.hamstring_toe_touch,
        destination = "UnwindFlow"
    ),
    WorkoutRecommendation(
        title = "🔥 Energy Boost",
        duration = "5 Minutes",
        imageResId = R.drawable.cobra_stretch,
        destination = "EnergyBoost"
    ),
    WorkoutRecommendation(
        title = "Upper Back Relief Flow \uD83E\uDDD8\u200D\u2642\uFE0F",
        duration = "5 Minutes",
        imageResId = R.drawable.easy_upper_back_stretch,
        destination = "UpperBackReliefFlow"
    ),
    WorkoutRecommendation(
        title = "Hamstring Stretch Routine \uD83D\uDCAA",
        duration = "6 Minutes",
        imageResId = R.drawable.unilateral_hamstring_stretch_toe_pointed,
        destination = "HamstringStretchRoutine"
    ),
    WorkoutRecommendation(
        title = "Spinal Twist Reset \uD83C\uDFCB\uFE0F",
        duration = "6 Minutes",
        imageResId = R.drawable.spinal_twist_deep_seated,
        destination = "SpinalTwistReset"
    ),
    WorkoutRecommendation(
        title = "Glute Activation Series \uD83D\uDCAA\uD83D\uDCAA",
        duration = "4 Minutes",
        imageResId = R.drawable.easy_spinal_twist,
        destination = "GluteActivationSeries"
    ),
    WorkoutRecommendation(
        title = "Full Body Flow ✨",
        duration = "6 Minutes",
        imageResId = R.drawable.side_bending_mountain_pose,
        destination = "FullBodyFlow"
    )
)


@Composable
fun HomeView(navController: NavHostController, context: Context) {
    val weekNumber = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR)
    val featuredStartIndex = weekNumber % weeklyWorkoutList.size
    val featuredWorkouts = (0 until 3).map { i ->
        weeklyWorkoutList[(featuredStartIndex + i) % weeklyWorkoutList.size]
    }


    val userPreferences = remember { UserPreferences(context) }
    val userName = remember { userPreferences.getUserName() }
    val currentTime = Calendar.getInstance()
    val initialHour = currentTime.get(Calendar.HOUR_OF_DAY)
    val textable = when {
        initialHour < 12 -> "Good Morning"
        initialHour in 12..16 -> "Good Afternoon"
        else -> "Good Evening"
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (userName.isNotEmpty()) "$textable,\n$userName!" else "$textable",
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color.Black
                )
                IconButton(
                    onClick = { navController.navigate("user_profile") },
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(Color.White),
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile",
                        tint = Color.Black
                    )
                }
            }
        }

        item {
            Column {
                ScrollingCardCarousel(navController)
            }


        }
        item {
            Column {
                Text(
                    text = "\uD83D\uDCAA By Muscle Group",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(8.dp))
                com.limberup.exercises.ScrollableSingleRow(navController)

            }

        }

        item {
            Column {
                Text(
                    text = "✨ Featured Workouts for you",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(8.dp))

                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(featuredWorkouts) { workout ->
                        WorkoutCard(
                            workoutName = workout.title,
                            durationString = workout.duration,
                            imageResId = workout.imageResId,
                            destination = workout.destination,
                            navController = navController
                        )
                    }
                }
            }
        }

        item {
            Column {
                Text(
                    text = "\uD83C\uDF1F Quick and Easy Workouts",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    color = Color.Gray
                )

                QuickandEasyWorkout(navController)
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeViewPreview() {
    val navController = rememberNavController()
    val context = LocalContext.current

    // You may want to insert fake data if weeklyWorkoutList is empty in preview


    HomeView(navController = navController, context = context)
}
