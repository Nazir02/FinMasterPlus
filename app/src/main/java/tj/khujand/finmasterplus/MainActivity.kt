package tj.khujand.finmasterplus

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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

    }
}
