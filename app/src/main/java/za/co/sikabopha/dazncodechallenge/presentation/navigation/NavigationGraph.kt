package za.co.sikabopha.dazncodechallenge.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import za.co.sikabopha.dazncodechallenge.presentation.ui.components.BottomNavItem
import za.co.sikabopha.dazncodechallenge.presentation.ui.screens.EventScreen
import za.co.sikabopha.dazncodechallenge.presentation.ui.screens.ScheduleScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Event.screen_route)
    {
        composable(BottomNavItem.Event.screen_route) {
            EventScreen()
        }
        composable(BottomNavItem.Schedule.screen_route) {
            ScheduleScreen()
        }
    }
}