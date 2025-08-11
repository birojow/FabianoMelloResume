package app.birojow.fabianomelloresume.domain

import androidx.annotation.StringRes
import app.birojow.fabianomelloresume.R

enum class AppLanguage(
    @param:StringRes val languageNameId: Int,
    @param:StringRes val flagEmojiId: Int
) {
    EN(R.string.english_language, R.string.great_britain_flag_emoji),
    PT(R.string.portuguese_language, R.string.portugal_flag_emoji),
    ES(R.string.espanol_language, R.string.spain_flag_emoji)
}
