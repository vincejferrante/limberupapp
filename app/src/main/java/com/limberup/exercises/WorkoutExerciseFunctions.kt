package com.limberup.exercises

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable

interface ExerciseInfo {
    val name: String
    val description: String
    val muscleGroups: List<String>
}

@Serializable
data class FixedExercise(
    override val name: String,
    val displayResId: Int,
    override val description: String,
    val duration: Int = 30,
    override val muscleGroups: List<String> = emptyList()
) : ExerciseInfo

data class Exercise(
    override val name: String,
    val displayResId: Int,
    override val description: String,
    val duration: Int = 30,
    override val muscleGroups: List<String> = emptyList()
) : ExerciseInfo


// Global state for selected exercises
val selectedExercises = mutableStateListOf<Exercise>()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuildYourWorkout(navController: NavHostController,  statsViewModel: StatsViewModel) {
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }
    var workoutStarted by remember { mutableStateOf(false) } // ✅ Track workout state
    var searchQuery by remember { mutableStateOf("") }
    val exercises = getExercises()

    Box(modifier = Modifier.fillMaxSize()) {
        // ✅ Hide "Add Exercise" button when workout starts
        if (!workoutStarted) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                Button(
                    onClick = { showBottomSheet = true },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                ) {
                    Text("Add Exercise")
                }
            }
        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Spacer(modifier = Modifier.height(20.dp))

                // ✅ Pass `onWorkoutStart` to ExerciseDisplay
                ExerciseDisplay(
                    navController = navController,
                    statsViewModel = statsViewModel, // ✅ Pass it here
                    onWorkoutStart = { workoutStarted = true }
                )
            }
        }
    }

    // ✅ Bottom Sheet for Selecting Exercises
