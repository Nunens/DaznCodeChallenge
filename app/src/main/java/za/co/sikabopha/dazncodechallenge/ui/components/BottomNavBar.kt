package za.co.sikabopha.dazncodechallenge.ui.components

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){
    object Event : BottomNavItem("Event", android.R.drawable.ic_menu_gallery,"event")
    object Schedule: BottomNavItem("Schedule",android.R.drawable.ic_menu_day,"schedule")
}