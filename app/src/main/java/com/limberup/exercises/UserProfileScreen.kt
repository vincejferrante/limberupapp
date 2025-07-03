package com.limberup.exercises


import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import android.net.Uri

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfile(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar( // ✅ Stable alternative
                title = { Text("User Profile") },
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
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(32.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = "ACCOUNT", fontSize = 18.sp, color = Color.Gray)
            SettingCard(
                title = "Account Settings",
                onClick = { navController.navigate("account_settings") } // ✅ Navigate to account settings
            )
            Text(text = "SETTINGS", fontSize = 18.sp, color = Color.Gray)
            SettingCard(
                title = "Reminders",
                onClick = { navController.navigate("reminders") } // ✅ Navigate to reminders screen
            )

        }
    }
}


@Composable
fun SettingCard(
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit // ✅ Accepts a function to handle clicks
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 3.dp)
            .height(60.dp)
            .clickable(onClick = onClick), // 👈 Makes it clickable
        contentAlignment = Alignment.Center
    ) {
        // 🔳 Background Shadow (Gray, Slightly Offset with Opacity)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .offset(x = 3.dp, y = 3.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Gray.copy(alpha = 0.3f))
        )

        // 🔲 Foreground Card (White, Centered)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.White),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}


@Composable
fun PrivacyPolicyButton() {
    val context = LocalContext.current
    val url = "https://www.privacypolicies.com/live/3b510406-4f31-4f6c-8fa8-2052773ba382"

    Button(
        onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent)
        },
        shape = RoundedCornerShape(22.dp),
        modifier = Modifier
            .fillMaxWidth(0.7f)
            .height(50.dp)
    ) {
        Text("Privacy Policy", fontSize = 18.sp, fontWeight = FontWeight.Bold)
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountSettingsScreen(
    navController: NavController,
    context: Context,
    statsViewModel: StatsViewModel,
    onStatsReset: () -> Unit // ✅ Trigger recomposition or state update in parent
) {
    val userPreferences = remember { UserPreferences(context) }
    val text = remember { mutableStateOf(userPreferences.getUserName()) }
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Account Settings") },
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = text.value,
                onValueChange = { text.value = it },
                label = { Text("Full Name") },
                placeholder = { Text("Enter your name...") },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(horizontal = 16.dp),
                textStyle = MaterialTheme.typography.bodyLarge,
                singleLine = true,
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    userPreferences.saveUserName(text.value)
                    navController.popBackStack()
                },
                shape = RoundedCornerShape(22.dp),
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(50.dp)
            ) {
                Text("Update", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(16.dp))

            PrivacyPolicyButton()

            // ✅ Show confirmation dialog if user clicks "Delete Stats"
            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = { Text("Confirm Reset") },
                    text = { Text("Are you sure you want to delete your stats? This action cannot be undone.") },
                    confirmButton = {
                        TextButton(onClick = {
                            statsViewModel.resetStats()
                            onStatsReset() // 🔁 Triggers update in parent screen if needed
                            showDialog = false
                        }) {
                            Text("Yes")
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = { showDialog = false }) {
                            Text("Cancel")
                        }
                    }
                )
            }

            // ✅ Button that triggers the dialog
            Button(
                onClick = { showDialog = true },
                shape = RoundedCornerShape(22.dp),
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text("Delete Stats", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
        }
    }
}






