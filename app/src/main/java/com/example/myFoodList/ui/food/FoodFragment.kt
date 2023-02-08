package com.example.myFoodList.ui.food

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.findNavController
//import com.MyFoodList2.Ewak4Day2.ui.food.FoodFragmentDirections
import com.example.weak4day2.*
import com.example.weak4day2.databinding.FragmentFoodBinding
import com.example.MyFoodList2.model.MySharedPref

class FoodFragment : Fragment(R.layout.fragment_food) {

    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFoodBinding.bind(view)


        val strings = listOf("foodADD1","foodADD2","foodADD3","foodADD4")
        val namesList = mutableListOf(

            Foods("Burger",
                R.drawable.fast_food_png_most_popular_fast_food_snacks_in_your_area_and_most__3
            ),
            Foods("Pitza",
                R.drawable.fast_food_png_most_popular_fast_food_snacks_in_your_area_and_most__3
            ),
            Foods("Juce",
                R.drawable.fast_food_png_most_popular_fast_food_snacks_in_your_area_and_most__3
            ),
            Foods("Burger",
                R.drawable.fast_food_png_most_popular_fast_food_snacks_in_your_area_and_most__3
            ),
            Foods("Pitza",
                R.drawable.fast_food_png_most_popular_fast_food_snacks_in_your_area_and_most__3
            ),
            Foods("Juce",
                R.drawable.fast_food_png_most_popular_fast_food_snacks_in_your_area_and_most__3
            ),
            Foods("Burger",
                R.drawable.fast_food_png_most_popular_fast_food_snacks_in_your_area_and_most__3
            ),
            Foods("Pitza",
                R.drawable.fast_food_png_most_popular_fast_food_snacks_in_your_area_and_most__3
            ),
            Foods("Juce",
                R.drawable.fast_food_png_most_popular_fast_food_snacks_in_your_area_and_most__3
            ),

        )
        val adapter= FoodsAdapter(MySharedPref(requireContext())){
            val action =
                FoodFragmentDirections.actionFoodFragmentToFoodDetailsFragment(it.name, it.imageUrl)
            view.findNavController().navigate(action)
        }
        binding.tvFoods.adapter = adapter
        adapter.submitList(namesList)

        binding.apply {



        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}