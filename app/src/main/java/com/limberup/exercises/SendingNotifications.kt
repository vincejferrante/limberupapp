package com.limberup.exercises

import android.Manifest
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import java.util.Calendar
import java.util.Locale
import android.provider.Settings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RemindersScreen(navController: NavController) {
    val context = LocalContext.current
    val reminderPreferences = remember { ReminderPreferences(context) }

    var hasPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        )
    }

    val requestPermissionLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission()) { isGranted ->
            hasPermission = isGranted
        }

    var selectedTime by remember { mutableStateOf(Calendar.getInstance()) }
    var showTimePicker by remember { mutableStateOf(false) }
    var isReminderScheduled by remember { mutableStateOf(false) }

    // ✅ Load the saved reminder time when the app starts
    LaunchedEffect(Unit) {
        val (hour, minute) = reminderPreferences.getReminderTime()
        selectedTime = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, 0)
        }

        isReminderScheduled = reminderPreferences.isReminderScheduled()
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Reminders") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Set a Workout Reminder")

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = { showTimePicker = true }) {
                    Text("Pick Reminder Time")
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    "Selected Time: ${
                        String.format(
                            Locale.getDefault(),
                            "%02d:%02d",
                            selectedTime.get(Calendar.HOUR_OF_DAY),
                            selectedTime.get(Calendar.MINUTE)
                        )
                    }"
                )

                Spacer(modifier = Modifier.height(16.dp))
                val coroutineScope = rememberCoroutineScope()

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    if (!hasPermission) {
                        Button(onClick = { requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS) }) {
                            Text("Grant Notification Permission")
                        }
                    } else {
                        Button(
                            onClick = {
                                scheduleReminder(context, selectedTime)
                                coroutineScope.launch(Dispatchers.IO) {
                                    reminderPreferences.setReminderScheduled(true)
                                }
                                isReminderScheduled = true // Update local state immediately
                            },
                            enabled = !isReminderScheduled
                        ) {
                            Text(if (isReminderScheduled) "Reminder Set" else "Set Workout Reminder")
                        }

                    }
                } else {
                    Button(
                        onClick = {
                            scheduleReminder(context, selectedTime)
                            coroutineScope.launch(Dispatchers.IO) {
                                reminderPreferences.setReminderScheduled(true)
                            }
                            isReminderScheduled = true // Update local state immediately
                        },
                        enabled = !isReminderScheduled
                    ) {
                        Text(if (isReminderScheduled) "Reminder Set" else "Set Workout Reminder")
                    }

                }
            }
        }
    }

    val coroutineScope = rememberCoroutineScope()

    if (showTimePicker) {
        TimePickerDialog(
            context,
            { _, hour, minute ->
                val calendar = Calendar.getInstance().apply {
                    set(Calendar.HOUR_OF_DAY, hour)
                    set(Calendar.MINUTE, minute)
                    set(Calendar.SECOND, 0)
                }
                selectedTime = calendar
                showTimePicker = false

                // ✅ Save the selected time using CoroutineScope
                coroutineScope.launch(Dispatchers.IO) {
                    reminderPreferences.saveReminderTime(hour, minute)
                }
            },
            selectedTime.get(Calendar.HOUR_OF_DAY),
            selectedTime.get(Calendar.MINUTE),
            false
        ).show()
    }
}






fun sendWorkoutReminder(context: Context) {
    val channelId = "workout_reminder_channel"
    val notificationId = 1

    // ✅ Check for Notification Permission (Android 13+)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
        ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED
    ) {
        // Permission is not granted, return without showing notification
        return
    }

    // Step 1: Create the Notification Channel (For Android 8+)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val name = "Workout Reminders"
        val descriptionText = "Reminds you about upcoming workouts."
        val importance = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel(channelId, name, importance).apply {
            description = descriptionText
        }
        val notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    // Step 2: Create an Intent for Opening the App When Clicked
    val intent = Intent(context, MainActivity::class.java)
    val pendingIntent = PendingIntent.getActivity(
        context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
    )

    // Step 3: Build the Notification
    val notification = NotificationCompat.Builder(context, channelId)
        .setSmallIcon(android.R.drawable.ic_dialog_info)
        .setContentTitle("Time for Your Workout!")
        .setContentText("Don't forget to complete your scheduled workout session.")
        .setPriority(NotificationCompat.PRIORITY_HIGH) // ✅ Heads-up notification
        .setCategory(NotificationCompat.CATEGORY_REMINDER)
        .setAutoCancel(true) // ✅ Removes notification when clicked
        .setContentIntent(pendingIntent) // ✅ Opens the app when clicked
        .setDefaults(NotificationCompat.DEFAULT_ALL)

    // ✅ Step 4: Ensure Permission is Granted Before Notifying
    try {
        with(NotificationManagerCompat.from(context)) {
            notify(notificationId, notification.build())
        }
    } catch (e: SecurityException) {
        e.printStackTrace() // Log the error if permission is denied
    }
}




fun scheduleReminder(context: Context, calendar: Calendar) {
    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    val intent = Intent(context, ReminderReceiver::class.java)
    val pendingIntent = PendingIntent.getBroadcast(
        context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
    )

    // ✅ Ensure the selected time is in the future
    if (calendar.timeInMillis <= System.currentTimeMillis()) {
        calendar.add(Calendar.DAY_OF_MONTH, 1) // Schedule for the next day
    }

    // ✅ Check if exact alarms are allowed (Android 12+)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        if (!alarmManager.canScheduleExactAlarms()) {
            // 🚨 Ask user to allow exact alarms in system settings
            val intent = Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM)
            context.startActivity(intent)
            return
        }
    }

    try {
        // ✅ Set the exact alarm
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            pendingIntent
        )
    } catch (e: SecurityException) {
        e.printStackTrace() // 🚨 Log the error if permission is missing
    }
}

