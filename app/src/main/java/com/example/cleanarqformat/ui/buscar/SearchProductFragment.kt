package com.example.cleanarqformat.ui.buscar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarqformat.databinding.FragmentSearchBinding
import com.example.cleanarqformat.domain.model.ModelProduct
import com.example.cleanarqformat.ui.states.AppStates
import com.example.moviesdb2022newapp.adapters.SearchViewAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchProductFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val searchProductViewModel by viewModels<SearchProductViewModel>()
    private var productList: List<ModelProduct> = listOf()
    private lateinit var searchAdapter: SearchViewAdapter
    private lateinit var userQuery: String


    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root
        initRecyclerview()
        binding.productSearchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                loadData(query)

                return false;
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    userQuery = newText
                    loadData(newText)
                }

                return false
            }

        })

        return root
    }

    private fun loadData(query: String?) {
        binding.progressBar.visibility = View.GONE
        if (query != null) {
            val list = searchProductViewModel.getProductSearchByQuery(query)

            lifecycleScope.launch {
                searchProductViewModel.states.collect {
                    when (it) {
                        is AppStates.Error -> errorState()
                        AppStates.Loading -> loadingState()
                        is AppStates.Success -> {
                            binding.progressBar.visibility = View.GONE
                            searchAdapter.updateList(list)
                        }
                    }
                }
            }

        }

    }

    private fun errorState() {
        Toast.makeText(context, "Ha ocurrido un Error", Toast.LENGTH_LONG).show()
    }

    private fun loadingState() {
        binding.progressBar.visibility = View.VISIBLE
    }


    private fun initRecyclerview() {
        val recyclerView = binding.productRecyclerview
        searchAdapter = SearchViewAdapter(productList)
        recyclerView.adapter = searchAdapter
        val manager = LinearLayoutManager(context)
        recyclerView.layoutManager = manager
        binding.productRecyclerview.setHasFixedSize(true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}