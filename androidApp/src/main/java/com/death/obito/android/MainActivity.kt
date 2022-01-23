package com.death.obito.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.death.obito.android.ui.theme.AndroidAppTheme
import com.death.obito.db.DatabaseDriverFactory
import com.death.obito.provider.ServiceProvider

class MainActivity : ComponentActivity() {

    private val serviceProvider  by lazy {
        ServiceProvider.Builder(DatabaseDriverFactory(applicationContext)).build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    VersionText("Sample Text")
                }
            }
        }
        saveServer()
    }

    private fun saveServer(){
        serviceProvider.appService.db.saveServer("Server", "Sample Server")
    }
}

@Composable
fun VersionText(data:String){
    Text(data)
}
