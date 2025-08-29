package com.ifound.stores.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ifound.navigation.Routes
import com.ifound.stores.presentation.screens.home.HomeScreen
import com.ifound.stores.presentation.screens.ourTeam.OurTeamScreen
import com.ifound.stores.presentation.screens.ourServices.OurServicesScreen
import com.ifound.stores.presentation.screens.storeDetails.StoreDetailsScreen

fun NavGraphBuilder.storesNavigation(
    navController: NavController
) {
    navigation<Routes.StoresBaseRoute>(startDestination = Routes.Home) {
        composable<Routes.Home> {
            HomeScreen(
                onNavigateToStoreDetail = {
                    navController.navigate(Routes.StoreDetails)
                }
            )
        }
        composable<Routes.StoreDetails> {
            StoreDetailsScreen(
                onNavigateBackToHome = {
                    navController.popBackStack()
                },
                onNavigateToOurTeam = {
                    navController.navigate(Routes.OurTeam)
                },
                onNavigateToOurServices = {
                    navController.navigate(Routes.OurServices)
                },
                onNavigateToBookAppointment = {
                    navController.navigate(Routes.BookAppointment)
                }
            )
        }
        composable<Routes.OurTeam> {
            OurTeamScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onNavigateToBookAppointment = {
                    navController.navigate(Routes.BookAppointment)
                }
            )
        }
        composable<Routes.OurServices> {
            OurServicesScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onNavigateToBookAppointment = {
                    navController.navigate(Routes.BookAppointment)
                }
            )
        }
    }
}