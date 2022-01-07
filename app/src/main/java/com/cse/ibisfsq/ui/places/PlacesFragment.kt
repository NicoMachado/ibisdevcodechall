package com.cse.ibisfsq.ui.places

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cse.ibisfsq.R
import com.cse.ibisfsq.Status
import com.cse.ibisfsq.databinding.FragmentPlacesBinding
import com.cse.ibisfsq.ui.adapters.ResultAdapter
import com.cse.ibisfsq.ui.main.MainViewModel

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_QUERY = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PlacesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlacesFragment : Fragment(R.layout.fragment_places) {
    private var query: String? = null


    private lateinit var binding: FragmentPlacesBinding
    private val viewModel: MainViewModel by viewModels({requireActivity()})
    private lateinit var resultAdapter : ResultAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            query = it.getString(ARG_QUERY)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPlacesBinding.bind(view)

        binding.tvTextParm.text = "Looking for " + viewModel.q

        setupRecyclerView()

        viewModel.responseLiveData.observe(viewLifecycleOwner, {
            Log.d(TAG, "responseLiveData: ")
            it?.apply {
                Log.d(TAG, "responseLiveData : ${this.status}")
                if (this.status == Status.SUCCESS) {
                    resultAdapter.results = this.data!!
                    binding.mainLocationsEmptyText.isVisible = false
                    if (this.data == null || this.data.isEmpty()) {
                        binding.mainLocationsEmptyText.isVisible = true
                        binding.rvResults.isVisible = false
                    } else {
                        binding.mainLocationsEmptyText.isVisible = false
                        binding.rvResults.isVisible = true
                    }
                }
            }
        })
    }

    private fun setupRecyclerView() = binding.rvResults.apply {
        resultAdapter   = ResultAdapter()
        adapter = resultAdapter
        layoutManager   = LinearLayoutManager(this@PlacesFragment.context)
    }

    companion object {
        private const val TAG = "PlacesFragment"
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment PlacesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            PlacesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_QUERY, param1)
                }
            }
    }
}