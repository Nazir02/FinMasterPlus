package tj.khujand.finmasterplus.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tj.khujand.finmasterplus.R
import tj.khujand.finmasterplus.core.NavigationUtil.navigateTo
import tj.khujand.finmasterplus.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var bind: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = FragmentHomeBinding.inflate(inflater, container, false)

        bind.clIncome.setOnClickListener {
            navigateTo(R.id.addFinancialEntryFragment)
        }
        bind.clExpenses.setOnClickListener {
            navigateTo(R.id.addFinancialEntryFragment)
        }
        return bind.root
    }
}