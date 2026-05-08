package com.example.letssopt.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.letssopt.common.util.AuthPreference
import com.example.letssopt.designsystem.component.Bar.WatchaBottomBar
import com.example.letssopt.designsystem.data.BottomBarTab
import com.example.letssopt.designsystem.data.icons
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
import kotlinx.collections.immutable.toImmutableList

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
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                val selectedTab = when (currentRoute) {
                    Main::class.qualifiedName -> BottomBarTab.MAIN
                    Category::class.qualifiedName -> BottomBarTab.CATEGORY
                    Webtoon::class.qualifiedName -> BottomBarTab.WEBTOON
                    Search::class.qualifiedName -> BottomBarTab.SEARCH
                    Folder::class.qualifiedName -> BottomBarTab.FOLDER
                    else -> null
                }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        selectedTab?.let {
                            WatchaBottomBar(
                                items = icons.toImmutableList(),
                                selectedTab = it,
                                onItemClick = { tab ->
                                    navController.navigate(tab.route) {
                                        launchSingleTop = true
                                    }
                                }
                            )
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = startDestination,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable<Login> {
                            LoginScreen(
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