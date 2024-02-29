package com.example.td1_facture_jetpack

import Login
import Facture
import Profil
import Montant
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Nav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Login") {

        composable(route = "Login") {
            Login(navController)
        }

        composable(
            route = "profil/{log1}/{mdp1}",
            arguments = listOf(
                navArgument(name = "log1") {
                    type = NavType.StringType
                },
                navArgument(name = "mdp1") {
                    type = NavType.StringType
                }
            )
        ) { backstackEntry ->
            Profil(
                navController,
                login = backstackEntry.arguments?.getString("log1"),
                mdp = backstackEntry.arguments?.getString("mdp1").toString()
            )
        }

        composable(route = "facture") {
            Facture(navController)
        }

        composable(
            route = "montant/{ht}/{ttc}",
            arguments = listOf(
                navArgument("ht") { NavType.FloatType },
                navArgument("ttc") { NavType.FloatType }
            )
        ) { backstackEntry ->
            Montant(
                navController,
                ht = backstackEntry.arguments?.getFloat("ht"),
                ttc = backstackEntry.arguments?.getFloat("ttc")
            )
        }

    }
}
