package com.electrocoder.teslacoiler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.core.view.*
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.electrocoder.teslacoiler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var clickHandler: OnMainFabClicked

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        binding.mainBottomnavigation.background = null
        binding.mainBottomnavigation.menu[1].isEnabled = false
        binding.mainBottomnavigation.menu[1].isCheckable = false

        NavigationUI.setupWithNavController(
            binding.mainBottomnavigation,
        findNavController(R.id.fragment_controller))

        /**
         * Hiding floating button when different destination is selected
         */
        findNavController(R.id.fragment_controller).addOnDestinationChangedListener { controller, destination, arguments ->
            if(destination.id != R.id.mainFragment) {
                //binding.mainFab.isGone = true
                binding.mainFab.hide()
                //binding.emptyBottomappbar.fabCradleMargin = 0f

                binding.mainBottomnavigation.menu.clear()
                binding.mainBottomnavigation.inflateMenu(R.menu.bottom_navigation_menu_full)
            } else {
                //binding.mainFab.isGone = false
                binding.mainFab.show()

                binding.mainBottomnavigation.menu.clear()
                binding.mainBottomnavigation.inflateMenu(R.menu.bottom_navigation_menu)
            }
        }

        binding.mainFab.setOnClickListener {
            clickHandler.handleFabClick()
        }

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            // Apply the insets as a margin to the view. Here the system is setting
            // only the bottom, left, and right dimensions, but apply whichever insets are
            // appropriate to your layout. You can also update the view padding
            // if that's more appropriate.

            view.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                leftMargin = insets.left
                bottomMargin = insets.bottom
                rightMargin = insets.right
                topMargin = insets.top
            }


            // Return CONSUMED if you don't want want the window insets to keep being
            // passed down to descendant views.
            WindowInsetsCompat.CONSUMED
        }

    }

    public fun setClickHandler(clickHandler: OnMainFabClicked) {
        this.clickHandler = clickHandler
    }

    public interface OnMainFabClicked {
        fun handleFabClick()
    }
}