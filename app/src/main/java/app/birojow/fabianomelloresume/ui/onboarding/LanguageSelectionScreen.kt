package app.birojow.fabianomelloresume.ui.onboarding

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    onLanguageSelection: (AppLanguage) -> Unit
) {
    val spacingBetweenEmojiAndName = 16.dp
    val textStyle = MaterialTheme.typography.displaySmall

    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(spacingBetweenEmojiAndName),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable(
                    role = Role.Button,
                    onClick = { onLanguageSelection(AppLanguage.EN) }
                )
        ) {
            Text(
                text = stringResource(R.string.great_britain_flag_emoji),
                style = textStyle
            )

            Text(
                text = stringResource(R.string.english_language),
                style = textStyle
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(spacingBetweenEmojiAndName),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable(
                    role = Role.Button,
                    onClick = { onLanguageSelection(AppLanguage.PT) }
                )
        ) {
            Text(
                text = stringResource(R.string.portugal_flag_emoji),
                style = textStyle
            )

            Text(
                text = stringResource(R.string.portuguese_language),
                style = textStyle
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(spacingBetweenEmojiAndName),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable(
                    role = Role.Button,
                    onClick = { onLanguageSelection(AppLanguage.ES) }
                )
        ) {
            Text(
                text = stringResource(R.string.spain_flag_emoji),
                style = textStyle
            )

            Text(
                text = stringResource(R.string.espanol_language),
                style = textStyle
            )
        }
    }
}

@Preview
@Composable
private fun LanguageSelectionScreenLightPreview() {
    AppTheme(darkTheme = false) {
        Surface {
            LanguageSelectionScreen() {}
        }
    }
}

@Preview
@Composable
private fun LanguageSelectionScreenDarkPreview() {
    AppTheme(darkTheme = true) {
        Surface {
            LanguageSelectionScreen() {}
        }
    }
}