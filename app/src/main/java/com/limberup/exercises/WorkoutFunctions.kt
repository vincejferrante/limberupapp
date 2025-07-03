package com.limberup.exercises

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun MorningWorkoutRoutine(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val morningGlowFlow = listOf(
        FixedExercise("Child's Pose", R.drawable.child_pose, "Sit back on your heels, extend arms forward, and rest forehead on the mat. Relax and breathe deeply.", 60, listOf("Hips", "Back")),
        FixedExercise("Cat-Cow Stretch", R.drawable.cow_pose_1, "On all fours, alternate between arching and rounding your back to warm up the spine.", 60, listOf("Spine", "Core")),
        FixedExercise("Downward-Facing Dog", R.drawable.achilles_stretch_downward_dog, "Lift hips to form an inverted V-shape. Press heels toward the floor.", 60, listOf("Hamstrings", "Calves", "Shoulders")),
        FixedExercise("Low Lunge", R.drawable.lunging_forward_stretch_prayer_hands, "Step one foot forward, keep the back leg extended. Open up the hips and thighs.", 30, listOf("Hips", "Thighs")),
        FixedExercise("Low Lunge (Opposite Side)", R.drawable.lunging_forward_stretch_prayer_hands, "Switch sides and stretch the opposite hip and thigh.", 30, listOf("Hips", "Thighs")),
        FixedExercise("Standing Forward Bend", R.drawable.hamstring_toe_touch, "Fold from the hips, letting your head and arms hang heavy.", 60, listOf("Hamstrings", "Back")),
        FixedExercise("Mountain Pose with Side Stretch", R.drawable.side_bending_mountain_pose, "Stand tall, arms overhead, lean gently to each side.", 60, listOf("Spine", "Sides")),
        FixedExercise("Chair Pose", R.drawable.fierce_pose_extended_tiptoes, "Bend knees deeply as if sitting in a chair. Keep arms overhead. Stand of Tiptoes if needed.", 60, listOf("Legs", "Core")),
        FixedExercise("Seated Forward Bend", R.drawable.shoulder_and_back_curl_seated, "Sit with legs extended and hinge at hips to reach forward.", 60, listOf("Hamstrings", "Spine")),
        FixedExercise("Seated Spinal Twist", R.drawable.chest_rotation_seated, "Cross one leg over and twist toward the top knee to stretch the spine.", 30, listOf("Spine", "Obliques")),
        FixedExercise("Seated Spinal Twist (Opposite Side)", R.drawable.chest_rotation_seated, "Switch sides and twist toward the other knee.", 30, listOf("Spine", "Obliques")),
        FixedExercise("Butterfly Pose", R.drawable.butterfly_knees_heels_to_groin, "Sit with soles of feet together. Press knees down gently.", 60, listOf("Hips", "Groin")),
        FixedExercise("Bridge Pose", R.drawable.bridge_pose, "Lie on your back, feet flat, lift hips up to strengthen back and open chest.", 60, listOf("Glutes", "Spine")),
        FixedExercise("Supine Twist", R.drawable.knee_across_body, "Lie on back, hug knee to chest, then guide it across the body.", 30, listOf("Spine", "Lower Back")),
        FixedExercise("Supine Twist (Opposite Side)", R.drawable.knee_across_body, "Switch sides for a balanced spinal release.", 30, listOf("Spine", "Lower Back")),
        FixedExercise("Corpse Pose", R.drawable.lying_down_arm_stretch, "Lie flat on your back, arms at sides, and relax completely.", 60, listOf("Relaxation"))
    )


    // ✅ Use a MutableStateList to track modifications
    val userExercises = remember { mutableStateListOf(*morningGlowFlow.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Morning Glow Flow", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with the modified exercises
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d("WorkoutNavigation", "Exercises set in ViewModel: ${userExercises.joinToString()}")

                    // ✅ Navigate
                    navController.navigate("WorkoutSlideshow/MorningWorkout")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}

@Composable
fun YogaImprovedFlexibility(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val improvedFlexibilityFlow = listOf(
        FixedExercise(
            name = "Seated Forward Lean",
            displayResId = R.drawable.seated_forward_lean,
            description = "Sit on a ball or chair, spread your legs wide, and lean forward, reaching your arms to the floor.",
            duration = 30,
            muscleGroups = listOf("Lower Back", "Hamstrings")
        ),
        FixedExercise(
            name = "Western Intense Stretch",
            displayResId = R.drawable.western_intense_stretch,
            description = "Sit with legs extended and fold forward to grab your toes. Lengthen your spine as you stretch.",
            duration = 30,
            muscleGroups = listOf("Hamstrings", "Upper Back")
        ),
        FixedExercise(
            name = "Side Stretch Arms Clasped Overhead",
            displayResId = R.drawable.side_stretch_arms_clasped_overhead,
            description = "Stand tall, clasp your hands overhead, and lean side to side, opening your ribs and obliques.",
            duration = 30,
            muscleGroups = listOf("Obliques", "Shoulders")
        ),
        FixedExercise(
            name = "Lunge to the Side",
            displayResId = R.drawable.lunge_to_the_side,
            description = "Step into a wide lunge, lower your torso, and extend one arm overhead for deep side body stretch.",
            duration = 30,
            muscleGroups = listOf("Adductors", "Obliques")
        ),
        FixedExercise(
            name = "Hip Extensor Stretch Seated",
            displayResId = R.drawable.hip_extensor_stretch_seated,
            description = "Sit wide-legged and gently fold forward to stretch your hips and lower back.",
            duration = 30,
            muscleGroups = listOf("Hips", "Lower Back")
        ),
        FixedExercise(
            name = "Garland Pose",
            displayResId = R.drawable.garland_pose_intense_wrist_stretch,
            description = "Sink deep into a squat with hands at heart center, keeping the spine tall and hips open.",
            duration = 30,
            muscleGroups = listOf("Hips", "Lower Back")
        ),
        FixedExercise(
            name = "Spinal Twist Deep Seated",
            displayResId = R.drawable.spinal_twist_deep_seated,
            description = "Cross one leg over the other and twist your torso, looking over your shoulder to release the spine.",
            duration = 30,
            muscleGroups = listOf("Spine", "Upper Back")
        ),
        FixedExercise(
            name = "Shoulder Stretch Kneeling Arms Extended",
            displayResId = R.drawable.shoulder_stretch_kneeling_arms_extended,
            description = "Kneel and extend arms forward, dropping your chest toward the floor for a shoulder-opening stretch.",
            duration = 30,
            muscleGroups = listOf("Shoulders", "Chest")
        ),
        FixedExercise(
            name = "Side Stretch Star Pose",
            displayResId = R.drawable.side_stretch_star_pose,
            description = "Stand wide and reach toward one foot while lifting the opposite arm overhead, twisting slightly upward.",
            duration = 30,
            muscleGroups = listOf("Spine", "Obliques")
        ),
        FixedExercise(
            name = "Upper Back Extension",
            displayResId = R.drawable.upperback_extension,
            description = "Lie on your stomach and lift your chest up, strengthening and stretching your upper back and spine.",
            duration = 30,
            muscleGroups = listOf("Upper Back", "Spine")
        ),
        FixedExercise(
            name = "Knee Across Body",
            displayResId = R.drawable.knee_across_body,
            description = "Lie back and gently pull one knee across your body to stretch the lower back and outer hips.",
            duration = 30,
            muscleGroups = listOf("Glutes", "Lower Back")
        ),
        FixedExercise(
            name = "Western Intense Stretch Palms to Floor",
            displayResId = R.drawable.western_intense_stretch_palms_to_floor,
            description = "Fold forward fully, pressing palms to the ground, deepening your hamstring and spine flexibility.",
            duration = 30,
            muscleGroups = listOf("Hamstrings", "Spine")
        )
    )


    // ✅ Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*improvedFlexibilityFlow.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Flexibility Reset Flow \uD83C\uDF08", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d("WorkoutNavigation", "Exercises set in ViewModel: ${userExercises.joinToString()}")

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Flexibility Reset Flow")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}




@Composable
fun WristReset(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val wristResetExercises = listOf(
        FixedExercise(
            name = "Palm-Up Wrist Stretch",
            displayResId = R.drawable.palm_wup_wrist_stretch,
            description = "Hold your arm straight out and gently pull your fingers back toward your body.",
            duration = 30,
            muscleGroups = listOf("Forearm", "Wrist", "Biceps")
        ),
        FixedExercise(
            name = "Palm-Down Wrist Stretch",
            displayResId = R.drawable.palm_down_wrist_stretch,
            description = "Extend your arm and gently press the back of your hand downward to stretch the top of your wrist.",
            duration = 30,
            muscleGroups = listOf("Wrist", "Forearm")
        ),
        FixedExercise(
            name = "Straight Arm Wrist Stretch",
            displayResId = R.drawable.palm_down_arm_straight_wrist_stretch,
            description = "With your arm extended, gently stretch your wrist down for a deep forearm release.",
            duration = 30,
            muscleGroups = listOf("Forearm", "Wrist")
        ),
        FixedExercise(
            name = "Chair Squat Wrist Stretch",
            displayResId = R.drawable.chair_squat_intense_wrist_stretch_revolved_half_bound,
            description = "Hold a modified chair pose while engaging your wrists with a twist. Keep your breath calm.",
            duration = 30,
            muscleGroups = listOf("Wrist", "Shoulders", "Legs")
        ),
        FixedExercise(
            name = "Garland Wrist Stretch",
            displayResId = R.drawable.garland_pose_intense_wrist_stretch,
            description = "Squat into a deep hip opener while using your arms to stretch the wrists. Stay grounded.",
            duration = 30,
            muscleGroups = listOf("Hips", "Wrists", "Lower Back")
        ),
        FixedExercise(
            name = "Wrist Strength Crane Hold",
            displayResId = R.drawable.intense_wrist_crane_pose,
            description = "Engage your core and wrists in a brief crane prep. Focus on balance and control.",
            duration = 20,
            muscleGroups = listOf("Wrists", "Core", "Shoulders")
        )
    )


    // ✅ Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*wristResetExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Desk Wrist Detox \uD83D\uDCBB\uD83D\uDD90\uFE0F", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d("WorkoutNavigation", "Exercises set in ViewModel: ${userExercises.joinToString()}")

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Desk Wrist Detox")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}



@Composable
fun TechNeck(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise(
            name = "Neck Flexor & Rotational Stretch",
            displayResId = R.drawable.neck_flexor_and_rotationa,
            description = "Sit or stand tall. Gently pull your head to one side, hold, and then switch.",
            duration = 30,
            muscleGroups = listOf("Neck")
        ),
        FixedExercise(
            name = "Neck Hyperextension",
            displayResId = R.drawable.neck_hyperextension,
            description = "With upright posture, slowly push your chin forward and hold.",
            duration = 20,
            muscleGroups = listOf("Neck")
        ),
        FixedExercise(
            name = "Side-Assisted Neck Tilt",
            displayResId = R.drawable.side_assisted_neck_tilt,
            description = "Gently tilt your head sideways using your hand. Breathe and release neck tension.",
            duration = 30,
            muscleGroups = listOf("Neck")
        ),
        FixedExercise(
            name = "Shoulder Blade Pinch",
            displayResId = R.drawable.shoulder_blade_pinch,
            description = "Sit or stand tall. Pinch shoulder blades together and hold.",
            duration = 20,
            muscleGroups = listOf("Shoulders", "Upper Back")
        ),
        FixedExercise(
            name = "Shoulder Stretch Kneeling Arms Extended",
            displayResId = R.drawable.shoulder_stretch_kneeling_arms_extended,
            description = "On all fours, walk hands forward and sit back to open the shoulders.",
            duration = 30,
            muscleGroups = listOf("Shoulders", "Upper Back")
        ),
        FixedExercise(
            name = "Upward Assisted Neck Tilt",
            displayResId = R.drawable.upward_assisted_neck_tilt,
            description = "Tilt your head back and to the side while gently guiding it with your hand.",
            duration = 30,
            muscleGroups = listOf("Neck", "Upper Back")
        ),
        FixedExercise(
            name = "Spinal Curve with Feet on Ball",
            displayResId = R.drawable.spinal_curve_with_feet_on_ball,
            description = "Sit on a stability ball and drop your head and shoulders forward to round the back.",
            duration = 30,
            muscleGroups = listOf("Spine", "Upper Back")
        ),
        FixedExercise(
            name = "Bound One-Legged Pose",
            displayResId = R.drawable.hands_bound_one_legged_half_eastern_intense_stretch_pose,
            description = "Lean back, lift hips, bind forearms, and open up the chest and neck.",
            duration = 30,
            muscleGroups = listOf("Chest", "Neck", "Triceps")
        )
    )

    // ✅ Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Tech Neck Relief \uD83D\uDCBB\uD83E\uDDD8\u200D♂\uFE0F", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d("WorkoutNavigation", "Exercises set in ViewModel: ${userExercises.joinToString()}")

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Tech Neck Relief")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}



@Composable
fun CoreOne(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise(
            name = "Hands Bound Half Pose",
            displayResId = R.drawable.hands_bound_half_eastern_intense_stretch_pose,
            description = "Sit with knees bent and lean back onto your elbows. Bind your forearms together and lift your hips, stepping your feet away to align knees, hips, and shoulders. Place one foot on the opposite knee and open the chest. Hold, then switch legs.",
            duration = 15,
            muscleGroups = listOf("Abdominals", "Chest", "Hip Flexors")
        ),
        FixedExercise(
            name = "Bound One-Legged Pose",
            displayResId = R.drawable.hands_bound_one_legged_half_eastern_intense_stretch_pose,
            description = "Seated with knees bent, lean onto your elbows and bind your forearms. Lift your hips and align your torso. Draw your shoulders back and drop your head to deepen the chest and neck stretch. Hold steadily.",
            duration = 15,
            muscleGroups = listOf("Abdominals", "Chest", "Neck")
        ),
        FixedExercise(
            name = "Knee-Up Half Eastern Stretch",
            displayResId = R.drawable.half_eastern_intense_stretch_pose_knee_up,
            description = "Seated with knees bent and hands behind you, press into the floor to lift your hips. Cross one foot over the opposite knee. Drop your head back and draw your chest upward to deepen the stretch.",
            duration = 20,
            muscleGroups = listOf("Abdominals", "Chest", "Shoulders")
        ),
        FixedExercise(
            name = "Tiptoe Eastern Stretch Pose",
            displayResId = R.drawable.eastern_intense_stretch_pose_tiptoes,
            description = "Sit with knees bent and palms flat behind you, fingers pointing backward. Lift onto your tiptoes and fingertips, then raise your hips and open your chest, letting your head fall gently back.",
            duration = 20,
            muscleGroups = listOf("Abdominals", "Chest", "Shoulders")
        ),
        FixedExercise(
            name = "Hip Raise",
            displayResId = R.drawable.hip_raise,
            description = "Lie on your back with knees bent and legs lifted toward the ceiling. Engage your core and use your upper back to lift your hips, extending your legs overhead. Hold, then lower back down.",
            duration = 30,
            muscleGroups = listOf("Abdominals", "Hip Flexors", "Core")
        )
    )

    // ✅ Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Core Uplift Circuit \uD83D\uDCAA✨", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d("WorkoutNavigation", "Exercises set in ViewModel: ${userExercises.joinToString()}")

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Core Uplift Circuit")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}


@Composable
fun CoreTwo(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise(
            name = "Leg Extended Crunch",
            displayResId = R.drawable.leg_extended_crunch,
            description = "Lie on your back with legs raised. Crunch your upper body toward your knees while keeping your shoulders lifted.",
            duration = 30,
            muscleGroups = listOf("Abdominals")
        ),
        FixedExercise(
            name = "Plank Forearm",
            displayResId = R.drawable.plank_forearm,
            description = "Hold a forearm plank with hips aligned, engaging your entire core.",
            duration = 30,
            muscleGroups = listOf("Abdominals", "Shoulders")
        ),
        FixedExercise(
            name = "Leg Lifts",
            displayResId = R.drawable.leg_lifts,
            description = "Lie flat on your back. Extend one leg at a 45° angle and alternate sides while crunching up.",
            duration = 30,
            muscleGroups = listOf("Abdominals", "Hip Flexors")
        ),
        FixedExercise(
            name = "Shoulder Bridge",
            displayResId = R.drawable.shoulder_bridge,
            description = "Press your feet into the floor and lift your hips up to engage the core and glutes.",
            duration = 30,
            muscleGroups = listOf("Abdominals", "Glutes")
        ),
        FixedExercise(
            name = "Leg Extended with Band",
            displayResId = R.drawable.leg_extended_with_band_or_towel,
            description = "Sit upright with legs straight and resistance band around feet. Pull band into your chest while leaning back.",
            duration = 30,
            muscleGroups = listOf("Abdominals", "Lower Back")
        ),
        FixedExercise(
            name = "Upper Back Extension",
            displayResId = R.drawable.upperback_extension,
            description = "Lie on your stomach and lift your chest off the ground using your core and back muscles.",
            duration = 20,
            muscleGroups = listOf("Upper Back", "Abdominals")
        ),
        FixedExercise(
            name = "Side Plank Easy",
            displayResId = R.drawable.side_plank_easy,
            description = "Support yourself on your forearm and knee. Raise the top arm and hold.",
            duration = 30,
            muscleGroups = listOf("Obliques", "Abdominals")
        ),
        FixedExercise(
            name = "Sit-Ups with Band",
            displayResId = R.drawable.sit_ups_with_band,
            description = "Lie flat with resistance band around your ankles. Perform controlled sit-ups while keeping the band taut.",
            duration = 30,
            muscleGroups = listOf("Abdominals")
        )
    )


    // ✅ Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Strong Center Power \uD83D\uDD25", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d("WorkoutNavigation", "Exercises set in ViewModel: ${userExercises.joinToString()}")

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Strong Center Power")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}


@Composable
fun CoreThree(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise(
            name = "Torso Twist",
            displayResId = R.drawable.torso_twist,
            description = "Stand tall and twist side to side, touching opposite foot with your hand. Engage your core and move with control.",
            duration = 30,
            muscleGroups = listOf("Spine", "Obliques", "Abdominals")
        ),
        FixedExercise(
            name = "Trunk Rotator",
            displayResId = R.drawable.trunk_rotator,
            description = "Stand with elbows bent and fists in front of your chest. Rotate from side to side while keeping hips square.",
            duration = 30,
            muscleGroups = listOf("Spine", "Obliques")
        ),
        FixedExercise(
            name = "Side Plank Chest Opener",
            displayResId = R.drawable.side_plank_chest_opener,
            description = "From a side plank position, raise your top arm and optionally stack your feet. Hold with control.",
            duration = 30,
            muscleGroups = listOf("Obliques", "Chest", "Abdominals")
        ),
        FixedExercise(
            name = "Upper Back Extension with Clenched Fingers",
            displayResId = R.drawable.upperback_extension_with_clenched_fingers_advanced,
            description = "Lie face down and lift your upper body while raising clasped hands behind you. Squeeze your core and glutes.",
            duration = 30,
            muscleGroups = listOf("Upper Back", "Core")
        ),
        FixedExercise(
            name = "Thunderbolt Pose Tiptoe",
            displayResId = R.drawable.thunderbolt_pose_tiptoe,
            description = "Balance on your tiptoes with hands behind you. Drop the head back and lift your chest to challenge core control.",
            duration = 30,
            muscleGroups = listOf("Chest", "Abdominals")
        ),
        FixedExercise(
            name = "Shoulder Bridge Pelvic Press",
            displayResId = R.drawable.shoulder_bridge_pelvic_press_with_band,
            description = "Press hips up while rounding the spine. Use a band for resistance if available.",
            duration = 30,
            muscleGroups = listOf("Abdominals", "Spine")
        ),
        FixedExercise(
            name = "Side Twist with Clasped Hands",
            displayResId = R.drawable.side_twist_with_clasped_hand_seated,
            description = "Sit upright, clasp your hands, and twist slowly side to side while maintaining a tall spine.",
            duration = 30,
            muscleGroups = listOf("Obliques", "Latissimus Dorsi")
        )
    )


    // ✅ Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Dynamic Core Awakening ✨", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d("WorkoutNavigation", "Exercises set in ViewModel: ${userExercises.joinToString()}")

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Dynamic Core Awakening")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}


@Composable
fun CoreFour(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise(
            name = "Leg Extended Crunch",
            displayResId = R.drawable.leg_extended_crunch,
            description = "Lie on your back with legs raised. Crunch up and reach toward your toes. Keep shoulders lifted throughout.",
            duration = 30,
            muscleGroups = listOf("Abdominals")
        ),
        FixedExercise(
            name = "Side Plank Extended Split",
            displayResId = R.drawable.side_plank_extended_split,
            description = "From side plank, extend top leg and optionally reach for your foot. Engage obliques and stabilize.",
            duration = 30,
            muscleGroups = listOf("Obliques", "Core", "Shoulders")
        ),
        FixedExercise(
            name = "Tricep Dips Low",
            displayResId = R.drawable.tricep_dips_low,
            description = "Use a low surface behind you. Lower and lift your body while keeping your core braced.",
            duration = 30,
            muscleGroups = listOf("Triceps", "Abdominals", "Chest")
        ),
        FixedExercise(
            name = "Thunderbolt Pose Tiptoe",
            displayResId = R.drawable.thunderbolt_pose_tiptoe,
            description = "Kneel and lift onto tiptoes, leaning back with arms extended behind. Maintain core and spine control.",
            duration = 30,
            muscleGroups = listOf("Abdominals", "Spine")
        ),
        FixedExercise(
            name = "Upper Back Extension",
            displayResId = R.drawable.upperback_extension,
            description = "Lie face down and lift your chest using only your back and core muscles. Hands float off floor.",
            duration = 30,
            muscleGroups = listOf("Upper Back", "Core")
        ),
        FixedExercise(
            name = "Side Twist Curved Spine",
            displayResId = R.drawable.side_twist_curved_spine,
            description = "Sit on a ball or mat, hands behind head. Curve spine gently as you twist from side to side.",
            duration = 30,
            muscleGroups = listOf("Spine", "Obliques")
        ),
        FixedExercise(
            name = "Side Plank Easier Modification",
            displayResId = R.drawable.side_plank_easier_modification,
            description = "Support yourself with one knee and one arm. Lift the top leg and arm for added challenge.",
            duration = 30,
            muscleGroups = listOf("Obliques", "Abdominals")
        )
    )


    // ✅ Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Strong Core, Gentle Flow \uD83C\uDF0A", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d("WorkoutNavigation", "Exercises set in ViewModel: ${userExercises.joinToString()}")

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Strong Core Gentle Flow")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}


@Composable
fun NeckOne(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise(
            name = "Side Assisted Neck Tilt",
            displayResId = R.drawable.side_assisted_neck_tilt,
            description = "Sit or stand tall. Use one hand to gently guide your head sideways toward your shoulder. Hold and breathe.",
            duration = 30,
            muscleGroups = listOf("Neck")
        ),
        FixedExercise(
            name = "Upward Assisted Neck Tilt",
            displayResId = R.drawable.upward_assisted_neck_tilt,
            description = "Gently tilt your head diagonally up and away, using your hand for support. Open the front of the neck.",
            duration = 30,
            muscleGroups = listOf("Neck")
        ),
        FixedExercise(
            name = "Neck Flexor & Rotational Stretch",
            displayResId = R.drawable.neck_flexor_and_rotationa,
            description = "Pull your head gently downward and to the side to release the deep front and side neck muscles.",
            duration = 30,
            muscleGroups = listOf("Neck")
        ),
        FixedExercise(
            name = "Neck Hyperextension",
            displayResId = R.drawable.neck_hyperextension,
            description = "Without using your hands, slowly push your chin forward and tilt your head back to stretch the neck.",
            duration = 30,
            muscleGroups = listOf("Neck")
        ),
        FixedExercise(
            name = "Spine and Shoulder Twist Advanced",
            displayResId = R.drawable.spine_and_shoulder_twist_advanced,
            description = "Lie on your stomach, arms out. Twist your leg over your body to deepen spinal and shoulder release.",
            duration = 30,
            muscleGroups = listOf("Spine", "Neck")
        ),
        FixedExercise(
            name = "Side Twist Curved Spine",
            displayResId = R.drawable.side_twist_curved_spine,
            description = "Sit tall, then drop shoulders gently as you curve the spine sideways. Opens side body and releases tension.",
            duration = 30,
            muscleGroups = listOf("Neck", "Spine")
        )
    )


    // ✅ Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Gentle Neck Reset \uD83C\uDF38", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d("WorkoutNavigation", "Exercises set in ViewModel: ${userExercises.joinToString()}")

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Gentle Neck Reset")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}

@Composable
fun NeckTwo(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise(
            name = "Shoulder Stretch Hands to Elbows",
            displayResId = R.drawable.shoulder_stretch_hands_to_elbows,
            description = "Reach both arms behind your back and clasp opposite elbows. Pull gently down to open the chest and relieve upper neck tension.",
            duration = 30,
            muscleGroups = listOf("Shoulders", "Neck")
        ),
        FixedExercise(
            name = "Side Twist With Clasped Hands",
            displayResId = R.drawable.side_twist_with_clasped_hand_seated,
            description = "Sit tall and twist your upper body to one side with hands clasped overhead. Great for resetting posture and easing neck tightness.",
            duration = 30,
            muscleGroups = listOf("Neck", "Spine")
        ),
        FixedExercise(
            name = "Shoulder Stretch Overhead Side Reach Seated",
            displayResId = R.drawable.shoulder_stretch_overhead_side_reach_to_floor_seated,
            description = "Seated on a chair, bend forward and twist to one side, placing hands on the floor. Helps reduce lateral neck compression.",
            duration = 30,
            muscleGroups = listOf("Neck", "Shoulders")
        ),
        FixedExercise(
            name = "Prayer Hands Stretch",
            displayResId = R.drawable.prayer_hands,
            description = "Press your palms together at chest level. Focus on upright posture and activating shoulder retractors. Great neck reset.",
            duration = 20,
            muscleGroups = listOf("Forearms", "Neck")
        ),
        FixedExercise(
            name = "Side Assisted Neck Tilt",
            displayResId = R.drawable.side_assisted_neck_tilt,
            description = "Finish with this soothing tilt. Let gravity and light hand pressure melt away lingering tension.",
            duration = 30,
            muscleGroups = listOf("Neck")
        )
    )

    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Tension Release Flow \uD83E\uDDD8\u200D♂\uFE0F", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d("WorkoutNavigation", "Exercises set in ViewModel: ${userExercises.joinToString()}")

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Tension Release Flow")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}


@Composable
fun ChestOne(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise(
            name = "Inverse Plank Chest Opener",
            displayResId = R.drawable.inverse_plank_chest_opener,
            description = "Sit with your legs extended and hands behind you. Lift your hips and open your chest toward the ceiling. Breathe deeply.",
            duration = 30,
            muscleGroups = listOf("Chest", "Shoulders")
        ),
        FixedExercise(
            name = "Side Plank Chest Opener",
            displayResId = R.drawable.side_plank_chest_opener,
            description = "Lift into a side plank and extend your top arm high. Open the chest and shoulders while engaging your core.",
            duration = 30,
            muscleGroups = listOf("Chest", "Obliques")
        ),
        FixedExercise(
            name = "Reverse Prayer Revolved Uneven Legs",
            displayResId = R.drawable.reverse_prayer_revolved_uneven_legs_half_intense_stretch,
            description = "Join your palms behind your back in prayer, then twist and fold forward. Expand across the chest and shoulders.",
            duration = 30,
            muscleGroups = listOf("Chest", "Shoulders")
        ),
        FixedExercise(
            name = "Chest Stretch with Arms Bound",
            displayResId = R.drawable.intense_stretch_pose_with_chest_opener_bound,
            description = "Fold forward and twist while keeping a bind with your hands. Deep chest opening and spinal twist.",
            duration = 30,
            muscleGroups = listOf("Chest", "Spine")
        ),
        FixedExercise(
            name = "Western Intense Stretch Upward Half Dog",
            displayResId = R.drawable.western_intense_stretch_upward_half_dog,
            description = "Balance on your sit bones and extend legs up while holding your feet. Lift your chest and gaze up.",
            duration = 30,
            muscleGroups = listOf("Chest", "Upper Back")
        ),
        FixedExercise(
            name = "Shoulder Stretch Crouching",
            displayResId = R.drawable.shoulder_stretch_crouching,
            description = "Crouch with clasped hands behind your back and fold forward. Let gravity gently pull the arms up.",
            duration = 30,
            muscleGroups = listOf("Chest", "Shoulders")
        )
    )


    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Freedom Through the Heart \uD83D\uDC96", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d("WorkoutNavigation", "Exercises set in ViewModel: ${userExercises.joinToString()}")

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Freedom Through the Heart")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}

@Composable
fun ChestTwo(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise("Shoulder Stretch Kneeling Arms Extended", R.drawable.shoulder_stretch_kneeling_arms_extended, "Kneel and walk your arms forward, letting your chest drop toward the ground.", 30, listOf("Chest", "Shoulders")),
        FixedExercise("Revolved Triangle", R.drawable.revolved_triangle, "Twist through the torso and open the chest as you reach upward.", 30, listOf("Chest", "Spine")),
        FixedExercise("Rabbit Pose Shoulder Stretch", R.drawable.rabbit_pose_shoulder_sretch, "Reach behind and lift your hands to open your chest deeply.", 30, listOf("Chest", "Shoulders")),
        FixedExercise("Side Stretch Star Pose", R.drawable.side_stretch_star_pose, "Lengthen through your side body while turning your gaze up to fully open the chest.", 30, listOf("Chest", "Obliques")),
        FixedExercise("Shoulder Bridge Bound", R.drawable.shoulder_bridge_bound, "Push through the feet and open the chest as you lift the hips. Grab your ankles for a deeper stretch.", 30, listOf("Chest", "Spine"))
    )

    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Radiant Chest Opener \uD83C\uDF1E", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d("WorkoutNavigation", "Exercises set in ViewModel: ${userExercises.joinToString()}")

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Radiant Chest Opener")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}

@Composable
fun ChestThree(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise("Plank Forearm", R.drawable.plank_forearm, "Hold your core tight and chest lifted off the floor. Stay steady and breathe deeply.", 30, listOf("Chest", "Abdominals", "Shoulders")),
        FixedExercise("Side Plank Chest Opener", R.drawable.side_plank_chest_opener, "Lift your hips and open your chest toward the ceiling. Stack your feet if possible.", 30, listOf("Chest", "Obliques")),
        FixedExercise("Tricep Dips High", R.drawable.tricep_dips_high, "Engage your chest and triceps as you lower and lift slowly.", 30, listOf("Chest", "Triceps")),
        FixedExercise("Leg Raise Superman", R.drawable.leg_raise_superman, "Lift opposite arm and leg, hold and engage upper body strength.", 30, listOf("Chest", "Lower Back")),
        FixedExercise("Inverse Plank Chest Opener", R.drawable.inverse_plank_chest_opener, "Open your chest while maintaining hip lift. Keep your arms strong and engaged.", 30, listOf("Chest", "Shoulders"))
    )

    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Upper Body Lift-Off \uD83D\uDE80", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d("WorkoutNavigation", "Exercises set in ViewModel: ${userExercises.joinToString()}")

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Upper Body Lift-Off")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}



@Composable
fun PostureOne(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise("Shoulder Stretch Kneeling Arms Extended", R.drawable.shoulder_stretch_kneeling_arms_extended, "Kneel on all fours and reach forward to stretch shoulders and spine.", 30, listOf("Shoulders", "Upper Back")),
        FixedExercise("Seated Spinal Stretch", R.drawable.seated_spinal_stretch, "Sit cross-legged and twist gently to release spinal tension.", 20, listOf("Spine")),
        FixedExercise("Neck Flexor & Rotational Stretch", R.drawable.neck_flexor_and_rotationa, "Sit or stand tall and stretch the neck side to side.", 30, listOf("Neck")),
        FixedExercise("Upper Back Reaching", R.drawable.upperback_reaching, "Pull against a doorway for an upper back release.", 20, listOf("Upper Back")),
        FixedExercise("Shoulder Blade Pinch", R.drawable.shoulder_blade_pinch, "Pinch shoulder blades together to activate posture muscles.", 20, listOf("Shoulders"))
    )

    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Posture Reset Flow \uD83E\uDDD8\u200D♂\uFE0F", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d("WorkoutNavigation", "Exercises set in ViewModel: ${userExercises.joinToString()}")

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Posture Reset Flow")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}

@Composable
fun PostureTwo(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise("Chest Opener Side Plank", R.drawable.side_plank_chest_opener, "Open the front body and build support in side plank.", 30, listOf("Obliques", "Chest")),
        FixedExercise("Inverse Plank Chest Opener", R.drawable.inverse_plank_chest_opener, "Lift hips and expand the chest with support from arms.", 30, listOf("Chest", "Shoulders")),
        FixedExercise("Shoulder Stretch Crouching", R.drawable.shoulder_stretch_crouching, "Clasp hands behind back and fold forward to open shoulders.", 30, listOf("Shoulders")),
        FixedExercise("Neck Hyperextension", R.drawable.neck_hyperextension, "Gently push the chin forward and hold.", 20, listOf("Neck")),
        FixedExercise("Seated Forward Lean on Ball", R.drawable.seated_forward_lean, "Lean forward with support to decompress the spine.", 30, listOf("Lower Back"))
    )

    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Anti-Hunch Flow \uD83C\uDFCB\uFE0F", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d("WorkoutNavigation", "Exercises set in ViewModel: ${userExercises.joinToString()}")

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Anti-Hunch Flow")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}

@Composable
fun PostureThree(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise("Mountain Pose with Shoulder Opener", R.drawable.mountain_pose_with_shoulder_opener, "Stand tall and gently stretch one shoulder overhead.", 30, listOf("Shoulders", "Neck")),
        FixedExercise("Thoracic Rotation", R.drawable.thoracic_rotation, "Twist gently from all fours to mobilize the mid-back.", 20, listOf("Spine")),
        FixedExercise("Upper Back Extension", R.drawable.upperback_extension, "Lift chest from floor without hands to activate posture muscles.", 20, listOf("Upper Back")),
        FixedExercise("Wrist Bend", R.drawable.wrist_bend, "Loosen tension in the wrists from desk posture.", 15, listOf("Wrists")),
        FixedExercise("Prayer Hands", R.drawable.prayer_hands, "Center shoulders and chest in a simple mindful hold.", 30, listOf("Forearms", "Shoulders"))
    )

    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Posture Flexibility \uD83E\uDD38", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d("WorkoutNavigation", "Exercises set in ViewModel: ${userExercises.joinToString()}")

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Posture Flexibility")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}


@Composable
fun HipsOne(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise("Kneeling Half Split", R.drawable.kneeling_half_split, "Kneel and extend one leg forward, gently reaching for your toes.", 30, listOf("Adductors")),
        FixedExercise("Hip Internal Rotator Alternating Legs", R.drawable.hip_internal_rotator_alternating_legs, "Lay on your back and alternate knee drops inward.", 30, listOf("Abductors")),
        FixedExercise("Horizontal Split Reclined Side Angle", R.drawable.horizontal_split_reclined_side_angle, "Lie back, raise legs, and gently spread into a wide split.", 30, listOf("Adductors")),
        FixedExercise("Hip Rotation", R.drawable.hip_rotation, "Stand tall and twist from side to side at the hips.", 30, listOf("Abductors")),
        FixedExercise("Half Split with Forward Bend", R.drawable.half_split_with_forward_bend, "Stretch one leg sideways and fold forward into a deep hamstring opener.", 30, listOf("Adductors"))
    )

    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Hip Mobility Builder \uD83D\uDD13", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d("WorkoutNavigation", "Exercises set in ViewModel: ${userExercises.joinToString()}")

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Hip Mobility Builder")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}

@Composable
fun HipsTwo(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise("Hip Extensor Stretch Seated", R.drawable.hip_extensor_stretch_seated, "Sit wide-legged and gently fold forward for a deep hip stretch.", 30, listOf("Adductors")),
        FixedExercise("Lateral Leg Raise 1", R.drawable.lateral_leg_raise_1, "Lay on your back and raise one leg toward your chest.", 20, listOf("Glutes")),
        FixedExercise("Knee Across Body", R.drawable.knee_across_body, "Lie back and twist the knee across the body for a spinal and hip release.", 30, listOf("Glutes")),
        FixedExercise("Tiptoe Stretch", R.drawable.tiptoe_stretch, "Crouch low and hold on tiptoes to release pressure from the hips.", 30, listOf("Adductors")),
        FixedExercise("Kali Squat Revolved", R.drawable.kali_squat_revolved, "Sink into a wide squat and twist from side to side to stretch inner hips.", 30, listOf("Adductors")),
        FixedExercise("Horizontal Split Reclined Side Angle", R.drawable.horizontal_split_reclined_side_angle, "Lie back, raise legs, and gently spread into a wide split.", 30, listOf("Adductors")),
        FixedExercise("Hip Rotation", R.drawable.hip_rotation, "Stand tall and twist from side to side at the hips.", 30, listOf("Abductors"))
    )


    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Hip Freedom Flow \uD83D\uDD4A\uFE0F", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d("WorkoutNavigation", "Exercises set in ViewModel: ${userExercises.joinToString()}")

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Hip Freedom Flow")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}

@Composable
fun HipsThree(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise("Kneeling Reach", R.drawable.kneeling_reach, "Stretch shoulders and hips while kneeling and folding forward.", 30, listOf("Upper Back", "Hips")),
        FixedExercise("Intense Ankle Stretch Extended Leg to Side", R.drawable.intense_ankle_stretch_extended_leg_to_side_1, "Hold a deep side squat to open hips and ankles.", 30, listOf("Adductors")),
        FixedExercise("Half Split Standing", R.drawable.half_split_standing, "Rest one leg on a chair and gently stretch the hips.", 20, listOf("Adductors")),
        FixedExercise("Leg Cradle", R.drawable.leg_cradle, "Pull your bent leg up to the chest in a seated position to cradle the hip.", 20, listOf("Abductors")),
        FixedExercise("Lunge to the Side", R.drawable.lunge_to_the_side, "Drop into a deep side lunge and reach overhead for a dynamic stretch.", 30, listOf("Obliques", "Hips"))
    )


    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Daily Hip Maintenance Flow \uD83D\uDD01", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d("WorkoutNavigation", "Exercises set in ViewModel: ${userExercises.joinToString()}")

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Daily Hip Maintenance Flow")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}


@Composable
fun SholderOne(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise("Shoulder Stretch Hands to Elbows", R.drawable.shoulder_stretch_hands_to_elbows, "Sit cross-legged and clasp opposite elbows behind your back.", 30, listOf("Shoulders")),
        FixedExercise("Shoulder Stretch Crouching", R.drawable.shoulder_stretch_crouching, "Bend your knees and lean down with clasped hands for deep relief.", 30, listOf("Shoulders")),
        FixedExercise("Shoulder Stretch Kneeling Arms Extended", R.drawable.shoulder_stretch_kneeling_arms_extended, "Kneel and walk hands forward, dropping chest and shoulders down.", 30, listOf("Shoulders")),
        FixedExercise("Shoulder Stretch Overhead Reach to Floor Seated", R.drawable.shoulder_stretch_overhead_reach_to_floor_seated, "Sit and fold forward with arms extended between your legs.", 30, listOf("Shoulders")),
        FixedExercise("Prayer Hands", R.drawable.prayer_hands, "Hold your palms together in front of your chest to reset tension.", 20, listOf("Forearms", "Shoulders"))
    )


    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Shoulder Relief Flow \uD83D\uDC86\u200D♀\uFE0F", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d("WorkoutNavigation", "Exercises set in ViewModel: ${userExercises.joinToString()}")

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Shoulder Relief Flow")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}

@Composable
fun SholderTwo(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise("Interlaced Finger Stretch", R.drawable.interlaced_finger_stretch, "Stretch your arms out with fingers laced and palms forward.", 30, listOf("Wrists", "Shoulders")),
        FixedExercise("Shoulder Stretch Body Bar Twist", R.drawable.shoulder_stretch_body_bar_twist, "Use a body bar or broomstick to rotate shoulders safely.", 30, listOf("Shoulders")),
        FixedExercise("Rear Arm Stretch with Band", R.drawable.rear_arm_stretch_with_band, "Stretch arms behind the back using a resistance band.", 30, listOf("Triceps and Biceps", "Shoulders")),
        FixedExercise("Shoulder Hyperextension 2", R.drawable.shoulder_hyperextension_2, "Press wrists into your waist and pull elbows forward.", 30, listOf("Shoulders")),
        FixedExercise("Seated Large Arm Circles", R.drawable.seated_large_arm_circles, "Circle arms wide while seated to increase shoulder fluidity.", 30, listOf("Shoulders"))
    )


    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Shoulder Mobility Builder \uD83D\uDD04", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d("WorkoutNavigation", "Exercises set in ViewModel: ${userExercises.joinToString()}")

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Shoulder Mobility Builder")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}

@Composable
fun SholderThree(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise("Shoulder and Back Curl Seated", R.drawable.shoulder_and_back_curl_seated, "Round your back forward with hands beside knees.", 30, listOf("Upper Back", "Shoulders")),
        FixedExercise("Shoulder Blade Pinch", R.drawable.shoulder_blade_pinch, "Pinch shoulder blades together while hands rest behind your head.", 20, listOf("Shoulders")),
        FixedExercise("Supported Arm Twist", R.drawable.supported_arm_twist, "Twist your torso using a wall for shoulder and spine relief.", 30, listOf("Shoulders")),
        FixedExercise("Shoulder Traction", R.drawable.shoulder_traction, "Gently pull against a door frame to relieve shoulder tension.", 30, listOf("Shoulders")),
        FixedExercise("Wrist Extensor Assisted", R.drawable.wrist_extensor_assisted, "Stretch wrists and arms outward to ease typing strain.", 20, listOf("Wrists", "Forearms"))
    )


    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Desk Reset: Shoulder Recovery \uD83D\uDCBB", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d("WorkoutNavigation", "Exercises set in ViewModel: ${userExercises.joinToString()}")

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Desk Reset: Shoulder Recovery")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}

@Composable
fun SholderFour(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise("Shoulder Reach Behind Back", R.drawable.shoulder_reach_behind_back, "Clasp hands behind your back and pull shoulders back.", 30, listOf("Shoulders")),
        FixedExercise("Mountain Pose with Shoulder Opener", R.drawable.mountain_pose_with_shoulder_opener, "Reach behind your head and gently pull your elbow.", 30, listOf("Latissimus Dorsi")),
        FixedExercise("Shoulder Flexor", R.drawable.shoulder_flexor, "Pull arms behind your back to engage and open the shoulders.", 30, listOf("Shoulders")),
        FixedExercise("Shoulder Flexor and Depressor Stretch Supported", R.drawable.shoulder_flexor_and_depressor_stretch_supported, "Stand in a corner and press arms up and forward to open chest.", 30, listOf("Shoulders")),
        FixedExercise("Upper Back Twist Arms Extended on Ball", R.drawable.upperback_twist_arms_extended_on_ball, "Twist with arms wide on a stability ball to realign the spine and shoulders.", 30, listOf("Upper Back", "Shoulders"))
    )


    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Posture Reset: Shoulder Alignment \uD83C\uDFAF", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d("WorkoutNavigation", "Exercises set in ViewModel: ${userExercises.joinToString()}")

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Posture Reset Shoulder Alignment")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}


@Composable
fun UpperBackOne(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise("Upper Back Extension", R.drawable.upperback_extension, "Lift your chest from the floor using upper back muscles.", 20, listOf("Upper Back")),
        FixedExercise("Shoulder and Back Curl Seated", R.drawable.shoulder_and_back_curl_seated, "Curl forward while seated, stretching the upper back.", 30, listOf("Upper Back")),
        FixedExercise("Hands Bound Forward Stretch Modification", R.drawable.hands_bount_forward_stretch_moidification, "Fold forward with clasped hands to release upper back tension.", 30, listOf("Hamstrings", "Upper Back")),
        FixedExercise("Upper Back Spine Stretch Crouching", R.drawable.upperback_spine_stretch_crouching, "Crouch and push upper back upward while pulling head down.", 30, listOf("Spine")),
        FixedExercise("Prayer Hands", R.drawable.prayer_hands, "A calming close: hold palms together and breathe into your spine.", 20, listOf("Forearms", "Upper Back"))
    )

    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Upper Back Relief Flow \uD83E\uDDD8\u200D♂\uFE0F", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d(
                        "WorkoutNavigation",
                        "Exercises set in ViewModel: ${userExercises.joinToString()}"
                    )

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Upper Back Relief Flow")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}

@Composable
fun UpperBackTwo(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise("Upper Back Extension with Clenched Fingers", R.drawable.upperback_extension_with_clenched_fingers_advanced, "Lift upper body while pulling hands behind for mobility.", 20, listOf("Upper Back")),
        FixedExercise("Shoulder Stretch Kneeling Arms Extended", R.drawable.shoulder_stretch_kneeling_arms_extended, "Reach forward from a kneeling pose to increase shoulder range.", 30, listOf("Shoulders", "Upper Back")),
        FixedExercise("Upper Back Reaching", R.drawable.upperback_reaching, "Pull away from the door frame for upper back opening.", 30, listOf("Upper Back")),
        FixedExercise("Spinal Curve with Feet on Ball", R.drawable.spinal_curve_with_feet_on_ball, "Round your upper spine while seated on a ball.", 30, listOf("Spine", "Upper Back")),
        FixedExercise("Lat and Upper Back Stretch in Child’s Pose", R.drawable.lat_and_upper_back_stretch_in_child_s_pose, "Drop into child’s pose while rotating for full back opening.", 30, listOf("Latissimus Dorsi", "Upper Back"))
    )


    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Upper Back Mobility Builder \uD83D\uDD04", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d(
                        "WorkoutNavigation",
                        "Exercises set in ViewModel: ${userExercises.joinToString()}"
                    )

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Upper Back Mobility Builder")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}

@Composable
fun UpperBackThree(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise("Upper Back Extension with Clenched Fingers", R.drawable.upperback_extension_with_clenched_fingers_advanced, "Lift upper body while pulling hands behind for mobility.", 20, listOf("Upper Back")),
        FixedExercise("Shoulder Stretch Kneeling Arms Extended", R.drawable.shoulder_stretch_kneeling_arms_extended, "Reach forward from a kneeling pose to increase shoulder range.", 30, listOf("Shoulders", "Upper Back")),
        FixedExercise("Upper Back Reaching", R.drawable.upperback_reaching, "Pull away from the door frame for upper back opening.", 30, listOf("Upper Back")),
        FixedExercise("Spinal Curve with Feet on Ball", R.drawable.spinal_curve_with_feet_on_ball, "Round your upper spine while seated on a ball.", 30, listOf("Spine", "Upper Back")),
        FixedExercise("Lat and Upper Back Stretch in Child’s Pose", R.drawable.lat_and_upper_back_stretch_in_child_s_pose, "Drop into child’s pose while rotating for full back opening.", 30, listOf("Latissimus Dorsi", "Upper Back"))
    )



    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Upper Back Mobility Builder \uD83D\uDD04",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Focus on opening up the thoracic spine and shoulders for better movement.",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontStyle = FontStyle.Italic
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d(
                        "WorkoutNavigation",
                        "Exercises set in ViewModel: ${userExercises.joinToString()}"
                    )

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Upper Back Mobility Builder")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}

@Composable
fun UpperBackFour(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise("Shoulder and Back Curl Seated", R.drawable.shoulder_and_back_curl_seated, "Gentle seated curl to release accumulated tension.", 30, listOf("Upper Back")),
        FixedExercise("Lumbar Stretch Sitting with Ball", R.drawable.lumbar_stretch_sitting_with_ball, "Roll forward over a ball to open lower and upper back.", 30, listOf("Lower Back", "Upper Back")),
        FixedExercise("Upper Back Spine Stretch Crouching", R.drawable.upperback_spine_stretch_crouching, "Crouch and push spine up to unwind tension.", 30, listOf("Spine")),
        FixedExercise("Upper Back Twist Arms Extended on Ball", R.drawable.upperback_twist_arms_extended_on_ball, "Twist with hands behind your head while seated on ball.", 30, listOf("Upper Back")),
        FixedExercise("Spinal Twist Seated", R.drawable.spinal_twist_seated, "Chair twist to refresh posture and decompress the spine.", 30, listOf("Spine", "Upper Back"))
    )


    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Desk Recovery: Upper Back Undo \uD83D\uDCBB",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Designed to counteract sitting, typing, and tension from long computer hours.",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontStyle = FontStyle.Italic
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )


            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d(
                        "WorkoutNavigation",
                        "Exercises set in ViewModel: ${userExercises.joinToString()}"
                    )

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Desk Recovery Upper Back Undo ")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}

@Composable
fun LowerBackOne(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise("Knee to Chest", R.drawable.knee_to_chest, "Stretch one leg at a time to relieve lower back tension and improve hip alignment.", 30, listOf("Lower back")),
        FixedExercise("Hip Raise", R.drawable.hip_raise, "Strengthen lower back and glutes by lifting hips off the ground.", 30, listOf("Abdominals", "Lower back")),
        FixedExercise("Lower Back Standing", R.drawable.lower_back_standing, "Gently arch your back by pushing your hips forward while standing.", 20, listOf("Lower back")),
        FixedExercise("Shoulder Bridge", R.drawable.shoulder_bridge, "Engage core and spine stabilizers to support lower back.", 30, listOf("Abdominals", "Lower back")),
    )


    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Everyday Low Back Support \uD83C\uDF04", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d(
                        "WorkoutNavigation",
                        "Exercises set in ViewModel: ${userExercises.joinToString()}"
                    )

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Everyday Low Back Support")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}

