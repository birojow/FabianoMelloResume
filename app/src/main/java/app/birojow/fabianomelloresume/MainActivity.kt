package app.birojow.fabianomelloresume

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.material3.Surface
import androidx.core.os.LocaleListCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.birojow.fabianomelloresume.ui.onboarding.LanguageSelectionScreen
import app.birojow.fabianomelloresume.ui.onboarding.LanguageTestScreen
import app.birojow.fabianomelloresume.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            AppTheme {
                Surface {
                    NavHost(
                        navController = navController,
                        startDestination = "language-selection"
                    ) {
                        composable("language-selection") {
                            LanguageSelectionScreen {
                                val appLocale: LocaleListCompat = LocaleListCompat
                                    .forLanguageTags(it.name.lowercase())
                                AppCompatDelegate.setApplicationLocales(appLocale)
                                navController.navigate("language-test")
                            }
                        }

                        composable("language-test") {
                            LanguageTestScreen()
                        }
                    }
                }
            }
        }
    }
}
