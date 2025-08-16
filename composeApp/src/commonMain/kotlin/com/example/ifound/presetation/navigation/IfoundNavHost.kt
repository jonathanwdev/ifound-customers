package com.example.ifound.presetation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.ifound.navigation.Routes
import com.ifound.recover_password.presentation.navigation.passwordRecoverNavigation
import com.ifound.sign.presentation.navigation.signNavigation


@Composable
fun IfoundNavHost() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Routes.SignBaseRoute) {

        signNavigation(navController)

        passwordRecoverNavigation(navController)



    }
}