// Bottom Sheet
    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Select Exercises", fontSize = 18.sp, fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(10.dp))

                // 🔍 Search Bar
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = { Text("Search exercises...") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp)
                )

                // 🧠 Filter based on search
                val filteredExercises = exercises
                    .filter { it.name.contains(searchQuery, ignoreCase = true) }
                    .sortedBy { it.name }


                LazyColumn(
                    modifier = Modifier.fillMaxHeight(0.6f),
                    contentPadding = PaddingValues(bottom = 16.dp)
                ) {
                    items(filteredExercises) { exercise ->
                        ExerciseCheckboxItem(exercise)
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ExerciseSearchBarPreview() {
    var searchText by remember { mutableStateOf("") }

    OutlinedTextField(
        value = searchText,
        onValueChange = { searchText = it },
        placeholder = { Text("Search exercises...") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}


// ✅ New function: ExerciseCheckboxItem
@Composable
fun ExerciseCheckboxItem(exercise: Exercise) {
    var isChecked by remember { mutableStateOf(exercise in selectedExercises) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Exercise name and description
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically, // ✅ Align items vertically in center
            horizontalArrangement = Arrangement.spacedBy(8.dp) // ✅ Adds spacing between items
        ) {
            // ✅ Exercise Image
            Image(
                painter = painterResource(id = exercise.displayResId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp) // ✅ Set a fixed size
                    .clip(CircleShape) // ✅ Make image circular
                    .border(1.dp, Color.Gray, CircleShape) // ✅ Optional border
            )

            // ✅ Text Column (Name + Duration)
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = exercise.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "${exercise.duration} sec",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }

        // Small black checkbox
        Checkbox(
            checked = isChecked,
            onCheckedChange = { checked ->
                if (checked) {
                    if (selectedExercises.size < 50) {
                        isChecked = true
                        if (exercise !in selectedExercises) selectedExercises.add(exercise)
                    } else {
                        // Optional: feedback
                        Log.d("ExerciseLimit", "Max 50 exercises reached")
                    }
                } else {
                    isChecked = false
                    selectedExercises.remove(exercise)
                }
            }
            ,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Black,
                uncheckedColor = Color.DarkGray
            )
        )
    }
}



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExerciseDisplay(
    navController: NavHostController,
    statsViewModel: StatsViewModel, // ✅ Accept statsViewModel
    onWorkoutStart: () -> Unit
) {
    var workoutStarted by remember { mutableStateOf(false) }
    var showDeleteDialog by remember { mutableStateOf(false) }
    var selectedExerciseToDelete by remember { mutableStateOf<Exercise?>(null) }

    if (workoutStarted) {
        WorkoutDisplay(
            navController = navController,
            exercises = selectedExercises.map {
                FixedExercise(
                    name = it.name,
                    displayResId = it.displayResId,
                    description = it.description,
                    duration = it.duration
                )
            },
            statsViewModel = statsViewModel
        )

    } else {
        if (selectedExercises.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .padding(6.dp)
                        .shadow(5.dp, shape = RoundedCornerShape(12.dp))
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.White)
                        .padding(20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Build Your Exercise View",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "No exercises selected.",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(selectedExercises) { exercise ->
                    val index = selectedExercises.indexOf(exercise)

                    ExerciseCard(
                        exercise = FixedExercise(
                            name = exercise.name,
                            displayResId = exercise.displayResId,
                            description = exercise.description,
                            duration = exercise.duration
                        ),
                        onDurationChange = { updated ->
                            selectedExercises[index] = exercise.copy(duration = updated)
                        },
                        onLongPress = {
                            selectedExerciseToDelete = exercise
                            showDeleteDialog = true
                        }
                    )
                }

                // ✅ "Start Workout" Button at the Bottom
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            workoutStarted = true
                            onWorkoutStart()
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
                    ) {
                        Text("Start", color = Color.White)
                    }
                }
            }
        }
    }

    // ✅ Delete Confirmation Dialog
    if (showDeleteDialog) {
        AlertDialog(
            onDismissRequest = { showDeleteDialog = false },
            title = {
                Text(
                    "Delete Exercise?",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            },
            text = {
                Column {
                    Text(
                        "This will remove ${selectedExerciseToDelete?.name}.",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "This action will remove the exercise from your list.",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        selectedExerciseToDelete?.let { selectedExercises.remove(it) }
                        showDeleteDialog = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Delete", color = Color.White)
                }
            },
            dismissButton = {
                OutlinedButton(
                    onClick = { showDeleteDialog = false },
                    border = BorderStroke(1.dp, Color.Gray),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Cancel", color = Color.White)
                }
            },
            containerColor = Color(0xFF1E1E1E), // ✅ Dark background
            tonalElevation = 8.dp // ✅ Adds subtle shadow
        )

    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkoutDisplay(
    navController: NavHostController,
    exercises: List<FixedExercise>,
    statsViewModel: StatsViewModel // ✅ Pass ViewModel as a parameter
) {
    var currentIndex by remember { mutableIntStateOf(0) }
    val context = LocalContext.current
    var showSettings by remember { mutableStateOf(false) }
    val currentExercise = exercises[currentIndex]
    var remainingTime by remember { mutableIntStateOf(currentExercise.duration) }
    var isTimerRunning by remember { mutableStateOf(false) }
    // ✅ Progress Bar Calculation
    val progress = (currentIndex.toFloat() / exercises.size).coerceIn(0f, 1f)
    var soundEnabled by remember { mutableStateOf(true) }
    var vibrationEnabled by remember { mutableStateOf(true) }
    var wasExerciseCompleted by remember { mutableStateOf(false) }

    if (exercises.isEmpty()) {
        Text("No exercises available", fontSize = 16.sp, color = Color.Gray)
        return
    }

    if (currentIndex >= exercises.size) {
        // ✅ Log the workout and exercises completed
        LaunchedEffect(Unit) {
            statsViewModel.incrementWorkout(totalExercises = exercises.size, totalMinutes = exercises.sumOf { it.duration } / 60)
            navController.navigate("stats") {
                popUpTo("build") { inclusive = true }
            }
        }
        return
    }

    if (showSettings) {
        ModalBottomSheet(
            onDismissRequest = { showSettings = false },
            sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
        ) {
            WorkoutSettingsSheetContent(
                soundEnabled = soundEnabled,
                onSoundToggle = { soundEnabled = it },
                vibrationEnabled = vibrationEnabled,
                onVibrationToggle = { vibrationEnabled = it }
            )
        }
    }

    // ✅ Timer countdown
    LaunchedEffect(remainingTime, isTimerRunning) {
        while (remainingTime > 0 && isTimerRunning) {
            delay(1000L)
            remainingTime--
        }
        if (remainingTime == 0 && !wasExerciseCompleted) {
            wasExerciseCompleted = true // ✅ prevent double trigger

            if (currentIndex < exercises.size - 1) {
                if (soundEnabled) playCompletionSound(context)
                if (vibrationEnabled) triggerVibration(context)
                currentIndex++
            } else {
                if (soundEnabled) playCompletionSound(context)
                if (vibrationEnabled) triggerVibration(context)
                statsViewModel.incrementWorkout(
                    totalExercises = exercises.size,
                    totalMinutes = exercises.sumOf { it.duration } / 60
                )
                navController.navigate("stats")
            }
        }
    }

    LaunchedEffect(currentIndex) {
        remainingTime = exercises[currentIndex].duration
        isTimerRunning = false
        wasExerciseCompleted = false // ✅ reset
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        IconButton(
            onClick = {
                Log.d("WorkoutSlideshow", "Workout exited early. No progress saved.")
                navController.navigate("build") {
                    popUpTo("build") { inclusive = true } // remove any previous instance
                    launchSingleTop = true // avoid multiple copies
                }
            },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 12.dp, top = 16.dp)
                .size(48.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Exit Workout",
            )
        }

        IconButton(
            onClick = { showSettings = true },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 12.dp, top = 16.dp)
                .size(48.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "Workout Settings",
                modifier = Modifier.size(28.dp)
            )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // ✅ Workout Title
            Text(
                text = "Current Workout",
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
            )

            // ✅ Progress Bar
            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier.fillMaxWidth()
            )

            // ✅ Exercise Counter
            Text(
                text = "Exercise ${currentIndex + 1} of ${exercises.size}",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            // ✅ Exercise Details with Animation
            AnimatedVisibility(visible = currentExercise != null) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = currentExercise.displayResId),
                        contentDescription = currentExercise.name,
                        modifier = Modifier
                            .size(250.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.Gray, CircleShape)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(), // ✅ Let it grow vertically if needed
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center // ✅ Center the entire row
                    ) {
                        // ✅ Text gets weight and wraps
                        Text(
                            text = currentExercise.name,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            maxLines = 2, // ✅ Wraps into two lines max
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .weight(1f) // ✅ Take available space
                                .padding(end = 8.dp)
                        )

                        // ✅ Info button remains at end
                        ExerciseInfoButton(
                            exercise = currentExercise,
                            onPauseTimer = { isTimerRunning = false }
                        )
                    }



                    Spacer(modifier = Modifier.height(8.dp))

                    // ✅ Display Updated Time
                    Text(
                        text = String.format("%2d:%02d", remainingTime / 60, remainingTime % 60),
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                }
            }

            // ✅ Play/Pause Button
            Button(
                onClick = { isTimerRunning = !isTimerRunning },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(if (isTimerRunning) "Pause" else "Play")
            }

            Spacer(modifier = Modifier.height(24.dp))

            // ✅ Navigation Buttons (Previous / Next)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { if (currentIndex > 0) currentIndex-- },
                    enabled = currentIndex > 0
                ) {
                    Text("Previous")
                }
                Button(
                    onClick = {
                        if (currentIndex < exercises.size - 1) {
                            currentIndex++
                        } else {
                            statsViewModel.incrementWorkout(totalExercises = exercises.size, totalMinutes = exercises.sumOf { it.duration } / 60)
                            navController.navigate("stats") // 🎉 Navigate when done
                        }
                    }
                ) {
                    Text(if (currentIndex < exercises.size - 1) "Next" else "Finish Workout")
                }
            }
        }
    }
}





