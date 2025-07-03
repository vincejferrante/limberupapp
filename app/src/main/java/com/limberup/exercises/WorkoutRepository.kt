package com.limberup.exercises


import android.content.Context
import android.content.SharedPreferences
import android.icu.text.SimpleDateFormat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.util.Date
import java.util.Locale




class StatsViewModel(private val repository: StatsRepository) : ViewModel() {
    private val _workoutCount = MutableStateFlow(repository.getWorkoutCount())
    val workoutCount = _workoutCount.asStateFlow()

    private val _exerciseCount = MutableStateFlow(repository.getExerciseCount())
    val exerciseCount = _exerciseCount.asStateFlow()

    private val _totalMinutes = MutableStateFlow(repository.getTotalMinutes())
    val totalMinutes = _totalMinutes.asStateFlow()

    private val _dateOfWorkout = MutableStateFlow(repository.getDateOfWorkout())
    val dateOfWorkout = _dateOfWorkout.asStateFlow()

    fun incrementWorkout(totalExercises: Int, totalMinutes: Int) {
        viewModelScope.launch {
            repository.incrementWorkoutCount()
            repository.incrementExerciseCount(totalExercises)
            repository.addMinutes(totalMinutes)
            repository.setDateOfWorkout()
            repository.updateStreak() // ✅ track daily streak

            _workoutCount.value = repository.getWorkoutCount()
            _exerciseCount.value = repository.getExerciseCount()
            _totalMinutes.value = repository.getTotalMinutes()
            _dateOfWorkout.value = repository.getDateOfWorkout()
        }
    }

    fun resetStats() {
        viewModelScope.launch {
            repository.resetStats()
            _workoutCount.value = 0
            _exerciseCount.value = 0
            _totalMinutes.value = 0
            _dateOfWorkout.value = ""
        }
    }


}




class StatsViewModelFactory(private val repository: StatsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StatsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return StatsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


class UserPreferences(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    fun saveUserName(name: String) {
        prefs.edit().putString("user_name", name).apply()
    }

    fun getUserName(): String {
        return prefs.getString("user_name", "") ?: ""
    }
}

class StatsRepository(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("stats_prefs", Context.MODE_PRIVATE)

    fun getWorkoutCount(): Int = prefs.getInt("workout_count", 0)
    fun getExerciseCount(): Int = prefs.getInt("exercise_count", 0)
    fun getTotalMinutes(): Int = prefs.getInt("total_minutes", 0)
    fun getDateOfWorkout(): String = prefs.getString("date_of_workout", "") ?: ""

    fun incrementWorkoutCount() {
        val newCount = getWorkoutCount() + 1
        prefs.edit().putInt("workout_count", newCount).apply()
    }

    fun incrementExerciseCount(totalExercises: Int) {
        val newCount = getExerciseCount() + totalExercises
        prefs.edit().putInt("exercise_count", newCount).apply()
    }

    fun addMinutes(minutes: Int) {
        val updatedMinutes = getTotalMinutes() + minutes
        prefs.edit().putInt("total_minutes", updatedMinutes).apply()
    }

    fun setDateOfWorkout() {
        val today = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault()).format(Date())
        prefs.edit().putString("date_of_workout", today).apply()
    }

    fun getStreakCount(): Int = prefs.getInt("streak_count", 0)
    fun getLastWorkoutDate(): String = prefs.getString("last_workout_date", "") ?: ""

    fun updateStreak() {
        val today = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault()).format(Date())
        val lastDate = getLastWorkoutDate()

        if (lastDate.isBlank()) {
            // First ever workout — start the streak
            prefs.edit()
                .putInt("streak_count", 1)
                .putString("last_workout_date", today)
                .apply()
            return
        }

        val sdf = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
        val todayDate = sdf.parse(today)
        val lastWorkout = sdf.parse(lastDate)

        val newStreak = when {
            lastWorkout == null || todayDate == null -> 1
            (todayDate.time - lastWorkout.time) / (1000 * 60 * 60 * 24) == 1L -> getStreakCount() + 1
            (todayDate.time - lastWorkout.time) / (1000 * 60 * 60 * 24) == 0L -> getStreakCount()
            else -> 1
        }

        prefs.edit()
            .putInt("streak_count", newStreak)
            .putString("last_workout_date", today)
            .apply()
    }


    fun hasEarnedBadge(): Boolean = getWorkoutCount() >= 10

    fun resetStats() {
        prefs.edit()
            .putInt("workout_count", 0)
            .putInt("exercise_count", 0)
            .putInt("total_minutes", 0)
            .putString("date_of_workout", "")
            .putInt("streak_count", 0)
            .putString("last_workout_date", "")
            .apply()
    }

}


private const val DATASTORE_NAME = "reminder_prefs"

// ✅ Create DataStore instance
val Context.dataStore by preferencesDataStore(name = DATASTORE_NAME)



class ReminderPreferences(private val context: Context) {

    companion object {
        private val REMINDER_HOUR = intPreferencesKey("reminder_hour")
        private val REMINDER_MINUTE = intPreferencesKey("reminder_minute")
        private val IS_REMINDER_SCHEDULED = booleanPreferencesKey("is_reminder_scheduled")
    }

    suspend fun saveReminderTime(hour: Int, minute: Int) {
        context.dataStore.edit { prefs ->
            prefs[REMINDER_HOUR] = hour
            prefs[REMINDER_MINUTE] = minute
        }
    }

    suspend fun getReminderTime(): Pair<Int, Int> {
        val preferences = context.dataStore.data.map { prefs ->
            Pair(
                prefs[REMINDER_HOUR] ?: 7,
                prefs[REMINDER_MINUTE] ?: 0
            )
        }.first()
        return preferences
    }

    suspend fun setReminderScheduled(scheduled: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[IS_REMINDER_SCHEDULED] = scheduled
        }
    }

    suspend fun isReminderScheduled(): Boolean {
        return context.dataStore.data
            .map { prefs -> prefs[IS_REMINDER_SCHEDULED] ?: false }
            .first()
    }
}






