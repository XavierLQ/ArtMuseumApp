package com.example.artmuseumapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout.VERTICAL
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.artmuseumapp.R
import com.example.artmuseumapp.adapter.ArtAdapter
import com.example.artmuseumapp.adapter.ClickedArt
import com.example.artmuseumapp.databinding.FragmentInitialBinding
import com.example.artmuseumapp.databinding.FragmentRecyclerViewBinding
import com.example.artmuseumapp.model.Artworks
import com.example.artmuseumapp.viewmodel.ArtLoadingState
import com.example.artmuseumapp.viewmodel.ArtViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import retrofit2.Response


class RecyclerViewFragment : Fragment(), ClickedArt {

    private val binding by lazy {
        FragmentRecyclerViewBinding.inflate(layoutInflater)
    }
    private val Adapter by lazy{
        ArtAdapter(this)
    }

    private val viewModel:ArtViewModel by sharedViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.artRecycler.apply{
            layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
            adapter = Adapter
        }

        viewModel.getArtCollection()
        viewModel.artLiveData
            .observe(viewLifecycleOwner){
                state -> when(state) {
                is ArtLoadingState.LOADING ->{
                    Log.d("Loading Data...", state.toString())}

                is ArtLoadingState.SUCCESS<*> ->{
                    val receivedArt: Artworks? = state.response as? Artworks
                    if (receivedArt != null){
                        Adapter.updateArtList(receivedArt.records)
                    }
                }

                is ArtLoadingState.ERROR ->{
                    throw Exception("Error Loading the Data")
                }
            }
        }



        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onResume() {
        super.onResume()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            InitialFragment()
    }

    override fun OnClickedArt() {
        TODO("Not yet implemented")
    }
}
