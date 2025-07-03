package com.limberup.exercises


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun WorkoutSettingsSheetContent(
    soundEnabled: Boolean,
    onSoundToggle: (Boolean) -> Unit,
    vibrationEnabled: Boolean,
    onVibrationToggle: (Boolean) -> Unit
) {
    Column(modifier = Modifier.padding(24.dp)) {
        Text("Workout Settings", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Sound")
            Spacer(Modifier.weight(1f))
            Switch(checked = soundEnabled, onCheckedChange = onSoundToggle)
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Vibration")
            Spacer(Modifier.weight(1f))
            Switch(checked = vibrationEnabled, onCheckedChange = onVibrationToggle)
        }
    }
}
