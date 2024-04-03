package com.lokesh.jetpackcomposelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lokesh.jetpackcomposelearning.ui.theme.JetpackComposeLearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeLearningTheme {
                // A surface container using the 'background' color from the theme
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun MyApp(
    modifier: Modifier = Modifier.fillMaxSize(),
    names: List<String> = listOf("Lokesh", "Ayush", "Aaksah")
) {
    var shouldShowOnboarding by remember {
        mutableStateOf(true)
    }
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
//        Greeting(name = "Calling in MyApp")

        if (shouldShowOnboarding) {
            OnboardingScreen(OnCountinueClick = { shouldShowOnboarding = false })
        }
        Column() {
            for (name in names) {
                Greeting(name = name)
            }
        }

    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    val expanded = remember { mutableStateOf(false) }

    val extraPadding = if (expanded.value) 48.dp else 0.dp
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(24.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(
                    text = "Hello",
                    // modifier = modifier
                )
                Text(text = " $name!")
            }
            ElevatedButton(onClick = { expanded.value = !expanded.value }) {
                Text(if (expanded.value) "Show \n less" else "Show more")
            }
        }

    }

}

@Composable
fun OnboardingScreen(OnCountinueClick: () -> Unit, modifier: Modifier = Modifier) {
//    var shouldShowOnboarding by remember{ mutableStateOf(true) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Welcome to the Basics JetCompose!")
        Button(
            onClick = OnCountinueClick,
            modifier = Modifier.padding(vertical = 24.dp)
        ) {
            Text(text = "Continue")
        }
    }
}

//@Preview(showBackground = true,)
//@Composable
//fun GreetingPreview() {
//    JetpackComposeLearningTheme {
//        MyApp()
//    }
//}

//
//@Composable
//fun OnboardingPreview() {
//    JetpackComposeLearningTheme {
//        OnboardingScreen(OnCountinueClick = {})
//    }
//}

//@Composable
//fun Learning(){
//    Button(onClick = { /*TODO*/ }) {
//            Text(text = "Learning")
//    }
//}
//
//
//@Preview(showBackground = true)
//@Composable
//fun LearningPreview(){
//    Learning()
//}