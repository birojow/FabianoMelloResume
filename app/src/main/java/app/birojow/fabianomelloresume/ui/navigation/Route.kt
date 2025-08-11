package app.birojow.fabianomelloresume.ui.navigation

import kotlinx.serialization.Serializable

internal sealed interface Onboarding {
    @Serializable
    data object LanguageSelectionScreen : Onboarding
    @Serializable
    data object OnboardingResumeScreen : Onboarding
    @Serializable
    data object OnboardingGuestBookScreen : Onboarding
    @Serializable
    data object OnboardingActivitiesScreen : Onboarding
}

internal data object HomeScreen
