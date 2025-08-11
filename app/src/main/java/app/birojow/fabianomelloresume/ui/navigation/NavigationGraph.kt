package app.birojow.fabianomelloresume.ui.navigation

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.runtime.Composable
import androidx.core.os.LocaleListCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.birojow.fabianomelloresume.ui.onboarding.LanguageSelectionScreen

@Composable
fun NavigationGraph(showOnboarding: Boolean) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = if (showOnboarding) Onboarding.LanguageSelectionScreen else HomeScreen
    ) {
        composable<Onboarding.LanguageSelectionScreen> {
            LanguageSelectionScreen {
                val appLocale: LocaleListCompat = LocaleListCompat
                    .forLanguageTags(it.name.lowercase())
                AppCompatDelegate.setApplicationLocales(appLocale)
                navController.navigate(Onboarding.OnboardingResumeScreen)
            }
        }

        composable<Onboarding.OnboardingResumeScreen> {

        }

        composable<Onboarding.OnboardingGuestBookScreen> {

        }

        composable<Onboarding.OnboardingActivitiesScreen> {

        }
    }
}