@Composable
fun LowerBackTwo(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise("Knees to Chest", R.drawable.knees_to_chest, "Lie on your back and gently hug both knees to your chest. Breathe deeply.", 30, listOf("Lower back")),
        FixedExercise("Supine Lumbar Rotation", R.drawable.supine_lumbar_rotation, "Drop knees side-to-side while lying on your back to gently mobilize the lower spine.", 30, listOf("Lower back")),
        FixedExercise("Lumbar Stretch Sitting With Ball", R.drawable.lumbar_stretch_sitting_with_ball, "Seated, lean forward onto a ball to decompress the spine.", 30, listOf("Lower back")),
        FixedExercise("Seated Forward Lean", R.drawable.seated_forward_lean, "Lean forward while seated with wide legs to gently release lower back and hips.", 30, listOf("Lower back")),
    )

    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Lower Back Relief Flow \uD83E\uDDD8\u200D♂\uFE0F", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d(
                        "WorkoutNavigation",
                        "Exercises set in ViewModel: ${userExercises.joinToString()}"
                    )

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Lower Back Relief Flow")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}

@Composable
fun LowerBackThree(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise("Spinal Twist Seated", R.drawable.spinal_twist_seated, "Twist gently while seated to encourage healthy spinal rotation.", 30, listOf("Spine", "Lower back")),
        FixedExercise("Upper Back Spine Stretch Crouching", R.drawable.upperback_spine_stretch_crouching, "Crouch down and pull your upper back upward to stretch the spine deeply.", 30, listOf("Spine")),
        FixedExercise("Knee to Chest Supported Stretch", R.drawable.knee_to_chest_supported_stretch, "Lift one leg while standing and gently stretch it into your chest.", 20, listOf("Lower back")),
        FixedExercise("Thoracic Rotation Side Lying", R.drawable.thoracic_rotation_side_lying, "Rotate from the upper spine while lying down to decompress tension.", 30, listOf("Spine")),
    )


    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Free Your Spine: Back Mobility Flow \uD83C\uDF00", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d(
                        "WorkoutNavigation",
                        "Exercises set in ViewModel: ${userExercises.joinToString()}"
                    )

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Free Your Spine")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}




