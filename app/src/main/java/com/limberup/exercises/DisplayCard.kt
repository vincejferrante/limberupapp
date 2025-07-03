package com.limberup.exercises



import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.filled.Close
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController


@Composable
fun DisplayCard(
    modifier: Modifier = Modifier,
    title: String,
    minutes: String,
    imageResId: Int? = null,
    //destination: String? = null,
    onClick: (() -> Unit)? = null,

) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(6.dp)
            .then(
                if (onClick != null) Modifier.clickable { onClick() } else Modifier
            )
            .shadow(6.dp, shape = RoundedCornerShape(10.dp))
            .background(Color.White, shape = RoundedCornerShape(10.dp))
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(100.dp)
                .background(Color.White, shape = RoundedCornerShape(20.dp))
        ) {
            if (imageResId != null) {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = "Exercise Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(75.dp)
                        .clip(CircleShape)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(75.dp)
                        .background(color = Color.Blue, shape = CircleShape)
                )
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "$minutes MINUTES",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayCardPreview() {
    DisplayCard(
        title = "Morning Stretch",
        minutes = "10",
        imageResId = R.drawable.ab_upper_slide, // Replace with a valid drawable in your project
        onClick = { /* No-op for preview */ }
    )
}



data class TheExerciseItem(
    val title: String,
    val minutes: String,
    val imageResId: Int,
    val destination: String? = null // optional if you want
)


@Composable
fun CoreView(navController: NavController, onDismiss: () -> Unit) {
    val coreItems = listOf(
        TheExerciseItem("Core Stabilization Flow", "2", R.drawable.ab_upper_slide, "core1_screen" ),
        TheExerciseItem("Dynamic Core Energizer", "4", R.drawable.abdominal_lift_with_twist_and_leg_stretch, "core2_screen"),
        TheExerciseItem("Steady Core Builder", "4", R.drawable.abductor_stretch_leg_crossed_under, "core3_screen"),
        TheExerciseItem("Stable & Strong Core", "4", R.drawable.abdominal_lift_hand_clasp, "core4_screen")
    )

    Scaffold { paddingValues ->
        LazyColumn(
            contentPadding = PaddingValues(
                top = paddingValues.calculateTopPadding(),
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onDismiss) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.size(48.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp)) // Adjust spacing as needed

                    Text(
                        text = "Core",
                        style = MaterialTheme.typography.titleLarge.copy(fontSize = 32.sp),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            items(coreItems) { item ->
                DisplayCard(
                    title = item.title,
                    minutes = item.minutes,
                    imageResId = item.imageResId,
                    onClick = {
                        item.destination?.let { navController.navigate(it) }
                    }
                )
            }
        }
    }
}



@Composable
fun NeckView(navController: NavController, onDismiss: () -> Unit) {
    val neckItems = listOf(
        TheExerciseItem("Neck Relief Flow", "3", R.drawable.eastern_intense_stretch_pose_, "neck1_screen"),
        TheExerciseItem("Daily Neck Relief", "2", R.drawable.neck_hyperextension, "neck2_screen")
    )

    Scaffold { paddingValues ->
        LazyColumn(
            contentPadding = PaddingValues(
                top = paddingValues.calculateTopPadding(),
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onDismiss) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.size(48.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(32.dp)) // Adjust spacing as needed

                    Text(
                        text = "Neck",
                        style = MaterialTheme.typography.titleLarge.copy(fontSize = 32.sp),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            items(neckItems) { item ->
                DisplayCard(
                    title = item.title,
                    minutes = item.minutes,
                    imageResId = item.imageResId,
                    onClick = {
                        item.destination?.let { navController.navigate(it) }
                    }
                )
            }
        }
    }
}

@Composable
fun ChestView(navController: NavController, onDismiss: () -> Unit) {
    val chestItems = listOf(
        TheExerciseItem("\uD83E\uDDF0 Chest Flow", "3", R.drawable.chest_extension, "chest1_screen"),
        TheExerciseItem("\uD83D\uDCAA Chest Strength Program", "3", R.drawable.side_plank_chest_opener, "chest2_screen"),
        TheExerciseItem("\uD83E\uDDD8 Chest Flexibility Flow", "3", R.drawable.side_stretch_star_pose, "chest3_screen")
    )

    Scaffold { paddingValues ->
        LazyColumn(
            contentPadding = PaddingValues(
                top = paddingValues.calculateTopPadding(),
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onDismiss) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.size(48.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(32.dp)) // Adjust spacing as needed

                    Text(
                        text = "Chest",
                        style = MaterialTheme.typography.titleLarge.copy(fontSize = 32.sp),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            items(chestItems) { item ->
                DisplayCard(
                    title = item.title,
                    minutes = item.minutes,
                    imageResId = item.imageResId,
                    onClick = {
                        item.destination?.let { navController.navigate(it) }
                    }
                )
            }
        }
    }
}


@Composable
fun PostureView(navController: NavController, onDismiss: () -> Unit){
    val postureViewItems = listOf(
        TheExerciseItem("Posture Reset Routine", "2", R.drawable.seated_spinal_stretch, "posture1_screen"),
        TheExerciseItem("Anti-Hunch Flow", "2", R.drawable.seated_forward_lean, "posture2_screen"),
        TheExerciseItem("Everyday Posture Support", "2", R.drawable.mountain_pose_with_shoulder_opener, "posture3_screen")
    )

    Scaffold { paddingValues ->
        LazyColumn(
            contentPadding = PaddingValues(
                top = paddingValues.calculateTopPadding(),
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onDismiss) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.size(48.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(32.dp)) // Adjust spacing as needed

                    Text(
                        text = "Posture",
                        style = MaterialTheme.typography.titleLarge.copy(fontSize = 32.sp),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            items(postureViewItems) { item ->
                DisplayCard(
                    title = item.title,
                    minutes = item.minutes,
                    imageResId = item.imageResId,
                    onClick = {
                        item.destination?.let { navController.navigate(it) }
                    }
                )
            }
        }
    }
}



@Composable
fun HipsView(navController: NavController, onDismiss: () -> Unit) {
    val hipItems = listOf(
        TheExerciseItem("Hip Reset Flow", "3", R.drawable.one_leg_bound_standing_balance_variation, "hips1_screen"),
        TheExerciseItem("Hip Mobility Boost", "3", R.drawable.shoulder_stretch, "hips2_screen"),
        TheExerciseItem("Grounded Hip Stability", "2", R.drawable.supine_lumbar_rotation, "hips3_screen")
    )

    Scaffold { paddingValues ->
        LazyColumn(
            contentPadding = PaddingValues(
                top = paddingValues.calculateTopPadding(),
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onDismiss) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.size(48.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(32.dp)) // Adjust spacing as needed

                    Text(
                        text = "Hips",
                        style = MaterialTheme.typography.titleLarge.copy(fontSize = 32.sp),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            items(hipItems) { item ->
                DisplayCard(
                    title = item.title,
                    minutes = item.minutes,
                    imageResId = item.imageResId,
                    onClick = {
                        item.destination?.let { navController.navigate(it) }
                    }
                )
            }
        }
    }
}


@Composable
fun ShouldersView(navController: NavController, onDismiss: () -> Unit) {
    val shoulderItems = listOf(
        TheExerciseItem("Shoulder Reset Flow", "2", R.drawable.angle_pose, "shoulders1_screen"),
        TheExerciseItem("Open Shoulder Mobility", "3", R.drawable.bound_arm_stretch_behind, "shoulders2_screen"),
        TheExerciseItem("Shoulder Stability Groundwork", "2", R.drawable.arm_extension_with_bent_knees, "shoulders3_screen"),
        TheExerciseItem("Daily Shoulder Relief", "2", R.drawable.angle_pose_bound_2, "shoulders4_screen")
    )

    Scaffold { paddingValues ->
        LazyColumn(
            contentPadding = PaddingValues(
                top = paddingValues.calculateTopPadding(),
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onDismiss) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.size(48.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp)) // Adjust spacing as needed

                    Text(
                        text = "Shoulders",
                        style = MaterialTheme.typography.titleLarge.copy(fontSize = 32.sp),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            items(shoulderItems) { item ->
                DisplayCard(
                    title = item.title,
                    minutes = item.minutes,
                    imageResId = item.imageResId,
                    onClick = {
                        item.destination?.let { navController.navigate(it) }
                    }
                )
            }
        }
    }
}


@Composable
fun UpperBackView(navController: NavController, onDismiss: () -> Unit) {
    val upperBackItems = listOf(
        TheExerciseItem("Daily Upper Back Refresh ", "2", R.drawable.lat_stretch_with_trunk_rotation, "upper_back_screen1"),
        TheExerciseItem("Stronger, Taller, Freer Upper Back ", "2", R.drawable.bound_revolved_half_intense_back_stretch_pose, "upper_back_screen2"),
        TheExerciseItem("Unwind and Open Upper Back", "2", R.drawable.it_side_stretch, "upper_back_screen3"),
        TheExerciseItem("Upper Back Undo", "2", R.drawable.lunging_forward_twist, "upper_back_screen4")
    )

    Scaffold { paddingValues ->
        LazyColumn(
            contentPadding = PaddingValues(
                top = paddingValues.calculateTopPadding(),
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onDismiss) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.size(32.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp)) // Adjust spacing as needed

                    Text(
                        text = "Upper Back",
                        style = MaterialTheme.typography.titleLarge.copy(fontSize = 32.sp),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            items(upperBackItems) { item ->
                DisplayCard(
                    title = item.title,
                    minutes = item.minutes,
                    imageResId = item.imageResId,
                    onClick = {
                        item.destination?.let { navController.navigate(it) }
                    }
                )
            }
        }
    }
}



@Composable
fun LowerBackView(onDismiss: () -> Unit, navController: NavController) {
    val lowerBackItems = listOf(
        TheExerciseItem("Lower Back Recovery Flow (gentle relief)", "2", R.drawable.bow_pose, "lower_back1"),
        TheExerciseItem("Free Your Lower Back", "2", R.drawable.back_rolls, "lower_back2"),
        TheExerciseItem("Liberate Your Lumbar", "2", R.drawable.back_stretch_reaching, "lower_back3")
    )

    Scaffold { paddingValues ->
        LazyColumn(
            contentPadding = PaddingValues(
                top = paddingValues.calculateTopPadding(),
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onDismiss) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.size(32.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp)) // Adjust spacing as needed

                    Text(
                        text = "Lower Back",
                        style = MaterialTheme.typography.titleLarge.copy(fontSize = 32.sp),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            items(lowerBackItems) { item ->
                DisplayCard(
                    title = item.title,
                    minutes = item.minutes,
                    imageResId = item.imageResId,
                    onClick = {
                        item.destination?.let { navController.navigate(it) }
                    }
                )
            }
        }
    }
}


@Composable
fun HamstringsView(onDismiss: () -> Unit, navController: NavController) {
    val hamstringsItems = listOf(
        TheExerciseItem("Hamstrings Relief Flow", "4", R.drawable.hamstring_inverted, "hamstrings1_screen"),
        TheExerciseItem("Hamstrings Flexibility Flow", "4", R.drawable.knee_to_chest_simplified, "hamstrings2_screen"),
        TheExerciseItem("Relax Your Hamstrings", "4", R.drawable.hip_internal_rotator_alternating_legs, "hamstrings3_screen")
    )

    Scaffold { paddingValues ->
        LazyColumn(
            contentPadding = PaddingValues(
                top = paddingValues.calculateTopPadding(),
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onDismiss) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.size(32.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp)) // Adjust spacing as needed

                    Text(
                        text = "Hamstrings",
                        style = MaterialTheme.typography.titleLarge.copy(fontSize = 32.sp),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            items(hamstringsItems) { item ->
                DisplayCard(
                    title = item.title,
                    minutes = item.minutes,
                    imageResId = item.imageResId,
                    onClick = {
                        item.destination?.let { navController.navigate(it) }
                    }
                )
            }
        }
    }
}


@Composable
fun QuadsView(onDismiss: () -> Unit, navController: NavController)  {
    val quadItems = listOf(
        TheExerciseItem("Breathe & Release: Quads", "3", R.drawable.forward_lunge_prep, "quads1_screen"),
        TheExerciseItem("Happy Quads Stretch", "3", R.drawable.knee_bend_side_lying, "quads2_screen"),
        TheExerciseItem("Untangle Your Quads", "6", R.drawable.quad_stretch_bilateral, "quads3_screen")
    )

    Scaffold { paddingValues ->
        LazyColumn(
            contentPadding = PaddingValues(
                top = paddingValues.calculateTopPadding(),
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onDismiss) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.size(32.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp)) // Adjust spacing as needed

                    Text(
                        text = "Quadriceps",
                        style = MaterialTheme.typography.titleLarge.copy(fontSize = 32.sp),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            items(quadItems) { item ->
                DisplayCard(
                    title = item.title,
                    minutes = item.minutes,
                    imageResId = item.imageResId,
                    onClick = {
                        item.destination?.let { navController.navigate(it) }
                    }
                )
            }
        }
    }
}










