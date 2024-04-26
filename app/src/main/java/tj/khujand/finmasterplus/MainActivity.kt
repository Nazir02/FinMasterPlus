package tj.khujand.finmasterplus

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import tj.khujand.finmasterplus.ui.history.HistoryFragment
import tj.khujand.finmasterplus.ui.home.HomeFragment
import tj.khujand.finmasterplus.ui.profil.ProfilFragment
import tj.khujand.finmasterplus.ui.report.ReportFragment

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
    private lateinit var bottomNavigationView: BottomNavigationView
    private val previousFragment = arrayListOf(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.bottomNavMenu)
        bottomNavigationView.selectedItemId = R.id.home
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        supportFragmentManager.beginTransaction().apply {

            fun setCustomAnimRtoL() {
                setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left)
            }

            fun setCustomAnimLtoR() {
                setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
            }

            previousFragment.add(item.itemId)
            previousFragment.reverse()

            if (previousFragment[1] == R.id.home && (item.itemId == R.id.history || item.itemId == R.id.reports || item.itemId == R.id.profile)) {
                setCustomAnimRtoL()
            } else if (previousFragment[1] == R.id.history && (item.itemId == R.id.reports || item.itemId == R.id.profile)) {
                setCustomAnimRtoL()
            } else if (previousFragment[1] == R.id.history && item.itemId == R.id.home) {
                setCustomAnimLtoR()
            } else if (previousFragment[1] == R.id.reports && item.itemId == R.id.profile) {
                setCustomAnimRtoL()
            } else if (previousFragment[1] == R.id.reports && (item.itemId == R.id.home || item.itemId == R.id.history)) {
                setCustomAnimLtoR()
            } else if (previousFragment[1] == R.id.profile && (item.itemId == R.id.history || item.itemId == R.id.reports || item.itemId == R.id.home)) {
                setCustomAnimLtoR()
            } else {
                setCustomAnimations(0, 0)
            }
            if (previousFragment[1] != item.itemId) {

                when (item.itemId) {
                    R.id.home -> replace(R.id.frgChanger, HomeFragment())
                    R.id.history -> replace(R.id.frgChanger, HistoryFragment())
                    R.id.reports -> replace(R.id.frgChanger, ReportFragment())
                    R.id.profile -> replace(R.id.frgChanger, ProfilFragment())
                }
                commit()
            }
        }
        previousFragment.reverse()
        return true
    }
}