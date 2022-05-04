package io.github.licenseplatecompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.github.linkedmonkeys.State

class MainActivity : ComponentActivity() {
    // Should this be read from a DB or a file?
    private val stateList = listOf(
        State("Alabama", "AL"),
        State("Alaska", "AK"),
        State("Arizona", "AZ"),
        State("Arkansas", "AR"),
        State("California", "CA"),
        State("Colorado", "CO"),
        State("Connecticut", "CT"),
        State("Delaware", "DE"),
        State("Florida", "FL"),
        State("Georgia", "GA"),
        State("Hawaii", "HI"),
        State("Idaho", "ID"),
        State("Illinois", "IL"),
        State("Indiana", "IN"),
        State("Iowa", "IA"),
        State("Kansas", "KS"),
        State("Kentucky", "KY"),
        State("Louisiana", "LA"),
        State("Maine", "ME"),
        State("Maryland", "MD"),
        State("Massachusetts", "MA"),
        State("Michigan", "MI"),
        State("Minnesota", "MN"),
        State("Mississippi", "MS"),
        State("Missouri", "MO"),
        State("Montana", "MT"),
        State("Nebraska", "NE"),
        State("Nevada", "NV"),
        State("New Hampshire", "NH"),
        State("New Jersey", "NJ"),
        State("New Mexico", "NM"),
        State("New York", "NY"),
        State("North Carolina", "NC"),
        State("North Dakota", "ND"),
        State("Ohio", "OH"),
        State("Oklahoma", "OK"),
        State("Oregon", "OR"),
        State("Pennsylvania", "PA"),
        State("Rhode Island", "RI"),
        State("South Carolina", "SC"),
        State("South Dakota", "SD"),
        State("Tennessee", "TN"),
        State("Texas", "TX"),
        State("Utah", "UT"),
        State("Vermont", "VT"),
        State("Virginia", "VA"),
        State("Washington", "WA"),
        State("West Virginia", "WV"),
        State("Wisconsin", "WI"),
        State("Wyoming", "WY"),
    )
//    val statusText = MutableStateFlow("Status Text")
    //var statusText: String  = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // This should probably be factored into another composable function,
            // called from within the Surface.
            Surface {
                OverallUI();
            }
        }
    }

//        setContent {
//            LicensePlateComposeTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    Greeting("Android")
//                }
//            }
//        }

    @Composable
    fun OverallUI() {
        var labelText by remember { mutableStateOf("No state name") }

        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            BuildStateButtons(stateList = stateList,
                clickHandler = { stateName: String -> labelText = stateName })
            Text(text = labelText.toString())
        }
    }


//    var statusText by mutableStateOf("Status text")
//
//    @Composable
//    fun BuildStatusText() {
//        var text by remember { mutableStateOf("dlkfaj") }
////        statusText by remember { mutableStateOf("Click a button") }
//        val myText by statusText.collectAsState()
//        Text(text = myText)
//    }

    @Composable
    fun BuildStateButtons(stateList: List<State>, clickHandler: (String) -> Unit) {
        var i = 0
        for (row in 1..10) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            )
            {
                for (col in 1..5) {
                    val stateName: String = stateList[i].name
                    StateButton(stateList[i], clickHandler = { clickHandler(stateName) })
                    // This version of the call seemed to have the parameter lazily evaluated.
                    // It caused index out of bounds since i is 50 later.
                    // StateButton(stateList[i], clickHandler = { clickHandler(stateList[i].name) })
                    Log.d("TAG", "r=$row, c=$col, i=$i")
                    i++
                }
            }
        }
    }

    @Composable
    fun StateButton(state: State, clickHandler: () -> Unit) {
        var buttonColorState = remember { mutableStateOf(true) }

        Button(
            // Make the textview read the name.
            onClick = {
                clickHandler()
                buttonColorState.value = !buttonColorState.value
            },
//                Toast.makeText(this, "Button Clicked: ${state.name}", Toast.LENGTH_SHORT).show()
//                buttonColorState.value = !buttonColorState.value
//            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (buttonColorState.value) Color.Red else Color.Blue,
                contentColor = Color.White
            )
            //colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.purple_500)),
//            border = BorderStroke(
//                1.dp,
//                color = colorResource(id = R.color.black)
//            )
        )
        {
            Text(state.abbreviation)
        }
    }
}