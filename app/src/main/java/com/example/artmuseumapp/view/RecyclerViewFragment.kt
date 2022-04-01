package com.example.artmuseumapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.artmuseumapp.R
import com.example.artmuseumapp.databinding.FragmentInitialBinding
import com.example.artmuseumapp.databinding.FragmentRecyclerViewBinding

class RecyclerViewFragment : Fragment() {

    private val binding by lazy {
        FragmentRecyclerViewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            InitialFragment()
    }
}
