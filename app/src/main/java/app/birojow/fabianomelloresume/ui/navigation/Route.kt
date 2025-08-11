package app.birojow.fabianomelloresume.ui.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object LanguageSelectionScreen : Route
    @Serializable
    data object OnboardingScreen : Route
    @Serializable
    data object HomeScreen : Route
}
