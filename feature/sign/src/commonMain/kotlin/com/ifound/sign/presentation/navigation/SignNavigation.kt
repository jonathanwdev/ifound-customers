package com.ifound.sign.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ifound.navigation.Routes
import com.ifound.sign.presentation.screens.signIn.SignInScreen
import com.ifound.sign.presentation.screens.signUp.SignUpScreen


fun NavGraphBuilder.signNavigation(
    navController: NavController
) {
    navigation<Routes.SignBaseRoute>(startDestination = Routes.SignIn) {
        composable<Routes.SignIn> {
            SignInScreen(
                onNavigateToSignUp = {
                    navController.navigate(Routes.SignUp)
                },
                onNavigateToRecoverPassword = {
                    navController.navigate(Routes.ForgotPassword)
                }
            )
        }
        composable<Routes.SignUp> {
            SignUpScreen(
                onGoBack = {
                    navController.popBackStack(
                        route = Routes.SignUp,
                        inclusive = true
                    )
                },
            )
        }
    }
}

