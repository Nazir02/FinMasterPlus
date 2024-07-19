package tj.khujand.finmasterplus.ui.transferEntry

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.navigation.fragment.findNavController
import tj.khujand.finmasterplus.R
import tj.khujand.finmasterplus.core.showKeyboard
import tj.khujand.finmasterplus.databinding.FragmentAddFinancialEntryBinding

class AddFinancialEntryFragment : Fragment() {
    lateinit var bind: FragmentAddFinancialEntryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = FragmentAddFinancialEntryBinding.inflate(inflater, container, false)
        initData()

        bind.etSumm.requestFocus()
        bind.etSumm.showKeyboard()

        bind.ivArrowLeft.setOnClickListener {
            findNavController().navigateUp()
        }

        return bind.root
    }

    @SuppressLint("SetTextI18n")
    fun initData() {
        arguments?.let { bundle ->
            val stringValue = bundle.getString("param")
            if (stringValue == "Income") {
                bind.clRoot.setBackgroundColor(Color.parseColor("#00A86B"))
                bind.tvTitleToolbar.text = "Income"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)
    }
}