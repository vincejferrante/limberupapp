@file:OptIn(ExperimentalFoundationApi::class)

package com.limberup.exercises

import androidx.compose.foundation.ExperimentalFoundationApi
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.limberup.exercises.ui.theme.LimberUpTheme
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    private val workoutViewModel: WorkoutViewModel by viewModels() // ✅ Retains WorkoutViewModel

    private val statsViewModel: StatsViewModel by viewModels {
        val repository =
            StatsRepository(applicationContext) // ✅ Use StatsRepository, not WorkoutRepository
        StatsViewModelFactory(repository) // ✅ Corrected ViewModel initialization
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LimberUpTheme {
                MainScreen(workoutViewModel, statsViewModel) // ✅ Corrected to use MainScreen
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    LimberUpTheme {
        // Provide mock ViewModels or simplified preview content if needed
        MainScreen(
            workoutViewModel = WorkoutViewModel(),
            statsViewModel = StatsViewModel(StatsRepository(LocalContext.current))
        )
    }
}


// ✅ Data class for Bottom Navigation Items
data class BottomNavItem(val icon: ImageVector, val route: String)

@Composable
fun MainScreen(workoutViewModel: WorkoutViewModel, statsViewModel: StatsViewModel) {
    val navController = rememberNavController()
    val context = LocalContext.current // ✅ Retrieve the actual context

    Scaffold(
        bottomBar = {
            val currentRoute = currentRoute(navController)
            if (currentRoute != null && !currentRoute.startsWith("WorkoutSlideshow")) {
                BottomNavigationBar(navController)
            }
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                NavigationGraph(navController, workoutViewModel, statsViewModel, context) // ✅ Properly pass the retrieved context
            }

        }
    )
}


