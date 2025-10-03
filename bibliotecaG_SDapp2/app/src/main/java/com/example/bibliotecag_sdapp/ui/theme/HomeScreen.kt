package com.example.bibliotecag_sdapp.ui.theme


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.bibliotecag_sdapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text("Hello world!")
        }
    }
}

@Composable
fun MessageCard1(name: String) {
    Text(text = "Hello $name!")
}

@Preview
@Composable
fun PreviewMessageCard1() {
    Column {

    MessageCard1("Android")
    MessageCard1("yo")
    }
}



data class Message(val author: String, val body: String)

@Composable
fun MessageCard2(msg: Message) {
    Text(text = msg.author)
    Text(text = msg.body)
}
@Composable
fun MessageCardFoto(msg: Message) {
    Row {
        Image(
            painter = painterResource(R.drawable.magicbullet),
            contentDescription = "Contact profile picture",
        )

    }

}

@Preview
@Composable
fun PreviewMessageCard2() {

    val msg = Message("Lexi", "Hey, take a look at Jetpack Compose, it's great!")

            Column {
                Text(text = msg.author)
                Text(text = msg.body)
                MessageCardFoto(msg)
            }


}


