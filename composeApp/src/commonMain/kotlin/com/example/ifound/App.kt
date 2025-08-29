package com.example.ifound

import androidx.compose.runtime.*
import com.example.ifound.presetation.navigation.IfoundNavHost
import com.ifound.ui.theme.IfoundTheme


@Composable
fun App() {
    IfoundTheme() {
        IfoundNavHost()
    }

}



