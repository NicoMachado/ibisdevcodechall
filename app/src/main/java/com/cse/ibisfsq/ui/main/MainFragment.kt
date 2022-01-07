package com.cse.ibisfsq.ui.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.cse.ibisfsq.R
import com.cse.ibisfsq.Resource
import com.cse.ibisfsq.Status
import com.cse.ibisfsq.databinding.MainFragmentBinding
import com.cse.ibisfsq.retrofit.RetrofitInstance
import com.cse.ibisfsq.ui.places.PlacesFragment
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.flow.collect

class MainFragment : Fragment(R.layout.main_fragment) {
    companion object {
        private const val TAG = "MainFragment"
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels({requireActivity()})
    //private val viewmodel: MainViewModel by activityViewModels()

    private var searchQuery : String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = MainFragmentBinding.bind(view)

        binding.venueSearchEditText.setOnKeyListener { view, keyCode, _ ->  handleKeyEvent(view, keyCode) }

        binding.btnSearch.setOnClickListener {
            val query : String = binding.venueSearchEditText.text.toString()
            if (query.isNullOrEmpty()) {
                Toast.makeText(requireContext(), "Error: Please insert a place to search!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            Log.d(TAG, "setOnClickListener: ")
            viewModel.onSearchClicked(query)
        }

        viewModel.responseLiveData.observe(viewLifecycleOwner, {
            Log.d(TAG, "responseLiveData.observe: ")
            it?.apply {
                if (this.status == Status.ERROR) {
                    binding.progressBar.isVisible = false
                    Toast.makeText(requireContext(), "Error: ${this.message}", Toast.LENGTH_LONG).show()
                    return@observe
                } else if (this.status == Status.LOADING) {
                    binding.progressBar.isVisible = true
                } else if (this.status == Status.SUCCESS) {
                    binding.progressBar.isVisible = false
                }
            }
        })

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.fsqEvent.collect { event ->
                when (event) {
                    is MainViewModel.MainEvent.NavigateToPlacesFragment -> {
                        Log.d(TAG, "fsqEvent: NavigateToPlacesFragment : ${event}")
                        requireActivity().supportFragmentManager.commit {
                            replace(R.id.fragment_container_view, PlacesFragment.newInstance(searchQuery?:".."))
                            addToBackStack("mainFragment")
                        }
                    }
                }

            }
        }
    }

    private fun handleKeyEvent(view: View, keyCode:Int):Boolean {
        searchQuery = (view as TextInputEditText).text.toString()
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE)  as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false

    }

}