@Composable
fun HamstringsOne(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise("Hamstring Stretch 90/90", R.drawable.hamstring_stretch_9090, "Lie back and stretch one leg at a 90° angle.", 30, listOf("Hamstrings")),
        FixedExercise("Hamstring Stretch with Band", R.drawable.hamstring_stretch_with_band_or_towel, "Use a towel or band to deepen the stretch.", 30, listOf("Hamstrings")),
        FixedExercise("Unilateral Hamstring Stretch Toe Pointed", R.drawable.unilateral_hamstring_stretch_toe_pointed, "Lift one leg straight up and gently pull it toward your torso.", 30, listOf("Hamstrings")),
        FixedExercise("Hamstring Stretch Toe Raised Kneeling", R.drawable.hamstring_stretch_toe_raised_kneeling, "Kneeling with front foot flexed to target hamstring and calf.", 30, listOf("Hamstrings")),
        FixedExercise("Hamstring Toe Pointed", R.drawable.hamstring_toe_pointed, "Point your toes upward and bend into the stretch.", 20, listOf("Hamstrings")),
        FixedExercise("Hamstring Toe Touch", R.drawable.hamstring_toe_touch, "Raise your leg on a chair and fold gently forward.", 30, listOf("Hamstrings")),
        FixedExercise("Head to Knee Pose", R.drawable.head_to_knee_pose_both_hands_to_ankle, "Seated, fold over one leg with breath control.", 30, listOf("Hamstrings")),
        FixedExercise("Western Intense Stretch", R.drawable.western_intense_stretch, "Fold forward over both legs while seated.", 30, listOf("Hamstrings"))
    )


    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Hamstring Relief Flow \uD83C\uDF3E ", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d(
                        "WorkoutNavigation",
                        "Exercises set in ViewModel: ${userExercises.joinToString()}"
                    )

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Hamstring Relief Flow")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}



