package com.example.cleanarqformat.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.cleanarqformat.R
import com.example.cleanarqformat.databinding.FragmentDetailBinding
import com.example.cleanarqformat.domain.model.ModelProduct
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    private val viewModel by viewModels<DetailViewModel>()
    private var bundle: ModelProduct = ModelProduct()
    private var newUrl: String = ""
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        if (arguments != null) {
            bundle = requireArguments().getParcelable("Product")!!
            val url = bundle.thumbnail
            val stringBuilder = StringBuilder(url)
            newUrl = stringBuilder.insert(4, "s").toString()
            val navigation = parentFragment?.findNavController()
            binding.backActionFragment.setOnClickListener {

                navigation?.navigate(R.id.action_detailFragment_to_navigation_dashboard2)
            }
            setupUi(_binding!!, bundle, newUrl)
        }

        return root
    }

    private fun setupUi(binding: FragmentDetailBinding, bundle: ModelProduct, newUrl: String) {
        Picasso.get().load(newUrl).into(binding.productImageView)
        with(binding) {
            descriptionDetail.text = bundle.itemName
            tituloDetail.text = bundle.title
            priceDetail.text = bundle.price

        }

    }


}