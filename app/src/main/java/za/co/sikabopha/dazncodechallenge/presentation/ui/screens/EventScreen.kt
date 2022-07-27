package za.co.sikabopha.dazncodechallenge.presentation.ui.screens

class EventScreen {
    @Composable
    fun HomeScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.blue))
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = "Home Screen",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
        }
    }
}