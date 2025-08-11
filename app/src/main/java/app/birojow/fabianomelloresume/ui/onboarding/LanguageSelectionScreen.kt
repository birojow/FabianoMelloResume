package app.birojow.fabianomelloresume.ui.onboarding

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.birojow.fabianomelloresume.domain.AppLanguage
import app.birojow.fabianomelloresume.ui.theme.AppTheme

@Composable
fun LanguageSelectionScreen(
    modifier: Modifier = Modifier,
    onLanguageSelection: (AppLanguage) -> Unit
) {
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FlagAndLanguage(
            language = AppLanguage.EN,
            onLanguageSelection = onLanguageSelection,
        )

        FlagAndLanguage(
            language = AppLanguage.PT,
            onLanguageSelection = onLanguageSelection,
        )

        FlagAndLanguage(
            language = AppLanguage.ES,
            onLanguageSelection = onLanguageSelection,
        )
    }
}

@Composable
private fun FlagAndLanguage(
    language: AppLanguage,
    onLanguageSelection: (AppLanguage) -> Unit
) {
    val spacingBetweenEmojiAndName = 16.dp
    val flagAndTextPadding = 24.dp
    val interactionShape = RoundedCornerShape(50.dp)
    val textStyle = MaterialTheme.typography.displaySmall

    Row(
        horizontalArrangement = Arrangement.spacedBy(spacingBetweenEmojiAndName),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(interactionShape)
            .clickable(
                role = Role.Button,
                onClick = { onLanguageSelection(language) }
            )
    ) {
        Text(
            text = stringResource(language.flagEmojiId),
            style = textStyle,
            modifier = Modifier
                .padding(vertical = flagAndTextPadding)
                .padding(start = flagAndTextPadding)
        )

        Text(
            text = stringResource(language.languageNameId),
            style = textStyle,
            modifier = Modifier
                .padding(vertical = flagAndTextPadding)
                .padding(end = flagAndTextPadding)
        )
    }
}

@Preview
@Composable
private fun LanguageSelectionScreenLightPreview() {
    AppTheme(darkTheme = false) {
        Surface {
            LanguageSelectionScreen {}
        }
    }
}

@Preview
@Composable
private fun LanguageSelectionScreenDarkPreview() {
    AppTheme(darkTheme = true) {
        Surface {
            LanguageSelectionScreen {}
        }
    }
}