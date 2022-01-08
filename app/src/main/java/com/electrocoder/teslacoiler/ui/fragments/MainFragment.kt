package com.electrocoder.teslacoiler.ui.fragments

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.electrocoder.teslacoiler.MainActivity
import com.electrocoder.teslacoiler.R
import com.electrocoder.teslacoiler.databinding.MainFragmentBinding
import java.lang.ClassCastException

class MainFragment : Fragment(), MainActivity.OnMainFabClicked {

    private val viewModel: MainFragmentViewModel by viewModels()

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainFragmentBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextBtn.setOnClickListener {
            findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToSettingsFragment()
            )
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun handleFabClick() {
        Toast.makeText(requireContext(), "handleFabClick: FAB CLICKED", Toast.LENGTH_SHORT).show()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            (activity as MainActivity).setClickHandler(this)
        } catch (e: ClassCastException) {
            Log.e("TAG", "onAttach: ee", e)
        }
    }

}