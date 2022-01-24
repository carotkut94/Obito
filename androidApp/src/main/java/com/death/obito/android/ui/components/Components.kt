package com.death.obito.android.ui.components

import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.death.obito.Server

@Composable
fun ServerCard(serverDetails: Server, modifier: Modifier) {
    val (animState, setAnimState) = remember { mutableStateOf(0) }
    val elevations: Dp by animateDpAsState(
        targetValue = if (animState == 0) 16.dp else 8.dp,
        finishedListener = {
            setAnimState(0)
        })

    Card(
        modifier = modifier.pointerInput(Unit) {
            detectTapGestures(
                onPress = {
                    setAnimState(1)
                    Log.e("SomeTag", "Card tapped")
                },
            )
        },
        elevation = elevations,
    ) {
        Column {
            Text(text = serverDetails.name, modifier = Modifier.padding(16.dp))
        }
    }
}