@Composable
fun NavigationGraph(
    navController: NavHostController,
    workoutViewModel: WorkoutViewModel, // ✅ Make sure it's included
    statsViewModel: StatsViewModel,
    context: Context
) {
    var statsResetKey by remember { mutableStateOf(0) }
    NavHost(
        navController,
        startDestination = "home",
        modifier = Modifier.fillMaxSize()
    ) {

        composable("home") { HomeView(navController, context) }
        composable("build") { BuildYourWorkout(navController, statsViewModel) }
        composable("MorningWorkoutRoutine") { MorningWorkoutRoutine(navController, workoutViewModel) }
        composable("YogaImprovedFlexibility") { YogaImprovedFlexibility(navController, workoutViewModel) }
        composable("WorkoutSlideshow/{workoutName}") { backStackEntry ->
            val workoutName = backStackEntry.arguments?.getString("workoutName") ?: "Workout"
            WorkoutSlideshow(navController, workoutName, workoutViewModel, statsViewModel) // ✅ Pass StatsViewModel here
        }

        composable("user_profile") { UserProfile(navController) }
        composable("account_settings") {
            AccountSettingsScreen(navController, context, statsViewModel) {
                statsResetKey++ // callback passed from parent
            }
        }
        composable("stats") {
            StatsView(statsViewModel = statsViewModel, resetKey = statsResetKey)
        } // 🔥 Use "stats" instead of "StatsView"


        composable("reminders") { RemindersScreen(navController) }
        composable("ShouldersView") {
            ShouldersView(
                navController = navController,
                onDismiss = { navController.popBackStack() })
        }
        composable("UpperBackView") {
            UpperBackView(
                navController = navController,
                onDismiss = { navController.popBackStack() })
        }
        composable("LowerBackView") {
            LowerBackView(
                navController = navController,
                onDismiss = { navController.popBackStack() })
        }
        composable("HamstringsView") {
            HamstringsView(
                navController = navController,
                onDismiss = { navController.popBackStack() })
        }
        composable("QuadsView") {
            QuadsView(
                navController = navController,
                onDismiss = { navController.popBackStack() })
        }
        composable("HipsView") {
            HipsView(
                navController = navController,
                onDismiss = { navController.popBackStack() })
        }
        composable("PostureView") {
            PostureView(
                navController = navController,
                onDismiss = { navController.popBackStack() })
        }
        composable("CoreView") {
            CoreView(
                navController = navController,
                onDismiss = { navController.popBackStack() })
        }
        composable("ChestView") {
            ChestView(
                navController = navController,
                onDismiss = { navController.popBackStack() })
        }
        composable("NeckView") {
            NeckView(
                navController = navController,
                onDismiss = { navController.popBackStack() })
        }
        //Core Screens
        composable("core1_screen") { CoreOne(navController, workoutViewModel) }
        composable("core2_screen") { CoreTwo(navController, workoutViewModel) }
        composable("core3_screen") { CoreThree(navController, workoutViewModel) }
        composable("core4_screen") { CoreFour(navController, workoutViewModel) }
        //Neck Screens
        composable("neck1_screen") { NeckOne(navController, workoutViewModel) }
        composable("neck2_screen") { NeckTwo(navController, workoutViewModel) }
        //Chest Screens
        composable("chest1_screen") { ChestOne(navController, workoutViewModel) }
        composable("chest2_screen") { ChestTwo(navController, workoutViewModel) }
        composable("chest3_screen") { ChestThree(navController, workoutViewModel) }
        //Posture Screens
        composable("posture1_screen") { PostureOne(navController, workoutViewModel) }
        composable("posture2_screen") { PostureTwo(navController, workoutViewModel) }
        composable("posture3_screen") { PostureThree(navController, workoutViewModel) }
        //Hips View
        composable("hips1_screen") { HipsOne(navController, workoutViewModel) }
        composable("hips2_screen") { HipsTwo(navController, workoutViewModel) }
        composable("hips3_screen") { HipsThree(navController, workoutViewModel) }
        //Shoulders View
        composable("shoulders1_screen") { SholderOne(navController, workoutViewModel) }
        composable("shoulders2_screen") { SholderTwo(navController, workoutViewModel) }
        composable("shoulders3_screen") { SholderThree(navController, workoutViewModel) }
        composable("shoulders4_screen") { SholderFour(navController, workoutViewModel) }
        //Upper Back View
        composable("upper_back_screen1") { UpperBackOne(navController, workoutViewModel) }
        composable("upper_back_screen2") { UpperBackTwo(navController, workoutViewModel) }
        composable("upper_back_screen3") { UpperBackThree(navController, workoutViewModel) }
        composable("upper_back_screen4") { UpperBackFour(navController, workoutViewModel) }
        //Lower Back View
        composable("lower_back1") { LowerBackOne(navController, workoutViewModel) }
        composable("lower_back2") { LowerBackTwo(navController, workoutViewModel) }
        composable("lower_back3") { LowerBackThree(navController, workoutViewModel) }
        //Hamstring View
        composable("hamstrings1_screen") { HamstringsOne(navController, workoutViewModel) }
        composable("hamstrings2_screen") { HamstringsTwo(navController, workoutViewModel) }
        composable("hamstrings3_screen") { HamstringsThree(navController, workoutViewModel) }
        //Quads View
        composable("quads1_screen") { QuadsOne(navController, workoutViewModel) }
        composable("quads2_screen") { QuadsTwo(navController, workoutViewModel) }
        composable("quads3_screen") { QuadsThree(navController, workoutViewModel) }
        //Recommended workouts
        composable("TechNeck") { TechNeck(navController, workoutViewModel) }
        //Quick and Easy Workouts
        composable("WristReset") { WristReset(navController, workoutViewModel) }
        composable("SleepReset") { SleepReset(navController, workoutViewModel) }
        composable("DeskDetox") { DeskDetox(navController, workoutViewModel) }
        composable("WakeAndShake") { WakeAndShake(navController, workoutViewModel) }
        composable("LowerBackRelief") { LowerBackRelief(navController, workoutViewModel) }
        composable("TechNeckFix") { TechNeckFix(navController, workoutViewModel) }
        //Recommended
        composable("FlexibilityFlow") { FlexibilityFlow(navController, workoutViewModel) }
        composable("CorePower") { CorePower(navController, workoutViewModel) }
        composable("FullBodyFlow") { FullBodyFlow(navController, workoutViewModel) }
        composable("HamstringStretchRoutine") { HamstringStretchRoutine(navController, workoutViewModel) }
        composable("SpinalTwistReset") { SpinalTwistReset(navController, workoutViewModel) }
        composable("GluteActivationSeries") { GluteActivationSeries(navController, workoutViewModel) }
        composable("UpperBackReliefFlow") { UpperBackReliefFlow(navController, workoutViewModel) }
        composable("EnergyBoost") { EnergyBoost(navController, workoutViewModel) }
        composable("UnwindFlow") { UnwindFlow(navController, workoutViewModel) }



    }
}


