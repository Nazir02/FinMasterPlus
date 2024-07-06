package tj.khujand.finmasterplus

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import tj.khujand.finmasterplus.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bind: ActivityMainBinding
    private var navHostFragment: NavHostFragment? = null

    private  val navController: NavController by lazy {
        navHostFragment = supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
        navHostFragment!!.navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.bottomNavigationMain.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, bundle ->
            when (destination.id){
              R.id.addFinancialEntryFragment ->{
                    hideBottom()
            }
                else ->{
                    showBottom()
                }
        }
//        WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightNavigationBars = true
    }

    }

    private fun hideBottom() = with(bind) {
        if (bottomNavigationMain.isVisible) bottomNavigationMain.isGone = true
        if (fabButton.isVisible) fabButton.isGone = true
    }
    private fun showBottom()= with(bind) {
        if (bottomNavigationMain.isGone) bottomNavigationMain.isVisible= true
        if (fabButton.isGone) fabButton.isVisible= true
    }
}
