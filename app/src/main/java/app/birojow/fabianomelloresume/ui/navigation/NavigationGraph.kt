package app.birojow.fabianomelloresume.ui.navigation

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.runtime.Composable
import androidx.core.os.LocaleListCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.birojow.fabianomelloresume.ui.home.HomeScreen
import app.birojow.fabianomelloresume.ui.onboarding.LanguageSelectionScreen
import app.birojow.fabianomelloresume.ui.onboarding.OnboardingScreen

@Composable
fun NavigationGraph(showOnboarding: Boolean) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = if (showOnboarding) Route.LanguageSelectionScreen else Route.HomeScreen
    ) {
        composable<Route.LanguageSelectionScreen> {
            LanguageSelectionScreen {
                val appLocale: LocaleListCompat = LocaleListCompat
                    .forLanguageTags(it.name.lowercase())
                AppCompatDelegate.setApplicationLocales(appLocale)
                navController.navigate(Route.OnboardingScreen)
            }
        }

        composable<Route.OnboardingScreen> {
            OnboardingScreen {
                navController.navigate(Route.HomeScreen)
            }
        }

        composable<Route.HomeScreen> {
            HomeScreen()
        }
    }
}
