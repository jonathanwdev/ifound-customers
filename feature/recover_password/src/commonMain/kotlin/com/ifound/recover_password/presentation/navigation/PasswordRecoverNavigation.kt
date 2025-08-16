package com.ifound.recover_password.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ifound.navigation.Routes
import com.ifound.recover_password.presentation.screens.confirmCode.ConfirmCodeScreen
import com.ifound.recover_password.presentation.screens.createNewPassword.CreateNewPasswordScreen
import com.ifound.recover_password.presentation.screens.forgotPassword.ForgotPasswordScreen
import com.ifound.recover_password.presentation.screens.passwordUpdated.PasswordUpdatedScreen


fun NavGraphBuilder.passwordRecoverNavigation(
    navController: NavController
) {
    navigation<Routes.PasswordRecoverBaseRoute>(startDestination = Routes.ForgotPassword) {
        composable<Routes.ForgotPassword> {
            ForgotPasswordScreen(
                onNavigateBack = {
                    navController.popBackStack(
                        route = Routes.ForgotPassword,
                        inclusive = true
                    )
                },
                onNavigateToConfirmCode = {
                    navController.navigate(Routes.ConfirmCode)
                }
            )
        }
        composable<Routes.ConfirmCode> {
            ConfirmCodeScreen(
                onNavigateBack = {
                    navController.popBackStack(
                        route = Routes.ConfirmCode,
                        inclusive = true
                    )
                },
                onNavigateToCreateNewPassword = {
                    navController.navigate(Routes.CreateNewPassword)
                }
            )
        }
        composable<Routes.CreateNewPassword> {
            CreateNewPasswordScreen(
                onNavigateBack = {
                    navController.popBackStack(
                        route = Routes.CreateNewPassword,
                        inclusive = true
                    )
                },
                onNavigateToPasswordUpdated = {
                    navController.navigate(Routes.PasswordUpdated)
                }
            )
        }
        composable<Routes.PasswordUpdated> {
            PasswordUpdatedScreen(
                onGoBackToSignIn = {
                    navController.navigate(Routes.SignIn) {
                        popUpTo(Routes.SignIn)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}
