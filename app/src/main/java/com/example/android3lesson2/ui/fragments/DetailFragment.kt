package com.example.android3lesson2.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android3homework2mc5.models.Photo
import com.example.android3lesson2.utils.loadImage
import com.example.android3lesson2.R
import com.example.android3lesson2.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val photo = arguments?.getParcelable<Photo>("selectedPhoto")
        photo?.let {
            binding.tvNameDetail.text = it.title
            binding.ivImageDetail.contentDescription =  binding.root.context.getString(R.string.photo, photo.title)
            val imageUrl = "https://farm66.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}.jpg"
            binding.ivImageDetail.loadImage(imageUrl)
        }
        arroeBack()
    }

    private fun arroeBack() {
        binding.ivArrowDetail.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}