@Composable
fun HamstringsTwo(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise("Hamstring Inverted", R.drawable.hamstring_inverted, "Balance on one leg while extending the opposite leg behind.", 20, listOf("Hamstrings")),
        FixedExercise("Head to Knee Pose Revolved", R.drawable.head_to_knee_pose_revolved, "Twist gently while folding over one leg.", 30, listOf("Hamstrings")),
        FixedExercise("Hamstring and Calf Stacked Stretch", R.drawable.hamstring_and_calf_stacked_stretch_and_reach, "Stack feet and reach forward without bending knees.", 20, listOf("Hamstrings")),
        FixedExercise("Intense Side Stretch Pose Prep", R.drawable.intense_side_stretch_pose_prep, "Fold over a straight leg with control.", 30, listOf("Hamstrings")),
        FixedExercise("Western Intense Stretch Half Cow Face", R.drawable.western_intense_stretch_half_cow_face, "Cross one leg and fold for a deeper stretch.", 30, listOf("Hamstrings")),
        FixedExercise("Hamstring Stretch Knee to Chest", R.drawable.hamstring_stretch_knee_to_chest, "Pull bent knee into chest while seated.", 30, listOf("Hamstrings")),
        FixedExercise("Western Intense Stretch Palms to Floor", R.drawable.western_intense_stretch_palms_to_floor, "Reach forward and rest palms on the ground.", 30, listOf("Hamstrings")),
        FixedExercise("Western Intense Halfbound Lotus", R.drawable.western_intense_halfbound_lotus_stretch, "Hold one foot in half lotus and stretch forward.", 30, listOf("Hamstrings"))
    )

    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Everyday Hamstring Health \uD83C\uDF3F", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d(
                        "WorkoutNavigation",
                        "Exercises set in ViewModel: ${userExercises.joinToString()}"
                    )

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Everyday Hamstring Health")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}


