package com.ntg.firstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ntg.firstapp.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private var movieAdapter = MovieAdapter(null)

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPrevious.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        movieAdapter = MovieAdapter(getMovieList())
        binding.rvMovieList.adapter = movieAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getMovieList(): ArrayList<Movie>{
        return arrayListOf<Movie>(
            Movie(1 , "Movie1"),
            Movie(2 , "Movie2"),
            Movie(3 , "Movie3"),
            Movie(4 , "Movie4"),
            Movie(5 , "Movie5"),
            Movie(6 , "Movie6"),
            Movie(7 , "Movie7"),
            Movie(8 , "Movie8"),
            Movie(9 , "Movie9"),
            Movie(10 , "Movie10"),
            Movie(1 , "Movie1"),
            Movie(2 , "Movie2"),
            Movie(3 , "Movie3"),
            Movie(4 , "Movie4"),
            Movie(5 , "Movie5"),
            Movie(6 , "Movie6"),
            Movie(7 , "Movie7"),
            Movie(8 , "Movie8"),
            Movie(9 , "Movie9"),
            Movie(10 , "Movie10"),
            Movie(5 , "Movie5"),
            Movie(6 , "Movie6"),
            Movie(7 , "Movie7"),
            Movie(8 , "Movie8"),
            Movie(9 , "Movie9"),
            Movie(10 , "Movie10"),
        )
    }
}