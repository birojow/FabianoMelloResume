package app.birojow.fabianomelloresume.ui.onboarding

import androidx.annotation.StringRes
import app.birojow.fabianomelloresume.R

enum class OnboardingPage(
    @param:StringRes val textId: Int
) {
    FIRST(R.string.onboarding_page_one_text),
    SECOND(R.string.onboarding_page_two_text),
    THIRD(R.string.onboarding_page_three_text)
}
