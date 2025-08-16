package app.birojow.fabianomelloresume.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.preferences.core.edit
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.birojow.fabianomelloresume.MainActivity
import app.birojow.fabianomelloresume.dataStore
import app.birojow.fabianomelloresume.ui.home.HomeScreen
import app.birojow.fabianomelloresume.ui.loading.LoadingScreen
import app.birojow.fabianomelloresume.ui.onboarding.OnboardingScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()
    var showOnboarding: Boolean? by remember {
        mutableStateOf(null)
    }
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        context.dataStore.data
            .map {
                it[MainActivity.SHOW_ONBOARDING_KEY] ?: true
            }
            .collect {
                delay(5000)
                showOnboarding = it
            }
    }

    NavHost(
        navController = navController,
        startDestination = when(showOnboarding) {
            true -> Route.OnboardingScreen
            false -> Route.HomeScreen
            else -> Route.LoadingScreen
        }
    ) {
        composable<Route.LoadingScreen> {
            if (showOnboarding == null) {
                LoadingScreen()
            } else {
                navController.navigate(
                    if (showOnboarding == true) {
                        Route.OnboardingScreen
                    } else {
                        Route.HomeScreen
                    }
                )
            }
        }
        composable<Route.OnboardingScreen> {
            val context = LocalContext.current
            val coroutineScope = rememberCoroutineScope()

            OnboardingScreen {
                coroutineScope.launch {
                    context.dataStore.edit {
                        it[MainActivity.SHOW_ONBOARDING_KEY] = false
                    }
                }
                navController.navigate(Route.HomeScreen)
            }
        }

        composable<Route.HomeScreen> {
            HomeScreen()
        }
    }
}
