package com.example.artmuseumapp.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import com.example.artmuseumapp.MainActivity
import com.example.artmuseumapp.R
import com.example.artmuseumapp.databinding.FragmentArtDetailsBinding
import com.example.artmuseumapp.databinding.FragmentInitialBinding
import com.example.artmuseumapp.model.Artworks
import com.example.artmuseumapp.viewmodel.ArtLoadingState
import com.example.artmuseumapp.viewmodel.ArtViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ArtDetailsFragment : Fragment() {

    private val viewModel: ArtViewModel by sharedViewModel()

    private val binding by lazy {
        FragmentArtDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        viewModel.fragmentDetail
            .observe(viewLifecycleOwner) { set ->
                binding.ArtTitle.text = set?.title
                //binding.ArtDescription.text = set.description.toString()

                var description = set?.description ?: ""
                binding.ArtDescription.text = description.toString()

                Picasso.get()
                    .load(set?.images?.get(0)?.baseimageurl)
                    .resize(1000, 1000)
                    .into(binding.ArtImage)
                        }

        return binding.root
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            InitialFragment()
    }
}