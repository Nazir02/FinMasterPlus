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
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        // Инициализация NavHostFragment и NavController
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.frgChanger) as? NavHostFragment
            ?: throw IllegalStateException("NavHostFragment is not found")
        navController = navHostFragment.navController

        // Настройка BottomNavigationView с NavController
        bind.bottomNavigationView.setupWithNavController(navController)
        bind.bottomNavigationView.background=null
        

        // Привязка FAB к BottomAppBar
        bind.fab.setOnClickListener {
            // Ваш код для действия при нажатии на FAB
        }
    }
}