@Composable
fun HamstringsThree(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise("Hand to Foot One-Legged Stretch", R.drawable.hand_to_foot_one_legged_half_intense_stretch_pose, "Stretch leg behind you while folding forward.", 30, listOf("Hamstrings")),
        FixedExercise("Hamstring Inverted", R.drawable.hamstring_inverted, "Tilt forward while balancing on one leg.", 20, listOf("Hamstrings")),
        FixedExercise("Hamstring Stretch with Band", R.drawable.hamstring_stretch_with_band_or_towel, "Gently pull leg with resistance for deeper access.", 30, listOf("Hamstrings")),
        FixedExercise("Head to Knee Sideways", R.drawable.head_to_knee_sideways, "Fold sideways to stretch hamstrings and spine.", 30, listOf("Hamstrings", "Obliques")),
        FixedExercise("Western Intense Stretch One-Hand Revolved", R.drawable.western_intense_stretch_onehand_revolved, "Twist while folded to engage the obliques and hamstrings.", 30, listOf("Hamstrings", "Obliques")),
        FixedExercise("Western Intense Pose Infinity Revolved", R.drawable.western_intensestretch_pose_handtofoot_infinity_revolved_head_to_floor, "Revolve the torso and stretch into the hamstring.", 30, listOf("Hamstrings")),
        FixedExercise("Western Intense Stretch Upward Half Dog", R.drawable.western_intense_stretch_upward_half_dog, "Lift and lengthen with feet in hand, promoting core & hamstring length.", 30, listOf("Hamstrings", "Core")),
        FixedExercise("Hamstring Stretch Toe Raised", R.drawable.hamstring_stretch_toe_raised_kneeling, "Lunge and flex the front foot.", 30, listOf("Hamstrings")),
        FixedExercise("Hamstring Stretch with Chair", R.drawable.hamstring_toe_touch, "Support the leg on a chair and fold slowly.", 30, listOf("Hamstrings"))
    )

    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Hamstring Mobility Flow \uD83D\uDD01", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d(
                        "WorkoutNavigation",
                        "Exercises set in ViewModel: ${userExercises.joinToString()}"
                    )

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Hamstring Mobility Flow")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}

@Composable
fun QuadsOne(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise("Lunging Forward Stretch Prayer Hands", R.drawable.lunging_forward_stretch_prayer_hands, "Step into a deep lunge while reaching upward.", 30, listOf("Quadriceps")),
        FixedExercise("Quadriceps Hip Twist", R.drawable.quadriceps_hip_twist, "Deepen the stretch through twisting and hip sinking.", 30, listOf("Quadriceps")),
        FixedExercise("Knee Extensor Kneeling Advanced", R.drawable.knee_extensor_kneeling_advanced, "Kneel and shift weight forward to stretch the quads and hip flexors.", 30, listOf("Quadriceps")),
        FixedExercise("Son of Anjani Lunge Both Hands to Foot", R.drawable.son_of_anjani_lunge_both_hands_to_foot, "Arch into a deep quad-opening backbend.", 20, listOf("Quadriceps", "Chest")),
        FixedExercise("Shoulder Bridge Bound", R.drawable.shoulder_bridge_bound, "Lift the hips while clasping ankles to stretch thighs and spine.", 30, listOf("Quadriceps")),
        FixedExercise("Reverse Lunge with Twist & Overhead Reach", R.drawable.reverse_lunge_with_twist_and_overhead_reach, "Twist and open from a lunge for dynamic flexibility.", 30, listOf("Quadriceps", "Spine")),
        FixedExercise("Squat Revolved Supported Hand to Foot", R.drawable.squat_revolved_supported_hand_to_foot, "Twist in a squat to increase control and stretch depth.", 20, listOf("Quadriceps"))
    )

    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Deep Flexibility Quads & Hip Opener Flow \uD83E\uDDD8\u200D♀\uFE0F ", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d(
                        "WorkoutNavigation",
                        "Exercises set in ViewModel: ${userExercises.joinToString()}"
                    )

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Quads & Hip Opener Flow")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}


@Composable
fun QuadsTwo(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise("Quad Stretch Lying", R.drawable.quad_stretch_lying, "Lie on your stomach and pull one foot toward your glutes.", 30, listOf("Quadriceps")),
        FixedExercise("Quad Stretch Standing", R.drawable.quad_stretch_standing, "Stand and pull one foot behind to stretch the quad.", 30, listOf("Quadriceps")),
        FixedExercise("Knee Bend Side Lying", R.drawable.knee_bend_side_lying, "Lie on your side and bend your top leg to stretch the quad.", 30, listOf("Quadriceps")),
        FixedExercise("Thunderbolt Pose Tiptoe", R.drawable.thunderbolt_pose_tiptoe, "Kneel and lean back to open hips and thighs.", 30, listOf("Quadriceps")),
        FixedExercise("Squat with Arms Clasped", R.drawable.squat_with_arms_clasped, "Lower into a squat while maintaining a tall spine.", 20, listOf("Quadriceps")),
        FixedExercise("Quad Stretch Bilateral Prep", R.drawable.quad_stretch_bilateral_prep, "Kneel gently and prepare the hips for deeper stretching.", 30, listOf("Quadriceps"))
    )

    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Quad Relief & Recovery Flow \uD83D\uDD27", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d(
                        "WorkoutNavigation",
                        "Exercises set in ViewModel: ${userExercises.joinToString()}"
                    )

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Quad Relief & Recovery Flow")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}


@Composable
fun QuadsThree(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise("Shoulder Bridge Pelvic Press with Band", R.drawable.shoulder_bridge_pelvic_press_with_band, "Lift through the hips to engage quads and glutes.", 30, listOf("Quadriceps")),
        FixedExercise("Quad Stretch Bilateral", R.drawable.quad_stretch_bilateral, "Lift into a kneeling backbend to stretch both quads simultaneously.", 30, listOf("Quadriceps")),
        FixedExercise("Shoulder Bridge", R.drawable.shoulder_bridge, "Classic bridge to engage thighs and support the spine.", 30, listOf("Quadriceps", "Spine")),
        FixedExercise("Lunge to the Side", R.drawable.lunge_to_the_side, "Side lunge with overhead reach to lengthen the front body.", 30, listOf("Quadriceps", "Obliques")),
        FixedExercise("Thigh Stretch Knee to Chest Extended", R.drawable.thigh_stretch_knee_to_chest_extended, "Stretch deeply into the upper thigh and hip crease.", 30, listOf("Quadriceps")),
        FixedExercise("Leg Raise Reach", R.drawable.leg_raise_reach, "Dynamic activation of the front thighs with balance control.", 20, listOf("Quadriceps"))
    )

    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Posture Reset: Front Body Strength & Stretch \uD83D\uDCCF ", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d(
                        "WorkoutNavigation",
                        "Exercises set in ViewModel: ${userExercises.joinToString()}"
                    )

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Front Body Strength & Stretch")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}




@Composable
fun FlexibilityFlow(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise(
            "Seated Forward Bend",
            R.drawable.bilateral_seated_forward_bend,
            "Sit with your legs extended straight in front of you. Slowly fold forward from the hips, reaching your hands toward your feet. Relax your head and shoulders to deepen the stretch.",
            60,
            listOf("Hamstrings", "Lower Back", "Spine")
        ),

        FixedExercise(
            "Child's Pose",
            R.drawable.child_pose,
            "Sit back on your heels, extend your arms forward, and lower your forehead to the mat. Breathe deeply and allow your hips and spine to release.",
            45,
            listOf("Hips", "Back", "Spine")
        ),

        FixedExercise(
            "Crescent Pose Standing",
            R.drawable.crescent_pose_standing,
            "Stand tall with fingers clasped overhead. Gently bend to one side to stretch through the lats, shoulders, and side body. Switch sides after holding.",
            30,
            listOf("Latissimus Dorsi", "Obliques", "Spine")
        ),

        FixedExercise(
            "Down Dog Heel Stretch",
            R.drawable.achilles_stretch_downward_dog,
            "From downward dog position, press one heel toward the ground while bending the opposite knee. Alternate sides to open calves and hamstrings.",
            30,
            listOf("Calves", "Hamstrings")
        ),

        FixedExercise(
            "Frog Splits",
            R.drawable.frog_splits,
            "Start on all fours and lower your forearms to the ground. Spread your knees wide and press your hips back and downward for a deep hip and groin stretch.",
            45,
            listOf("Adductors", "Inner Thighs", "Hips")
        ),

        FixedExercise(
            "Ankle on Knee Stretch",
            R.drawable.ankle_on_knee_stretch,
            "Sit upright and cross one ankle over the opposite knee. Lean forward gently to stretch the hips and glutes. Keep your spine long and relaxed.",
            30,
            listOf("Glutes", "Hips")
        ),

        FixedExercise(
            "Camel Pose",
            R.drawable.camel_pose,
            "Kneel with knees hip-width apart and feet flat. Place your hands on your lower back and gently lean backward, lifting your chest and opening the front body.",
            30,
            listOf("Chest", "Shoulders")
        ),

        FixedExercise(
            "Extended Side Angle",
            R.drawable.extended_side_angle_stretch,
            "From a deep side lunge, place your hand on the floor inside your foot. Extend your opposite arm overhead, feeling a deep side body stretch. Switch sides after holding.",
            30,
            listOf("Obliques", "Hips", "Spine")
        ),

        FixedExercise(
            "Thread the Needle",
            R.drawable.chest_to_floor_twist,
            "From all fours, slide one arm underneath the other, lowering your shoulder and head to the floor. Feel the stretch through the upper back and shoulders. Switch sides after holding.",
            30,
            listOf("Upper Back", "Shoulders", "Spine")
        ),

        FixedExercise(
            "Feet Spread Intense 1",
            R.drawable.feet_spread_out_intense_stretch_pose_1,
            "Stand with your feet wide apart. Fold forward at the hips, lowering your head toward the floor. Stretch through the hamstrings and spine while relaxing your neck.",
            30,
            listOf("Upper Back", "Hamstrings", "Spine")
        ),

        )


    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Flexibility Flow", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d(
                        "WorkoutNavigation",
                        "Exercises set in ViewModel: ${userExercises.joinToString()}"
                    )

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Flexibility Flow")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}


