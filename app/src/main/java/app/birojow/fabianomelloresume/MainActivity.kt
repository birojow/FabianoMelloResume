package app.birojow.fabianomelloresume

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import app.birojow.fabianomelloresume.ui.onboarding.LanguageSelectionScreen
import app.birojow.fabianomelloresume.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Surface {
                    LanguageSelectionScreen {
                        Toast.makeText(
                            this,
                            it.name,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}
