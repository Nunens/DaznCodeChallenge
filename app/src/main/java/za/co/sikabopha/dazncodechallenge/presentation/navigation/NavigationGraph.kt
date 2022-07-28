package za.co.sikabopha.dazncodechallenge.presentation.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import za.co.sikabopha.dazncodechallenge.presentation.ui.screens.EventScreen
import za.co.sikabopha.dazncodechallenge.presentation.ui.screens.ScheduleScreen
import za.co.sikabopha.dazncodechallenge.presentation.viewmodel.DaznViewModel

@Composable
fun NavigationGraph(navController: NavHostController, vm: DaznViewModel, context: Context) {
    NavHost(navController, startDestination = BottomNavItem.Event.screen_route)
    {
        composable(BottomNavItem.Event.screen_route) {
            EventScreen(vm, context)
        }
        composable(BottomNavItem.Schedule.screen_route) {
            ScheduleScreen(vm, context)
        }
    }
}