package app.birojow.fabianomelloresume.ui.onboarding

import android.content.res.Configuration
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.birojow.fabianomelloresume.R
import app.birojow.fabianomelloresume.ui.theme.AppTheme


@Composable
fun OnboardingScreen(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(
        pageCount = { OnboardingPage.entries.size }
    )

    Column(modifier) {
        HorizontalPager(state = pagerState) { page ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
            ) {
                when (page) {
                    OnboardingPage.FIRST.ordinal -> {
                        OnboardingText(OnboardingPage.FIRST)
                        SwipeArrowsAnimation()

                    }
                    OnboardingPage.SECOND.ordinal -> {
                        OnboardingText(OnboardingPage.SECOND)
                        SwipeArrowsAnimation()
                    }
                    OnboardingPage.THIRD.ordinal -> {
                        OnboardingText(OnboardingPage.THIRD)
                        SwipeArrowsAnimation()
                    }
                    else -> Unit
                }
            }
        }
    }
}

@Composable
private fun BoxScope.OnboardingText(
    page: OnboardingPage,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(page.textId),
        style = MaterialTheme.typography.headlineLarge,
        textAlign = TextAlign.Center,
        modifier = modifier.align(Alignment.Center)
    )
}

@Composable
private fun BoxScope.SwipeArrowsAnimation(modifier: Modifier = Modifier) {
    val alphaTransitionDurationInMillis = 300
    val rotationTransitionDurationInMillis = 4000
    val restingTime = 3000
    val rotationStartingAngle = -35f
    var currentAnimationState by remember {
        mutableStateOf(SwipeAnimationState.INVISIBLE)
    }
    val transition = updateTransition(currentAnimationState, label = "swipeAnimation")

    val alpha by transition.animateFloat(
        label = "alphaTransition",
        transitionSpec = {
            when {
                SwipeAnimationState.INVISIBLE isTransitioningTo SwipeAnimationState.ROTATING -> {
                    tween(alphaTransitionDurationInMillis)
                }
                SwipeAnimationState.ROTATING isTransitioningTo SwipeAnimationState.INVISIBLE -> {
                    tween(alphaTransitionDurationInMillis)
                }
                else -> tween(0)
            }
        }
        ) {
        when(it) {
            SwipeAnimationState.ROTATING -> 1f
            SwipeAnimationState.INVISIBLE -> 0f
        }
    }
    
    val rotation by transition.animateFloat(
        label = "rotationTransition",
        transitionSpec = {
            when {
                SwipeAnimationState.ROTATING isTransitioningTo SwipeAnimationState.INVISIBLE -> {
                    tween(rotationTransitionDurationInMillis)
                }
                SwipeAnimationState.INVISIBLE isTransitioningTo SwipeAnimationState.ROTATING -> {
                    tween(restingTime)
                }
                else -> tween(0)
            }
        }
    ) {
        when(it) {
            SwipeAnimationState.ROTATING -> rotationStartingAngle
            SwipeAnimationState.INVISIBLE -> rotationStartingAngle.unaryMinus()
        }
    }

    LaunchedEffect(transition.currentState) {
        if (transition.currentState == transition.targetState) {
            currentAnimationState = when(transition.currentState) {
                SwipeAnimationState.ROTATING -> {
                    SwipeAnimationState.INVISIBLE
                }
                SwipeAnimationState.INVISIBLE -> {
                    SwipeAnimationState.ROTATING
                }
            }
        }
    }

    Icon(
        modifier = modifier
            .align(Alignment.BottomCenter)
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .size(48.dp)
            .rotate(rotation),
        painter = painterResource(R.drawable.swipe_left),
        contentDescription = null,
        tint = MaterialTheme.colorScheme.primary.copy(alpha = alpha)
    )
}

private enum class SwipeAnimationState {
    ROTATING, INVISIBLE
}

@Preview
@Composable
private fun SwipeArrowsAnimationPreview() {
    AppTheme {
        Surface {
            Box {
                SwipeArrowsAnimation()
            }
        }
    }
}

@Preview(
    locale = "en",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun OnboardingScreenLightEnPreview() {
    AppTheme {
        Surface {
            OnboardingScreen()
        }
    }
}

@Preview(
    locale = "pt",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun OnboardingScreenLightPtPreview() {
    AppTheme {
        Surface {
            OnboardingScreen()
        }
    }
}

@Preview(
    locale = "es",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun OnboardingScreenLightEsPreview() {
    AppTheme {
        Surface {
            OnboardingScreen()
        }
    }
}

@Preview(
    locale = "en",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun OnboardingScreenDarkEnPreview() {
    AppTheme {
        Surface {
            OnboardingScreen()
        }
    }
}

@Preview(
    locale = "pt",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun OnboardingScreenDarkPtPreview() {
    AppTheme {
        Surface {
            OnboardingScreen()
        }
    }
}

@Preview(
    locale = "es",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun OnboardingScreenDarkEsPreview() {
    AppTheme {
        Surface {
            OnboardingScreen()
        }
    }
}
