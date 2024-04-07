package com.example.listen.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType

@Composable
fun ResizableText(text:String, color: Color, modifier: Modifier){
    val defaultFontSize:TextUnit = TextUnit(12f, TextUnitType.Sp)
    var resizableFontSize:TextUnit by remember{mutableStateOf(defaultFontSize)}

    Text(text,  fontSize = resizableFontSize,
        modifier = modifier,
        color = color,
        onTextLayout = {
            if(it.didOverflowWidth){
                resizableFontSize * 0.2
            }
        })
}