@Composable
fun CorePower(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise(
            "Hand Clasp Ab Lift",
            R.drawable.abdominal_lift_hand_clasp,
            "Lie on your back with knees bent and feet flat. Extend your arms straight up, clasp your hands, and lift your shoulders off the floor. Engage your core and alternate twisting to each side.",
            30,
            listOf("Abdominals")
        ),

        FixedExercise(
            "Two-Leg Ab Lift",
            R.drawable.abdominal_lift_two_legs_extended,
            "Lie on your back with arms at your sides. Slowly raise both your legs and upper body off the floor, keeping your legs straight and core tight.",
            30,
            listOf("Abdominals", "Hip Flexors")
        ),

        FixedExercise(
            "Twist Ab Lift & Leg Reach",
            R.drawable.abdominal_lift_with_twist_and_leg_stretch,
            "Lie on your back with knees bent and arms extended. Raise one leg and lift your shoulders, twisting your torso toward the raised leg. Alternate sides smoothly.",
            30,
            listOf("Abdominals", "Obliques", "Hip Flexors")
        ),

        FixedExercise(
            "Supported Boat Twist",
            R.drawable.boat_pose_revolved_supported,
            "Sit with hands behind you for support, cross one foot over the other, lift both legs, and twist toward the rear arm while balancing. Switch sides after holding.",
            30,
            listOf("Core", "Obliques", "Hip Flexors")
        ),

        FixedExercise(
            "Extended Fish Pose",
            R.drawable.extended_fish_pose,
            "Lie on your back, crown of your head resting lightly on the floor. Raise your legs to 45 degrees and extend arms straight up. Engage your core to stabilize.",
            30,
            listOf("Chest", "Neck", "Core")
        ),

        FixedExercise(
            "Half Moon Pose",
            R.drawable.half_moon_pose,
            "Step one foot forward and shift weight onto it. Hinge at the hips, lifting your back leg while lowering one hand to the floor. Extend the opposite arm upward to engage your core and stabilize.",
            30,
            listOf("Chest", "Spine", "Glutes", "Hamstrings")
        ),

        FixedExercise(
            "Back Rolls",
            R.drawable.back_rolls,
            "Lie on your back, hug your knees to your chest, and gently rock back and forth along your spine to strengthen and massage your core muscles.",
            45,
            listOf("Spine", "Lower Back", "Core")
        ),

        FixedExercise(
            "Revolved Extended Staff Pose",
            R.drawable.extended_four_limbs_staff_pose_revolved,
            "From a plank position, rotate to one side into a side plank. Stack your feet and engage your core, lifting your hips strong and steady. Switch sides.",
            30,
            listOf("Obliques", "Shoulders", "Core")
        ),

        )

    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Core Power", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d(
                        "WorkoutNavigation",
                        "Exercises set in ViewModel: ${userExercises.joinToString()}"
                    )

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Core Power")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}

@Composable
fun UnwindFlow(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise("Hamstring Stretch 90/90", R.drawable.hamstring_stretch_9090, "Lie back and stretch one leg at a 90° angle.", 30, listOf("Hamstrings")),
        FixedExercise("Hamstring Stretch with Band", R.drawable.hamstring_stretch_with_band_or_towel, "Use a towel or band to deepen the stretch.", 30, listOf("Hamstrings")),
        FixedExercise("Unilateral Hamstring Stretch Toe Pointed", R.drawable.unilateral_hamstring_stretch_toe_pointed, "Lift one leg straight up and gently pull it toward your torso.", 30, listOf("Hamstrings")),
        FixedExercise("Hamstring Stretch Toe Raised Kneeling", R.drawable.hamstring_stretch_toe_raised_kneeling, "Kneeling with front foot flexed to target hamstring and calf.", 30, listOf("Hamstrings")),
        FixedExercise("Hamstring Toe Pointed", R.drawable.hamstring_toe_pointed, "Point your toes upward and bend into the stretch.", 20, listOf("Hamstrings")),
        FixedExercise("Hamstring Toe Touch", R.drawable.hamstring_toe_touch, "Raise your leg on a chair and fold gently forward.", 30, listOf("Hamstrings")),
        FixedExercise("Head to Knee Pose", R.drawable.head_to_knee_pose_both_hands_to_ankle, "Seated, fold over one leg with breath control.", 30, listOf("Hamstrings")),
        FixedExercise("Western Intense Stretch", R.drawable.western_intense_stretch, "Fold forward over both legs while seated.", 30, listOf("Hamstrings"))
    )


    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Unwind Flow", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d(
                        "WorkoutNavigation",
                        "Exercises set in ViewModel: ${userExercises.joinToString()}"
                    )

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Unwind Flow")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}

@Composable
fun EnergyBoost(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise(
            "Arms Above Head Toe Flex",
            R.drawable.arms_above_head_toe_flex,
            "Lie flat on your back with arms and legs extended. Point your toes and stretch your body by reaching through your fingertips and feet, creating length from end to end.",
            30,
            listOf("Shoulders", "Spine", "Calves")
        ),

        FixedExercise(
            "Crescent Pose Standing",
            R.drawable.crescent_pose_standing,
            "Stand upright with fingers clasped and arms raised overhead. Gently bend to one side to stretch through the opposite lat and side body. Switch sides after holding.",
            30,
            listOf("Latissimus Dorsi", "Obliques", "Spine")
        ),

        FixedExercise(
            "Tiptoe Fierce Pose",
            R.drawable.fierce_pose_3_tiptoe,
            "Stand with knees slightly bent and rise onto your tiptoes. Lift your arms overhead and lengthen your spine, maintaining balance and upright posture.",
            20,
            listOf("Chest", "Calves", "Core", "Shoulders")
        ),

        FixedExercise(
            "Back Stretch Reaching",
            R.drawable.back_stretch_reaching,
            "Stand tall with arms extended overhead. Cross your wrists and actively reach toward the ceiling, feeling the stretch through your spine and shoulders.",
            30,
            listOf("Back", "Shoulders", "Spine")
        ),

        FixedExercise(
            "Child's Pose",
            R.drawable.child_pose,
            "Sit back on your heels, extend arms forward, and rest your forehead on the mat. Relax and breathe deeply to reset and re-energize your body and mind.",
            45,
            listOf("Spine", "Hips", "Back")
        ),

        FixedExercise(
            "Standing Cat Stretch",
            R.drawable.cat_stretch_standing_extended_forward_bend,
            "Stand with feet shoulder-width apart and hands on your knees. Lean forward until your back is parallel to the floor. Arch your spine upward, activating your breath and back muscles.",
            30,
            listOf("Upper Back", "Spine", "Hamstrings")
        ),

        FixedExercise(
            "Cobra Stretch",
            R.drawable.cobra_stretch,
            "Lie on your stomach and place your hands under your shoulders. Press up to lift your chest, straightening your arms while keeping your shoulders back and chest open.",
            30,
            listOf("Chest", "Spine", "Upper Back")
        ),

        FixedExercise(
            "Back Rolls",
            R.drawable.back_rolls,
            "Lie on your back and hug your knees to your chest. Gently rock along your spine to massage your back, awaken your breath, and refresh your energy.",
            45,
            listOf("Spine", "Lower Back", "Core")
        ),

        )


    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Energy Boost", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d(
                        "WorkoutNavigation",
                        "Exercises set in ViewModel: ${userExercises.joinToString()}"
                    )

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Energy Boost")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}

@Composable
fun UpperBackReliefFlow(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(

        FixedExercise(
            "Cat Pose",
            R.drawable.cat_pose,
            "Start on all fours with hands under shoulders and knees under hips. Round your back by pulling your spine toward the ceiling, tucking your chin. Breathe deeply into the stretch.",
            30,
            listOf("Upper Back", "Spine")
        ),

        FixedExercise(
            "Easy Upper Back Stretch",
            R.drawable.easy_upper_back_stretch,
            "Stand with feet apart and lean forward from the waist. Gently pull your shoulders downward while extending your neck forward to stretch through the upper back.",
            20,
            listOf("Upper Back", "Shoulders", "Spine")
        ),

        FixedExercise(
            "Back Stretch with Reach",
            R.drawable.back_stretch_with_arms_reaching_1,
            "Begin kneeling and reach your arms forward on the floor. Lower your hips to your heels and allow your head to rest down, stretching through the spine and shoulders.",
            30,
            listOf("Back", "Shoulders", "Hips")
        ),

        FixedExercise(
            "Child's Pose",
            R.drawable.child_pose,
            "Sit back on your heels, extend arms forward, and rest your forehead on the mat. Relax your chest and shoulders into the floor, focusing on releasing upper back tension.",
            45,
            listOf("Spine", "Hips", "Back")
        ),

        FixedExercise(
            "Thread the Needle",
            R.drawable.chest_to_floor_twist,
            "From all fours, slide one arm underneath the other, lowering your shoulder and head to the floor. Feel a deep stretch through the upper back and shoulders. Hold, then switch sides.",
            30,
            listOf("Upper Back", "Shoulders", "Spine")
        ),

        FixedExercise(
            "Standing Cat Stretch",
            R.drawable.cat_stretch_standing_extended_forward_bend,
            "Stand with feet shoulder-width apart and hands on your knees. Lean forward until your back is parallel to the floor. Arch your spine upward, focusing on the upper back.",
            30,
            listOf("Upper Back", "Spine", "Hamstrings")
        ),

        FixedExercise(
            "Back Rolls",
            R.drawable.back_rolls,
            "Lie on your back and hug your knees to your chest. Gently rock along the spine from shoulders to tailbone to massage the back and release tension.",
            45,
            listOf("Spine", "Lower Back", "Core")
        ),

        FixedExercise(
            "Behind Clasp Backbend",
            R.drawable.backbend_arms_clasped_behind,
            "Stand upright and clasp your hands behind your back. Open your chest and gently arch backward, feeling the stretch across your chest and upper back.",
            20,
            listOf("Chest", "Shoulders", "Spine")
        ),

        )


    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Upper Back Relief Flow", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d(
                        "WorkoutNavigation",
                        "Exercises set in ViewModel: ${userExercises.joinToString()}"
                    )

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Upper Back Relief Floww")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}



@Composable
fun GluteActivationSeries(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise(
            "Chair Kicks",
            R.drawable.chair_kicks,
            "Stand beside a chair and shift weight to the inside leg. Swing the outer leg forward and backward without touching the floor, keeping the motion fluid and controlled.",
            30,
            listOf("Glutes", "Hip Flexors", "Hamstrings")
        ),

        FixedExercise(
            "One-Leg Tiptoe Baby Cradle",
            R.drawable.baby_cradle_pose_in_one_legged_tiptoe,
            "Begin in a low crouch on your tiptoes. Cross one foot over the opposite thigh and use your hands to gently draw the leg toward your chest. Hold the pose while maintaining balance, then switch sides.",
            30,
            listOf("Hips", "Glutes", "Ankles")
        ),

        FixedExercise(
            "Half Moon Pose",
            R.drawable.half_moon_pose,
            "Step one foot forward and shift your weight onto it. Hinge at the hips, lifting your back leg and lowering one hand to the floor. Extend the opposite arm upward, opening the chest and stacking the shoulders. Hold and repeat on the other side.",
            30,
            listOf("Chest", "Spine", "Glutes", "Hamstrings")
        ),

        FixedExercise(
            "Half One Leg Upward",
            R.drawable.half_one_leg_stretched_upward,
            "From a standing position, fold forward and place your hands flat on the floor. Shift your weight onto your hands and raise one leg straight upward. Keep the raised leg engaged and pointed. Hold, then switch sides.",
            30,
            listOf("Glutes", "Hamstrings", "Shoulders")
        ),

        FixedExercise(
            "Forward Lunge Arms Spread Out",
            R.drawable.forward_lunge_arms_spread_out,
            "From a low squat, extend one leg back with the toes tucked under. Lean forward into a deep lunge, pressing the back thigh toward the floor and stretching the glutes and hamstrings. Switch sides after holding.",
            30,
            listOf("Hamstrings", "Hip Flexors", "Glutes")
        ),

        FixedExercise(
            "Frog Splits",
            R.drawable.frog_splits,
            "Start on all fours and lower your forearms to the ground. Spread your knees apart and lower your hips toward the floor, bringing the soles of your feet together. Hold the position to open the hips and glutes.",
            30,
            listOf("Adductors", "Inner Thighs", "Hips")
        ),

        FixedExercise(
            "Ankle on Knee Stretch",
            R.drawable.ankle_on_knee_stretch,
            "Sit upright and cross one ankle over the opposite knee. Lean forward gently to deepen the hip and glute stretch. Keep your spine long and switch sides after holding.",
            30,
            listOf("Glutes", "Hips")
        ),

        FixedExercise(
            "Four Corner Stretch",
            R.drawable.four_corner_stretch,
            "Sit cross-legged and lift one foot onto the opposite thigh. Wrap both hands around the lifted calf and pull it gently until it's parallel to the floor. Hold, then switch sides.",
            30,
            listOf("Abductors", "Hips", "Glutes")
        ),

        )

    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Glute Activation", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d(
                        "WorkoutNavigation",
                        "Exercises set in ViewModel: ${userExercises.joinToString()}"
                    )

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Glute Activation")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}



