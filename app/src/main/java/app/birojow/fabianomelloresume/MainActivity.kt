package app.birojow.fabianomelloresume

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import app.birojow.fabianomelloresume.ui.navigation.NavigationGraph
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
                    NavigationGraph(true)
                }
            }
        }
    }
}
