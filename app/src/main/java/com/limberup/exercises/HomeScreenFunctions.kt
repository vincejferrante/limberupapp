@file:OptIn(ExperimentalFoundationApi::class)

package com.limberup.exercises

import android.content.Context
import android.media.MediaPlayer
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.runtime.*
import kotlinx.coroutines.delay
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import java.util.Locale
import androidx.compose.runtime.remember


class WorkoutViewModel : ViewModel() {
    private val _selectedExercises = MutableStateFlow<List<FixedExercise>>(emptyList())
    val selectedExercises: StateFlow<List<FixedExercise>> = _selectedExercises

    fun setExercises(exercises: List<FixedExercise>) {
        _selectedExercises.value = exercises
        Log.d("WorkoutViewModel", "✅ setExercises called: ${exercises.joinToString { it.name }}")

        if (_selectedExercises.value.isEmpty()) {
            Log.e("WorkoutViewModel", "🚨 ERROR: Exercises list is empty after setting!")
        }
    }

}




@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExerciseCard(
    exercise: FixedExercise,
    onDurationChange: (Int) -> Unit,
    onLongPress: () -> Unit // ✅ Add this
) {
    var updatedDuration by remember { mutableIntStateOf(exercise.duration) }
    val minutes = updatedDuration / 60
    val seconds = updatedDuration % 60

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp)
            .combinedClickable(
                onClick = {}, // Optional: add tap behavior
                onLongClick = onLongPress // ✅ Trigger delete on long press
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),


        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // ✅ Group image and text in a weighted column so text wraps without pushing buttons
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Image(
                    painter = painterResource(id = exercise.displayResId),
                    contentDescription = exercise.name,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Gray, CircleShape)
                )

                Text(
                    text = exercise.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.width(8.dp)) // space between text and buttons

            // Decrease Button
            OutlinedButton(
                onClick = {
                    if (updatedDuration > 10) {
                        updatedDuration -= 10
                        onDurationChange(updatedDuration)
                    }
                },
                shape = CircleShape,
                border = BorderStroke(1.dp, Color.Gray),
                modifier = Modifier.size(40.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text("-", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.width(4.dp))

            // Timer Display
            Text(
                text = String.format(Locale.getDefault(), "%d:%02d", minutes, seconds),
                fontSize = 20.sp,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                modifier = Modifier.width(50.dp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.width(4.dp))

            // Increase Button
            OutlinedButton(
                onClick = {
                    updatedDuration += 15
                    onDurationChange(updatedDuration)
                },
                shape = CircleShape,
                border = BorderStroke(1.dp, Color.Gray),
                modifier = Modifier.size(40.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text("+", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}


//Completed Sound effect
fun playCompletionSound(context: Context) {
    val mediaPlayer = MediaPlayer.create(context, R.raw.success)
    mediaPlayer?.start()
    mediaPlayer.setOnCompletionListener {
        it.release()
    }
}

//Vibration effect
fun triggerVibration(context: Context) {
    val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val manager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
        manager.defaultVibrator
    } else {
        context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val pattern = longArrayOf(0, 150, 100, 300) // delay, vibrate, pause, vibrate
        val effect = VibrationEffect.createWaveform(pattern, -1) // -1 = don’t repeat
        vibrator.vibrate(effect)
    } else {
        @Suppress("DEPRECATION")
        vibrator.vibrate(longArrayOf(0, 150, 100, 300), -1)
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkoutSlideshow(
    navController: NavHostController,
    workoutName: String,
    workoutViewModel: WorkoutViewModel,
    statsViewModel: StatsViewModel // ✅ Add StatsViewModel to track progress
) {
    val exercises by workoutViewModel.selectedExercises.collectAsState() // ✅ Get updated exercises
    val context = LocalContext.current
    var currentIndex by remember { mutableIntStateOf(0) }
    val totalExercises = exercises.size
    var wasExerciseCompleted by remember { mutableStateOf(false) }
    var soundEnabled by remember { mutableStateOf(true) }
    val currentExercise = exercises.getOrNull(currentIndex)
    var remainingTime by remember { mutableIntStateOf(0) }
    var isTimerRunning by remember { mutableStateOf(false) }
    var workoutCompleted by remember { mutableStateOf(false) } // ✅ Track completion status
    var vibrationEnabled by remember { mutableStateOf(true) }
    var showSettings by remember { mutableStateOf(false) }
    // ✅ Progress Bar Calculation
    val progress = (currentIndex.toFloat() / totalExercises).coerceIn(0f, 1f)

    // ✅ Ensure exercise list isn't empty before rendering
    if (exercises.isEmpty()) {
        Log.e("WorkoutSlideshow", "ERROR: No exercises found! Redirecting to home...")
        LaunchedEffect(Unit) {
            delay(2000)
            navController.popBackStack("home", inclusive = false)
        }
        return
    }
    Log.d("WorkoutSlideshow", "✅ Loaded Exercises: ${exercises.joinToString { it.name }}")

    LaunchedEffect(remainingTime, isTimerRunning) {
        if (!isTimerRunning || wasExerciseCompleted) return@LaunchedEffect

        while (remainingTime > 0) {
            delay(1000L)
            remainingTime--
        }

        if (remainingTime == 0) {
            wasExerciseCompleted = true

            if (currentIndex < exercises.size - 1) {
                if (soundEnabled) playCompletionSound(context)
                if (vibrationEnabled) triggerVibration(context)
                currentIndex++
                delay(100L)
                return@LaunchedEffect
            } else if (!workoutCompleted) {
                workoutCompleted = true
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
        wasExerciseCompleted = false
    }

    if (showSettings) {
        ModalBottomSheet(
            onDismissRequest = { showSettings = false },
            sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true) // ✅ Add this
        ) {
            WorkoutSettingsSheetContent(
                soundEnabled = soundEnabled,
                onSoundToggle = { soundEnabled = it },
                vibrationEnabled = vibrationEnabled,
                onVibrationToggle = { vibrationEnabled = it }
            )
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        IconButton(
            onClick = {
                Log.d("WorkoutSlideshow", "Workout exited early. No progress saved.")
                navController.popBackStack("home", inclusive = false)
            },
            modifier = Modifier
                .align(Alignment.TopStart)
                .size(48.dp)
                .padding(start = 12.dp, top = 16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Exit Workout"
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
                text = workoutName,
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
            )

            // ✅ Progress Bar
            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier.fillMaxWidth()
            )

            // ✅ Exercise Counter
            Text(
                text = "Exercise ${currentIndex + 1} of $totalExercises",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            // ✅ Exercise Details with Animation
            AnimatedVisibility(visible = currentExercise != null) {
                currentExercise?.let {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = it.displayResId),
                            contentDescription = it.name,
                            modifier = Modifier
                                .size(250.dp)
                                .clip(CircleShape)
                                .border(2.dp, Color.Gray, CircleShape)
                        )

                        Row (
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = it.name,
                                style = MaterialTheme.typography.headlineMedium,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                textAlign = TextAlign.Center
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            // ✅ Info Button with Modal Popup
                            ExerciseInfoButton(
                                exercise = it,
                                onPauseTimer = { isTimerRunning = false }
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // ✅ Display Updated Time
                        Text(
                            text = String.format(Locale.getDefault(), "%02d:%02d", remainingTime / 60, remainingTime % 60),
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )

                        Spacer(modifier = Modifier.height(16.dp))
                    }
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
                            Log.d("WorkoutSlideshow", "Workout Completed! Navigating to StatsView")

                            // ✅ Track stats before navigating
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



@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ExerciseInfoButton(
    exercise: ExerciseInfo,
    onPauseTimer: () -> Unit,
    modifier: Modifier = Modifier
) {
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)


    OutlinedButton(
        onClick = {
            showBottomSheet = true
            onPauseTimer()
        },
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape),
        contentPadding = PaddingValues(0.dp),
        shape = CircleShape,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Gray
        ),
        border = BorderStroke(1.dp, Color.Transparent)
    ) {
        Icon(
            imageVector = Icons.Filled.Info,
            contentDescription = "Info",
            tint = Color.Gray
        )
    }

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
                Text(
                    text = exercise.name,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                exercise.description.split(".").forEach { sentence ->
                    if (sentence.isNotBlank()) {
                        Row(verticalAlignment = Alignment.Top) {
                            Text("• ", fontWeight = FontWeight.Bold)
                            Text(sentence.trim(), style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }

                if (exercise.muscleGroups.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Muscle Groups:", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(8.dp))
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        exercise.muscleGroups.forEach { group ->
                            AssistChip(
                                onClick = {},
                                label = { Text(group) }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { showBottomSheet = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Close")
                }
            }
        }
    }
}