@Composable
fun SpinalTwistReset(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(

        FixedExercise(
            "Cat Pose",
            R.drawable.cat_pose,
            "Start on all fours with hands under shoulders and knees under hips. Round your back by pulling your spine toward the ceiling, dropping your head and shoulders. Hold and breathe deeply.",
            30,
            listOf("Upper Back", "Spine")
        ),

        FixedExercise(
            "Cow Pose 1",
            R.drawable.cow_pose_1,
            "Begin on all fours. Drop your belly toward the floor while lifting your chest and gaze toward the ceiling, creating a deep arch through the spine.",
            30,
            listOf("Spine", "Chest", "Abdominals")
        ),

        FixedExercise(
            "Child's Pose",
            R.drawable.child_pose,
            "Sit back on your heels, extend arms forward, and rest forehead on the mat. Relax and breathe deeply, feeling your spine lengthen.",
            45,
            listOf("Spine", "Hips", "Back")
        ),

        FixedExercise(
            "Easy Spinal Twist",
            R.drawable.easy_spinal_twist,
            "Stand with feet shoulder-width apart. Cross one arm across your torso and twist to the opposite side, reaching the back arm behind you. Turn your gaze with the twist and hold.",
            30,
            listOf("Chest", "Spine", "Obliques")
        ),

        FixedExercise(
            "Chest to Floor Twist",
            R.drawable.chest_to_floor_twist,
            "Lie on your stomach and bend both knees to one side. Gently lift one shoulder to deepen the spinal twist. Hold, then switch sides.",
            30,
            listOf("Spine", "Lower Back", "Obliques")
        ),

        FixedExercise(
            "Back Rolls",
            R.drawable.back_rolls,
            "Lie on your back and hug your knees to your chest. Gently rock along the spine from shoulders to tailbone in a smooth, massaging motion.",
            45,
            listOf("Spine", "Lower Back", "Core")
        ),

        FixedExercise(
            "Seated Forward Bend",
            R.drawable.bilateral_seated_forward_bend,
            "Sit with your legs extended straight in front of you. Slowly fold forward, lowering your head and shoulders toward your knees while keeping your spine long. Relax into the stretch.",
            60,
            listOf("Hamstrings", "Lower Back", "Spine")
        ),

        FixedExercise(
            "Bridge on Forehead",
            R.drawable.bridge_on_forehead,
            "Lie on your back with knees bent and hands beside your head, fingers pointing toward your shoulders. Press into your hands and feet to lift your body, allowing the top of your head to rest lightly on the floor.",
            20,
            listOf("Spine")
        ),

        FixedExercise(
            "Behind Clasp Backbend",
            R.drawable.backbend_arms_clasped_behind,
            "Stand upright and clasp your hands behind your back. Open your chest and gently arch backward, reaching your arms downward to deepen the front body stretch.",
            20,
            listOf("Chest", "Shoulders", "Spine")
        ),

        FixedExercise(
            "Reclined Half Hero Stretch",
            R.drawable.half_hero_half_extended_hand_to_foot_pose_reclined_variation,
            "Start kneeling and extend one leg out to the side. Lower your hips onto the heel of your bent leg. Fold forward, extending both arms outward and bringing your forehead toward the floor.",
            30,
            listOf("Hamstrings", "Spine", "Adductors")
        ),

        )


    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Spinal Twist Reset", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d(
                        "WorkoutNavigation",
                        "Exercises set in ViewModel: ${userExercises.joinToString()}"
                    )

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Spinal Twist Reset")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}



@Composable
fun HamstringStretchRoutine(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val initialExercises = listOf(
        FixedExercise(
            "Seated Forward Bend",
            R.drawable.bilateral_seated_forward_bend,
            "Sit with your legs extended straight in front of you. Slowly fold forward, lowering your head and shoulders toward your knees while keeping your spine long. Relax into the stretch.",
            60,
            listOf("Hamstrings", "Lower Back", "Spine")
        ),

        FixedExercise(
            "Standing Cat Stretch",
            R.drawable.cat_stretch_standing_extended_forward_bend,
            "Stand with feet shoulder-width apart and hands on your knees. Lean forward until your back is parallel to the floor. Arch your spine upward to stretch the upper back and hamstrings.",
            45,
            listOf("Upper Back", "Spine", "Hamstrings")
        ),

        FixedExercise(
            "Forward Bend Assisted",
            R.drawable.forward_bend_assisted,
            "Stand with legs wide apart and fold forward from the hips. Place your hands on the floor or a yoga block between your legs. Relax into the stretch while keeping your back flat.",
            45,
            listOf("Hamstrings", "Lower Back", "Glutes")
        ),

        FixedExercise(
            "Crossed Arm Forward Bend",
            R.drawable.forward_bend_crossed_arm,
            "Stand tall with feet together and cross your arms at the elbows. Fold forward, letting your head drop toward the floor. Deepen the stretch by reaching opposite hands toward your feet.",
            45,
            listOf("Spine", "Upper Back", "Hamstrings")
        ),

        FixedExercise(
            "Hamstring Stretch 90-90",
            R.drawable.hamstring_stretch_9090,
            "Lie flat on your back and bring one knee into your chest. Wrap your hands behind the thigh and gently pull the leg closer to deepen the hamstring stretch. Repeat with the other leg.",
            30,
            listOf("Hamstrings", "Glutes")
        ),

        FixedExercise(
            "Stacked Hamstring & Calf Reach",
            R.drawable.hamstring_and_calf_stacked_stretch_and_reach,
            "Sit with legs extended. Stack one heel over the opposite foot and fold forward from the hips, reaching toward the front ankle while keeping knees straight. Switch sides after holding.",
            45,
            listOf("Hamstrings", "Calves", "Lower Back")
        ),

        FixedExercise(
            "Hamstring Inverted",
            R.drawable.hamstring_inverted,
            "Stand tall and shift your weight to one foot. Hinge forward at the waist while raising the opposite leg behind you until your torso and leg form a straight line. Balance and hold before switching sides.",
            30,
            listOf("Hamstrings", "Glutes", "Spine")
        ),

        FixedExercise(
            "Feet Spread Intense 1",
            R.drawable.feet_spread_out_intense_stretch_pose_1,
            "Stand with feet wide and bend forward, placing hands between your legs. Lower your head toward the floor and reach your arms behind you, palms on the ground.",
            30,
            listOf("Upper Back", "Hamstrings", "Spine")
        ),

        )


    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*initialExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = "Hamstring Stretch Routine",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            // ✅ Let LazyColumn fill available space
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {}
                    )
                }
            }

            // ✅ Keep button fixed at bottom
            Button(
                onClick = {
                    workoutViewModel.setExercises(userExercises.toList())
                    navController.navigate("WorkoutSlideshow/Hamstring Stretch Routine")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }

}



@Composable
fun FullBodyFlow(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val fullBodyFlowExercises = listOf(
        FixedExercise(
            name = "Cat-Cow Stretch",
            displayResId = R.drawable.cat_pose,
            description = "On all fours, alternate between arching and rounding your spine. Inhale to lift the head and tailbone, exhale to round the spine.",
            duration = 30,
            muscleGroups = listOf("Spine", "Neck", "Core")
        ),
        FixedExercise(
            name = "Downward Dog",
            displayResId = R.drawable.downward_dog,
            description = "From all fours, lift your hips high into an inverted V shape. Press your heels gently toward the ground.",
            duration = 30,
            muscleGroups = listOf("Hamstrings", "Shoulders", "Back")
        ),
        FixedExercise(
            name = "Low Lunge with Chest Opener",
            displayResId = R.drawable.hip_to_thing_lunge_arms_up,
            description = "Step into a lunge and lift your arms overhead, opening your chest. Hold and breathe deeply.",
            duration = 30,
            muscleGroups = listOf("Hips", "Chest", "Spine")
        ),
        FixedExercise(
            name = "Seated Forward Fold",
            displayResId = R.drawable.knee_flexor_seated_advanced,
            description = "Sit with legs extended and fold forward at the hips, reaching for your feet or shins.",
            duration = 30,
            muscleGroups = listOf("Hamstrings", "Lower Back")
        ),
        FixedExercise(
            name = "Child’s Pose",
            displayResId = R.drawable.child_pose,
            description = "Sit back on your heels and stretch your arms forward, resting your forehead on the mat.",
            duration = 30,
            muscleGroups = listOf("Lower Back", "Hips", "Shoulders")
        ),
        FixedExercise(
            name = "knee Flexor Standing",
            displayResId = R.drawable.knee_flexor_standing,
            description = "Lie on your back, hug one knee to your chest, and gently twist it across your body to the opposite side.",
            duration = 30,
            muscleGroups = listOf("Spine", "Hips")
        ),
        FixedExercise(
            name = "Bridge Pose",
            displayResId = R.drawable.bridge_pose,
            description = "Lie on your back with knees bent, press into your feet and lift your hips up toward the ceiling.",
            duration = 30,
            muscleGroups = listOf("Glutes", "Core", "Lower Back")
        ),
        FixedExercise(
            name = "Happy Baby",
            displayResId = R.drawable.happy_baby,
            description = "Lie on your back, grab the outsides of your feet, and gently pull your knees toward the ground.",
            duration = 30,
            muscleGroups = listOf("Hips", "Hamstrings", "Lower Back")
        ),
        FixedExercise(
            name = "Standing Forward Fold",
            displayResId = R.drawable.side_bending_mountain_pose,
            description = "From standing, hinge at the hips and fold over your legs. Let your head and arms hang heavy.",
            duration = 30,
            muscleGroups = listOf("Hamstrings", "Lower Back")
        ),
        FixedExercise(
            name = "Side Stretch with Arms Overhead",
            displayResId = R.drawable.side_stretch_arms_clasped_overhead,
            description = "Stand with feet together and clasp your hands above your head. Lean your torso to one side while keeping your heels grounded. Hold and repeat on the opposite side.",
            duration = 30,
            muscleGroups = listOf("Obliques", "Shoulders", "Spine")
        ),
        FixedExercise(
            name = "Savasana",
            displayResId = R.drawable.finger_press_overhead,
            description = "Extend your arms overhead with fingers interlaced and palms facing the ceiling. Hold the stretch while maintaining length through the spine.",
            duration = 60,
            muscleGroups = listOf("Mindfulness", "Full Body")
        )
    )



    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*fullBodyFlowExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Full Body Flow", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d(
                        "WorkoutNavigation",
                        "Exercises set in ViewModel: ${userExercises.joinToString()}"
                    )

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Full Body Flow")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}


