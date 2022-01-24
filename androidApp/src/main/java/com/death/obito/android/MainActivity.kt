package com.death.obito.android

import android.graphics.Color
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.death.obito.Server
import com.death.obito.android.ui.components.ServerCard
import com.death.obito.android.ui.theme.AndroidAppTheme
import com.death.obito.android.ui.theme.Purple200
import com.death.obito.db.DatabaseDriverFactory
import com.death.obito.provider.ServiceProvider

class MainActivity : ComponentActivity() {

    private val serviceProvider by lazy {
        ServiceProvider.Builder(DatabaseDriverFactory(applicationContext)).build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidAppTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = getString(R.string.servers)) }
                        )
                    },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {

                            },
                            backgroundColor = Purple200
                        ) {
                            Icon(
                                Icons.Filled.Add,
                                contentDescription = getString(R.string.add_server),
                                modifier = Modifier.size(ButtonDefaults.IconSize)
                            )
                        }
                    }
                ) {
                    LazyColumn(content = {
                        for (i in 1..100) {
                            item {
                                ServerCard(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(
                                            top = 16.dp,
                                            end = 16.dp,
                                            start = 16.dp,
                                            bottom = if (i == 100) 16.dp else 0.dp
                                        ), serverDetails = Server(i.toLong(), "Sample", "Sample")
                                )
                            }
                        }
                    })
                }
            }
        }
    }
}
