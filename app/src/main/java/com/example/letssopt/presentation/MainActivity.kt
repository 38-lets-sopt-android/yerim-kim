package com.example.letssopt.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.letssopt.common.util.AuthPreference
import com.example.letssopt.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.presentation.category.CategoryScreen
import com.example.letssopt.presentation.folder.FolderScreen
import com.example.letssopt.presentation.login.LoginScreen
import com.example.letssopt.presentation.main.MainScreen
import com.example.letssopt.presentation.navigation.Category
import com.example.letssopt.presentation.navigation.Folder
import com.example.letssopt.presentation.navigation.Login
import com.example.letssopt.presentation.navigation.Main
import com.example.letssopt.presentation.navigation.Search
import com.example.letssopt.presentation.navigation.SignUp
import com.example.letssopt.presentation.navigation.Webtoon
import com.example.letssopt.presentation.search.SearchScreen
import com.example.letssopt.presentation.signup.SignUpScreen
import com.example.letssopt.presentation.webtoon.WebtoonScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val authPreference = AuthPreference(this)

        setContent {
            LETSSOPTTheme {
                val navController = rememberNavController()

                val startDestination = if (authPreference.isLoggedIn()) {
                    Main
                } else {
                    Login
                }

                @Suppress("UnusedMaterial3ScaffoldPaddingParameter") // innerPadding 안 쓰려고... 
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { _->
                    NavHost(
                        navController = navController,
                        startDestination = startDestination

                    ) {
                        composable<Login> {
                            LoginScreen(
                                savedEmail = navController.currentBackStackEntry
                                    ?.savedStateHandle
                                    ?.get<String>("email"),
                                savedPassword = navController.currentBackStackEntry
                                    ?.savedStateHandle
                                    ?.get<String>("password"),
                                toSignUp = {
                                    navController.navigate(SignUp)
                                },
                                toMain = {
                                    authPreference.setLoggedIn(true)

                                    navController.navigate(Main) {
                                        popUpTo<Login> {
                                            inclusive = true
                                        }
                                    }
                                }
                            )
                        }

                        composable<SignUp> {
                            SignUpScreen(
                                onSignUpSuccess = { email, password ->
                                    navController.previousBackStackEntry
                                        ?.savedStateHandle
                                        ?.set("email", email)

                                    navController.previousBackStackEntry
                                        ?.savedStateHandle
                                        ?.set("password", password)

                                    navController.popBackStack()
                                }
                            )
                        }

                        composable<Main> { MainScreen(navController = navController) }
                        composable<Category> { CategoryScreen(navController = navController) }
                        composable<Webtoon> { WebtoonScreen(navController = navController) }
                        composable<Search> { SearchScreen(navController = navController) }
                        composable<Folder> { FolderScreen(navController = navController) }
                    }
                }
            }
        }
    }
}