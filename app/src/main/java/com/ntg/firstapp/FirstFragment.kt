package com.ntg.firstapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ntg.firstapp.databinding.FragmentFirstBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val baseUrl = "https://jsonplaceholder.typicode.com/"

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnOk.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            val apiService = retrofit.create(ApiService::class.java)

        val call: Call<Post> = apiService.getPost()

        val call2 = apiService.savePost(Post(1, 2, "post1" , " Hello"))

        // Get Call

        call.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful)
                    binding.txtLorem.text = response.body()?.title
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                binding.txtLorem.text = t.message
            }

        })
        // Post Call
        call2.enqueue(object : Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                Log.d("###retrofit: ", "successfully post")
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.d("###retrofit: ", "fail post")
            }

        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}