@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem(Icons.Filled.Home, "home"),
        BottomNavItem(Icons.Filled.FitnessCenter, "build"),
        BottomNavItem(Icons.Filled.Analytics, "stats")
    )

    val currentRoute = currentRoute(navController) ?: "home"

    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 6.dp, // Soft shadow for floating feel
        modifier = Modifier.height(42.dp) // Clean, minimal height
    ) {
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) { inclusive = false }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.route,
                        modifier = Modifier.size(22.dp)
                    )
                },
                alwaysShowLabel = false,
                label = { }
            )
        }
    }
}




// ✅ Helper function to get current route
@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}


@Composable
fun SquareBox(titleText: String, statsInput: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .aspectRatio(1f) // ✅ Makes it square
    ) {
        // Shadow layer
        Box(
            modifier = Modifier
                .matchParentSize()
                .offset(x = 4.dp, y = 6.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.Gray.copy(alpha = 0.2f))
        )

        // Foreground
        Box(
            modifier = Modifier
                .matchParentSize()
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = titleText,
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = statsInput,
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

data class Badge(val name: String, val emoji: String, val isEarned: Boolean)


fun getEarnedBadges(workoutCount: Int): List<Badge> {
    return listOf(
        Badge(name = "Rookie", emoji = "🥉", isEarned = workoutCount >= 1),
        Badge(name = "Dedicated", emoji = "💪", isEarned = workoutCount >= 5),
        Badge(name = "10 Workout Club", emoji = "🏅", isEarned = workoutCount >= 10),
        Badge(name = "20 Workout Beast", emoji = "🔥", isEarned = workoutCount >= 20),
        Badge(name = "50 Session Master", emoji = "👑", isEarned = workoutCount >= 50)
    ).filter { it.isEarned }
}



@Composable
fun StatsView(statsViewModel: StatsViewModel?, resetKey: Int) {
    key(resetKey) {  // ✅ Recompose all this when resetKey changes

        if (statsViewModel == null) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Loading stats...", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        } else {
            val workoutCount by statsViewModel.workoutCount.collectAsState()
            val exerciseCount by statsViewModel.exerciseCount.collectAsState()
            val totalMinutes by statsViewModel.totalMinutes.collectAsState()
            val dateOfWorkout by statsViewModel.dateOfWorkout.collectAsState()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Your Stats", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(24.dp))

                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            SquareBox("Workouts", workoutCount.toString(), modifier = Modifier.weight(1f))
                            SquareBox("Exercises", exerciseCount.toString(), modifier = Modifier.weight(1f))
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            SquareBox("Minutes", "$totalMinutes min", modifier = Modifier.weight(1f))
                            SquareBox("Last Workout", dateOfWorkout, modifier = Modifier.weight(1f))
                        }

                        Spacer(modifier = Modifier.height(24.dp))
                        Text("Badges Earned", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)

                        val badges = getEarnedBadges(workoutCount)

                        if (badges.isEmpty()) {
                            Text("No badges earned yet. Keep going! 💪", color = Color.Gray)
                        } else {
                            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                badges.forEach { badge ->
                                    Text("${badge.emoji} ${badge.name}", fontSize = 16.sp)
                                }
                            }
                        }
                    }
                }
            }
        }


    }
}
