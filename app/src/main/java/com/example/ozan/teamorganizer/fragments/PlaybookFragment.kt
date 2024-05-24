package com.example.yourapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ozan.teamorganizer.databinding.FragmentPlaybookBinding
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

class PlaybookFragment : Fragment() {

    private var _binding: FragmentPlaybookBinding? = null
    private val binding get() = _binding!!

    private val imageUrls = listOf(
        "p1",
        "p2",
        "p3",
        "p4",
        "p5"
    )
    private var currentIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlaybookBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val picasso = Picasso.Builder(requireContext())
            .downloader(OkHttp3Downloader(requireContext(), Long.MAX_VALUE))
            .build()

        loadImage(picasso)

        binding.previousButton.setOnClickListener {
            currentIndex = if (currentIndex > 0) currentIndex - 1 else imageUrls.size - 1
            loadImage(picasso)
        }

        binding.nextButton.setOnClickListener {
            currentIndex = if (currentIndex < imageUrls.size - 1) currentIndex + 1 else 0
            loadImage(picasso)
        }
    }

    private fun loadImage(picasso: Picasso) {
        picasso.load(getImageResourceId(imageUrls[currentIndex]))
            .into(binding.playbookImageView)
    }

    private fun getImageResourceId(imageName: String): Int {
        return resources.getIdentifier(imageName, "drawable", requireContext().packageName)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
