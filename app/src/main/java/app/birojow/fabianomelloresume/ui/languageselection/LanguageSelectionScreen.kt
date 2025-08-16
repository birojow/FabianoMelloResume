package app.birojow.fabianomelloresume.ui.languageselection

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.birojow.fabianomelloresume.R
import app.birojow.fabianomelloresume.domain.AppLanguage
import app.birojow.fabianomelloresume.ui.theme.AppTheme

@Composable
internal fun LanguageSelectionScreen(
    modifier: Modifier = Modifier,
    onLanguageSelectionChanged: (AppLanguage) -> Unit,
    onLanguageSelectionConfirmed: () -> Unit
) {
    val spacingBetweenEmojiAndName = 16.dp
    val textStyle = MaterialTheme.typography.headlineMedium
    var selectedLanguage: AppLanguage? by remember {
        mutableStateOf(null)
    }

    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppLanguage.entries.forEach { language ->
            Box(
                modifier = Modifier
                    .selectable(
                        selected = language == selectedLanguage,
                        role = Role.RadioButton,
                        onClick = {
                            onLanguageSelectionChanged(language)
                            selectedLanguage = language
                        }
                    )
                    .then(
                        if (selectedLanguage == language) {
                            Modifier.background(
                                color = MaterialTheme.colorScheme.primaryContainer,
                                shape = RoundedCornerShape(6.dp)
                            )
                        } else {
                            Modifier.background(Color.Transparent)
                        }
                    )
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                val resources = LanguageResources.getFromAppLanguage(language)
                Row(
                    horizontalArrangement = Arrangement.spacedBy(spacingBetweenEmojiAndName),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(resources.flagEmojiResId),
                        style = textStyle
                    )

                    Text(
                        text = stringResource(resources.languageNameResId),
                        style = textStyle
                    )
                }
            }
        }

        Button(
            onClick = onLanguageSelectionConfirmed,
            enabled = selectedLanguage != null
        ) {
            Text(
                text = stringResource(R.string.language_selection_finish_button),
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

private enum class LanguageResources(
    val appLanguage: AppLanguage,
    @param:StringRes val flagEmojiResId: Int,
    @param:StringRes val languageNameResId: Int
) {
    ENGLISH(
        AppLanguage.EN,
        flagEmojiResId = R.string.great_britain_flag_emoji,
        languageNameResId = R.string.english_language
    ),
    PORTUGUESE(
        AppLanguage.PT,
        flagEmojiResId = R.string.portugal_flag_emoji,
        languageNameResId = R.string.portuguese_language
    ),
    SPANISH(
        AppLanguage.ES,
        flagEmojiResId = R.string.spain_flag_emoji,
        languageNameResId = R.string.espanol_language
    );

    companion object {
        fun getFromAppLanguage(appLanguage: AppLanguage): LanguageResources {
            return entries.find { it.appLanguage == appLanguage } ?: ENGLISH
        }
    }
}

@Preview(
    locale = "en",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun LanguageSelectionScreenLightEnPreview() {
    AppTheme {
        Surface {
            LanguageSelectionScreen(
                onLanguageSelectionChanged = {}
            ) { }
        }
    }
}

@Preview(
    locale = "pt",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun LanguageSelectionScreenLightPtPreview() {
    AppTheme {
        Surface {
            LanguageSelectionScreen(
                onLanguageSelectionChanged = {}
            ) { }
        }
    }
}

@Preview(
    locale = "es",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun LanguageSelectionScreenLightEsPreview() {
    AppTheme {
        Surface {
            LanguageSelectionScreen(
                onLanguageSelectionChanged = {}
            ) { }
        }
    }
}

@Preview(
    locale = "en",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun LanguageSelectionScreenDarkEnPreview() {
    AppTheme {
        Surface {
            LanguageSelectionScreen(
                onLanguageSelectionChanged = {}
            ) { }
        }
    }
}

@Preview(
    locale = "pt",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun LanguageSelectionScreenDarkPtPreview() {
    AppTheme {
        Surface {
            LanguageSelectionScreen(
                onLanguageSelectionChanged = {}
            ) { }
        }
    }
}

@Preview(
    locale = "es",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun LanguageSelectionScreenDarkEsPreview() {
    AppTheme {
        Surface {
            LanguageSelectionScreen(
                onLanguageSelectionChanged = {}
            ) { }
        }
    }
}