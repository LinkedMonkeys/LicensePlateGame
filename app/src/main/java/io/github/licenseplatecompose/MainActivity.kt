package io.github.licenseplatecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
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
            Column {
//                BuildStatusText()
                BuildStateButtons(stateList)
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
// Change the params for a State object later.
    fun StateButton(state: State) {
        Button(
            // Make the textview read the name.
            onClick = {},
            //colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.purple_500)),
            border = BorderStroke(
                1.dp,
                color = colorResource(id = R.color.black)
            )
        )
        {
            Text(state.abbreviation)
        }
    }

    @Composable
    fun BuildStateButtons(stateList: List<State>) {
        Column {
            var i = 0
            for (row in 1..10) {
                Row {
                    for (col in 1..5) {
                        StateButton(stateList[i])
                        i++
                    }
                }
            }
        }
    }

    //////////////////////////////////////////////////////////////////////
    // Below this line is code modified from the Jetpack Compose Tutorial.
    // https://developer.android.com/jetpack/compose/tutorial
    //////////////////////////////////////////////////////////////////////
    @Preview
    @Composable
    fun PreviewMessageCard() {
        MessageCard(
            msg = Message("Colleague", "Hey, take a look at ...")
        )
    }


    data class Message(val author: String, val body: String)

    @Composable
    fun MessageCard(msg: Message) {
        Column {
            for (row in 1..3) {
                Row(modifier = Modifier.padding(all = 8.dp)) {
                    for (col in 1..3) {
                        Image(
                            painter = painterResource(id = R.drawable.profile_picture),
                            contentDescription = "Content profile picture",
                            modifier = Modifier
                                // Set image size to 40dp
                                .size(40.dp)
                                // Clip image to be shaped as a circle.
                                .clip(CircleShape)
                        )


                        Spacer(modifier = Modifier.width(8.dp))

                        Column {
                            Text(msg.author)
                            // Add a vertical space between the author and the message.
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(msg.body)

//                        StateButton("Arkansas", "AR")
                        }
                    }
                }
            }
        }
    }
}