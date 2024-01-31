package com.example.cleanarqformat.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarqformat.databinding.FragmentSearchBinding
import com.example.cleanarqformat.domain.model.ModelProduct
import com.example.moviesdb2022newapp.adapters.SearchViewAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchProductFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val searchProductViewModel by viewModels<SearchProductViewModel>()
    private var productList: List<ModelProduct> = listOf()
    private var filteredList: ArrayList<String> = arrayListOf()
    private lateinit var searchAdapter: SearchViewAdapter
    private lateinit var userQuery: String

    // This property is only valid between onCreateView and
    // onDestroyView.
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
//                if (query != null) {
//                    userQuery = query
//                    loadData(query)
//                }

                return false;
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (productList.size >= 0) {
                    if (newText != null) {
                        userQuery = newText
                        loadData(newText)
                    }
                }
                return false
            }

        })
//        lifecycleScope.launch {
//            searchProductViewModel.states.collect { appStates ->
//                when (appStates) {
//                    is AppStates.Error -> Toast.makeText(
//                        context,
//                        "Something happened",
//                        Toast.LENGTH_LONG
//                    ).show()
//
//                    AppStates.Loading -> loadingState()
//                    is AppStates.Success -> loadData(userQuery)
//                }
//
//            }
//        }
        return root
    }

    private fun loadData(query: String?) {
        binding.progressBar.visibility = View.GONE
        if (query != null) {
//            lifecycleScope.launch {
//                searchProductViewModel.queryModelList.collect{
//                    searchProductViewModel.getProductSearchByQuery(query)
//                    searchAdapter.updateList(it)
//                    productList = it
//                }
//            }
            productList = searchProductViewModel.getProductSearchByQuery(query)
            searchAdapter?.updateList(productList)
        }

    }

    private fun loadingState() {
       // binding.progressBar.visibility = View.VISIBLE
    }

    private fun filtering(text: String) {
//            for (item in productList) {
//                for (attribute in item.itemName) {
//                    if (attribute.item.lowercase()
//                            .contains(text.lowercase(Locale.getDefault()))
//                    ) {
//                        filteredList.add(attribute.value_name)
//                    }
//                }
//
//        }

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