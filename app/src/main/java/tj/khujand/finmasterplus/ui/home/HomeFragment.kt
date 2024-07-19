package tj.khujand.finmasterplus.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
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
            val navController = findNavController()
            val bundle = Bundle().apply {
                putString("param", "Income")
            }
            navController.navigate(R.id.action_homeFragment_to_addFinancialEntryFragment, bundle)
        }
        bind.clExpenses.setOnClickListener {
            val navController = findNavController()
            val bundle = Bundle().apply {
                putString("param", "Expenses")
            }
            navController.navigate(R.id.action_homeFragment_to_addFinancialEntryFragment, bundle)
        }
        return bind.root
    }
}