package dev.tymoshenko.iconchange

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.tymoshenko.iconchange.ui.theme.IconchangeTheme
import dev.tymoshenko.iconchange.utils.changeIconToDark
import dev.tymoshenko.iconchange.utils.changeIconToLight
import dev.tymoshenko.iconchange.utils.disableConfigActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val isConfigNeeded = intent.getBooleanExtra("is_config", false)
        if (isConfigNeeded) {
            disableConfigActivity()
        }

        enableEdgeToEdge()
        setContent {
            IconchangeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { pv ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(pv)
                    ) {
                        Column(Modifier.align(Alignment.Center)) {
                            Button(
                                onClick = { changeIconToLight() }
                            ) {
                                Text("Change icon to light")
                            }

                            Spacer(Modifier.height(16.dp))

                            Button(
                                onClick = { changeIconToDark() }
                            ) {
                                Text("Change icon to dark")
                            }
                        }
                    }
                }
            }
        }
    }
}