@Composable
fun SleepReset(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val fullBodyFlowExercises = listOf(
        FixedExercise(
            "Child's Pose",
            R.drawable.child_pose,
            "Sit back on your heels, extend arms forward, and rest your forehead on the mat. Breathe slowly and deeply, allowing the spine and hips to release tension.",
            60,
            listOf("Spine", "Hips", "Back")
        ),

        FixedExercise(
            "Back Rolls",
            R.drawable.back_rolls,
            "Lie on your back and hug your knees to your chest. Gently rock side to side or along the spine to calm the nervous system and release the lower back.",
            60,
            listOf("Spine", "Lower Back", "Core")
        ),

        FixedExercise(
            "Ankle on Knee Stretch",
            R.drawable.ankle_on_knee_stretch,
            "Lie on your back and cross one ankle over the opposite knee. Gently pull the uncrossed thigh toward your chest. Relax your shoulders and switch sides after holding.",
            60,
            listOf("Glutes", "Hips")
        ),

        FixedExercise(
            "Thread the Needle",
            R.drawable.chest_to_floor_twist,
            "From all fours, slide one arm underneath the other, lowering your shoulder and head to the floor. Let your upper back melt into the floor. Switch sides after holding.",
            60,
            listOf("Upper Back", "Shoulders", "Spine")
        ),

        FixedExercise(
            "Seated Forward Bend",
            R.drawable.bilateral_seated_forward_bend,
            "Sit with your legs extended. Gently fold forward from the hips and rest your head and arms. Soften your breath and allow your body to settle.",
            60,
            listOf("Hamstrings", "Lower Back", "Spine")
        ),

        FixedExercise(
            "Chest to Ground",
            R.drawable.chest_to_ground,
            "Start in a kneeling position and extend your arms between your knees. Rest your chest and forehead on the floor to release the spine and open the back body.",
            60,
            listOf("Chest", "Shoulders", "Spine")
        ),

        FixedExercise(
            "Reclined Half Hero Stretch",
            R.drawable.half_hero_half_extended_hand_to_foot_pose_reclined_variation,
            "Start kneeling and extend one leg out to the side. Lower your hips onto the heel of the bent leg. Extend arms forward and let your head rest, relaxing into stillness.",
            60,
            listOf("Hamstrings", "Spine", "Adductors")
        ),

        FixedExercise(
            "Easy Spinal Twist",
            R.drawable.easy_spinal_twist,
            "Lie on your back and hug your knees in. Drop them to one side while keeping shoulders grounded. Turn your head in the opposite direction and breathe deeply. Switch sides.",
            60,
            listOf("Chest", "Spine", "Obliques")
        ),

        )



    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*fullBodyFlowExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Sleep Reset", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d(
                        "WorkoutNavigation",
                        "Exercises set in ViewModel: ${userExercises.joinToString()}"
                    )

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Sleep Reset")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}

@Composable
fun DeskDetox(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val fullBodyFlowExercises = listOf(
        FixedExercise(
            "Arms Above Head Toe Flex",
            R.drawable.arms_above_head_toe_flex,
            "Lie flat on your back with arms and legs extended. Flex and point your toes as you reach through your fingertips to create full-body length and wake up the body.",
            30,
            listOf("Shoulders", "Spine", "Calves")
        ),

        FixedExercise(
            "Cat Pose",
            R.drawable.cat_pose,
            "On all fours, round your back toward the ceiling and tuck your chin. Breathe deeply and feel your spine stretch gently as you begin moving.",
            20,
            listOf("Upper Back", "Spine")
        ),

        FixedExercise(
            "Cow Pose 1",
            R.drawable.cow_pose_1,
            "From Cat Pose, drop your belly, lift your gaze, and arch your spine. Inhale deeply to open the chest and wake up your breath.",
            20,
            listOf("Spine", "Chest", "Abdominals")
        ),

        FixedExercise(
            "Crescent Pose Standing",
            R.drawable.crescent_pose_standing,
            "Stand upright with arms overhead and clasped. Gently bend side to side to wake up the ribs, spine, and shoulders.",
            30,
            listOf("Latissimus Dorsi", "Obliques", "Spine")
        ),

        FixedExercise(
            "Tiptoe Fierce Pose",
            R.drawable.fierce_pose_3_tiptoe,
            "Rise onto your tiptoes with arms overhead and knees slightly bent. Hold the balance to activate your legs and core, energizing your whole body.",
            20,
            listOf("Chest", "Calves", "Core", "Shoulders")
        ),

        FixedExercise(
            "Standing Cat Stretch",
            R.drawable.cat_stretch_standing_extended_forward_bend,
            "Lean forward with hands on knees and arch your back upward. Alternate between arching and flattening your spine to warm up the back and energize breath.",
            30,
            listOf("Upper Back", "Spine", "Hamstrings")
        ),

        FixedExercise(
            "Back Stretch Reaching",
            R.drawable.back_stretch_reaching,
            "Reach your arms overhead and extend tall. Cross wrists and pull upward to decompress your spine and awaken your posture.",
            30,
            listOf("Back", "Shoulders", "Spine")
        ),

        FixedExercise(
            "Child's Pose",
            R.drawable.child_pose,
            "Finish in Child’s Pose to center your mind. Extend your arms forward and let your breath settle into your belly. Begin your day grounded and ready.",
            45,
            listOf("Spine", "Hips", "Back")
        )


    )



    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*fullBodyFlowExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Desk Detox", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d(
                        "WorkoutNavigation",
                        "Exercises set in ViewModel: ${userExercises.joinToString()}"
                    )

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Desk Detox")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}



@Composable
fun WakeAndShake(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val fullBodyFlowExercises = listOf(
        FixedExercise(
            "Arms Above Head Toe Flex",
            R.drawable.arms_above_head_toe_flex,
            "Lie flat on your back with arms and legs extended. Flex and point your toes as you reach through your fingertips to create full-body length and wake up the body.",
            30,
            listOf("Shoulders", "Spine", "Calves")
        ),

        FixedExercise(
            "Cat Pose",
            R.drawable.cat_pose,
            "On all fours, round your back toward the ceiling and tuck your chin. Breathe deeply and feel your spine stretch gently as you begin moving.",
            20,
            listOf("Upper Back", "Spine")
        ),

        FixedExercise(
            "Cow Pose 1",
            R.drawable.cow_pose_1,
            "From Cat Pose, drop your belly, lift your gaze, and arch your spine. Inhale deeply to open the chest and wake up your breath.",
            20,
            listOf("Spine", "Chest", "Abdominals")
        ),

        FixedExercise(
            "Crescent Pose Standing",
            R.drawable.crescent_pose_standing,
            "Stand upright with arms overhead and clasped. Gently bend side to side to wake up the ribs, spine, and shoulders.",
            30,
            listOf("Latissimus Dorsi", "Obliques", "Spine")
        ),

        FixedExercise(
            "Tiptoe Fierce Pose",
            R.drawable.fierce_pose_3_tiptoe,
            "Rise onto your tiptoes with arms overhead and knees slightly bent. Hold the balance to activate your legs and core, energizing your whole body.",
            20,
            listOf("Chest", "Calves", "Core", "Shoulders")
        ),

        FixedExercise(
            "Standing Cat Stretch",
            R.drawable.cat_stretch_standing_extended_forward_bend,
            "Lean forward with hands on knees and arch your back upward. Alternate between arching and flattening your spine to warm up the back and energize breath.",
            30,
            listOf("Upper Back", "Spine", "Hamstrings")
        ),

        FixedExercise(
            "Back Stretch Reaching",
            R.drawable.back_stretch_reaching,
            "Reach your arms overhead and extend tall. Cross wrists and pull upward to decompress your spine and awaken your posture.",
            30,
            listOf("Back", "Shoulders", "Spine")
        ),

        FixedExercise(
            "Child's Pose",
            R.drawable.child_pose,
            "Finish in Child’s Pose to center your mind. Extend your arms forward and let your breath settle into your belly. Begin your day grounded and ready.",
            45,
            listOf("Spine", "Hips", "Back")
        )



    )


    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*fullBodyFlowExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Wake And Shake", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d(
                        "WorkoutNavigation",
                        "Exercises set in ViewModel: ${userExercises.joinToString()}"
                    )

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Wake And Shake")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}


@Composable
fun LowerBackRelief(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val fullBodyFlowExercises = listOf(
        FixedExercise(
            "Arms Above Head Toe Flex",
            R.drawable.arms_above_head_toe_flex,
            "Lie flat on your back with arms and legs extended. Flex and point your toes as you reach through your fingertips to create full-body length and wake up the body.",
            30,
            listOf("Shoulders", "Spine", "Calves")
        ),

        FixedExercise(
            "Cat Pose",
            R.drawable.cat_pose,
            "On all fours, round your back toward the ceiling and tuck your chin. Breathe deeply and feel your spine stretch gently as you begin moving.",
            20,
            listOf("Upper Back", "Spine")
        ),

        FixedExercise(
            "Cow Pose 1",
            R.drawable.cow_pose_1,
            "From Cat Pose, drop your belly, lift your gaze, and arch your spine. Inhale deeply to open the chest and wake up your breath.",
            20,
            listOf("Spine", "Chest", "Abdominals")
        ),

        FixedExercise(
            "Crescent Pose Standing",
            R.drawable.crescent_pose_standing,
            "Stand upright with arms overhead and clasped. Gently bend side to side to wake up the ribs, spine, and shoulders.",
            30,
            listOf("Latissimus Dorsi", "Obliques", "Spine")
        ),

        FixedExercise(
            "Tiptoe Fierce Pose",
            R.drawable.fierce_pose_3_tiptoe,
            "Rise onto your tiptoes with arms overhead and knees slightly bent. Hold the balance to activate your legs and core, energizing your whole body.",
            20,
            listOf("Chest", "Calves", "Core", "Shoulders")
        ),

        FixedExercise(
            "Standing Cat Stretch",
            R.drawable.cat_stretch_standing_extended_forward_bend,
            "Lean forward with hands on knees and arch your back upward. Alternate between arching and flattening your spine to warm up the back and energize breath.",
            30,
            listOf("Upper Back", "Spine", "Hamstrings")
        ),

        FixedExercise(
            "Back Stretch Reaching",
            R.drawable.back_stretch_reaching,
            "Reach your arms overhead and extend tall. Cross wrists and pull upward to decompress your spine and awaken your posture.",
            30,
            listOf("Back", "Shoulders", "Spine")
        ),

        FixedExercise(
            "Child's Pose",
            R.drawable.child_pose,
            "Finish in Child’s Pose to center your mind. Extend your arms forward and let your breath settle into your belly. Begin your day grounded and ready.",
            45,
            listOf("Spine", "Hips", "Back")
        )



    )


    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*fullBodyFlowExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Lower Back Relief", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d(
                        "WorkoutNavigation",
                        "Exercises set in ViewModel: ${userExercises.joinToString()}"
                    )

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Lower Back Relief")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}



@Composable
fun TechNeckFix(navController: NavHostController, workoutViewModel: WorkoutViewModel) {
    val fullBodyFlowExercises = listOf(
        FixedExercise(
            "Easy Upper Back Stretch",
            R.drawable.easy_upper_back_stretch,
            "Stand with feet apart and lean forward slightly. Gently pull your shoulders downward while extending your neck forward to stretch the upper back and back of the neck.",
            30,
            listOf("Upper Back", "Shoulders", "Spine")
        ),

        FixedExercise(
            "Back Stretch Reaching",
            R.drawable.back_stretch_with_arms_reaching_1,
            "Begin kneeling and reach both arms forward on the mat. Lower your forehead down and let your chest melt toward the ground, stretching through the upper spine and shoulders.",
            45,
            listOf("Back", "Shoulders", "Spine")
        ),

        FixedExercise(
            "Thread the Needle",
            R.drawable.chest_to_floor_twist,
            "From all fours, slide one arm underneath the other and rest your head and shoulder on the mat. This opens the upper back and shoulder girdle. Switch sides after holding.",
            45,
            listOf("Upper Back", "Shoulders", "Spine")
        ),

        FixedExercise(
            "Behind Clasp Backbend",
            R.drawable.backbend_arms_clasped_behind,
            "Stand tall and clasp your hands behind your back. Gently pull your arms down and back as you lift your chest, counteracting tech posture and opening the front body.",
            30,
            listOf("Chest", "Shoulders", "Spine")
        ),

        FixedExercise(
            "Camel Pose Prep",
            R.drawable.camel_pose_prep,
            "Start in a kneeling position with hands on your lower back. Gently press your hips forward and lift your chest without dropping the head back. Focus on opening the chest and easing neck tension.",
            30,
            listOf("Chest", "Spine", "Shoulders")
        ),

        FixedExercise(
            "Chest Rotation Seated",
            R.drawable.chest_rotation_seated,
            "Sit with legs extended and twist toward one side, using your hand to deepen the rotation. Keep your shoulders low and relaxed. Switch sides after holding.",
            30,
            listOf("Chest", "Spine", "Obliques")
        ),

        FixedExercise(
            "Child's Pose",
            R.drawable.child_pose,
            "Sit back on your heels and extend your arms forward. Let your forehead rest on the mat and breathe slowly. Let your shoulders relax and your neck release.",
            60,
            listOf("Spine", "Hips", "Neck")
        )



    )


    // Store exercises in a MutableStateList so users can edit durations
    val userExercises = remember { mutableStateListOf(*fullBodyFlowExercises.toTypedArray()) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Tech Neck Fix", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(userExercises) { exercise ->
                    ExerciseCard(
                        exercise = exercise,
                        onDurationChange = { newDuration ->
                            // ✅ Find and update the modified exercise in the list
                            val index = userExercises.indexOfFirst { it.name == exercise.name }
                            if (index != -1) {
                                userExercises[index] = exercise.copy(duration = newDuration)
                            }
                        },
                        onLongPress = {} // 🚫 No-op
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.d("WorkoutNavigation", "Preparing to navigate...")

                    // ✅ Ensure ViewModel is updated with modified durations
                    workoutViewModel.setExercises(userExercises.toList())
                    Log.d(
                        "WorkoutNavigation",
                        "Exercises set in ViewModel: ${userExercises.joinToString()}"
                    )

                    // ✅ Navigate to WorkoutSlideshow
                    navController.navigate("WorkoutSlideshow/Tech Neck Fix")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Start Workout")
            }
        }
    }
}

