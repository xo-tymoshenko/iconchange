package dev.tymoshenko.iconchange.config

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import dev.tymoshenko.iconchange.MainActivity
import dev.tymoshenko.iconchange.utils.enableMainActivity

class ConfigActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableMainActivity()
        startActivity(
            Intent(this, MainActivity::class.java).apply {
                putExtra("is_config", true)
            }
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        startActivity(Intent(this, MainActivity::class.java))
    }
}