package tj.khujand.finmasterplus.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import tj.khujand.finmasterplus.R

object NavigationUtil {


    private val navOptions =  NavOptions.Builder()
        .setEnterAnim(R.anim.slide_in_right)
        .setExitAnim(R.anim.slide_out_left)
        .setPopEnterAnim(R.anim.slide_in_left)
        .setPopExitAnim(R.anim.slide_out_right).build()

    fun NavController.navigateTo(id:Int, bundle: Bundle? = null) {
        this.navigate(id,bundle,navOptions)
    }

    fun Fragment.navigateTo(id:Int, bundle: Bundle? = null){
        this.findNavController().navigate(id,bundle,navOptions)
    }
}