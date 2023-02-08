package com.example.weak4day2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.weak4day2.databinding.FragmentFoodBinding

class FoodFragment : Fragment(R.layout.fragment_food) {

    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFoodBinding.bind(view)


        val strings = listOf("foodADD1","foodADD2","foodADD3","foodADD4")
        val namesList = mutableListOf(

            Foods("Food1",R.drawable.baseline_fastfood_24),
            Foods("Food2",R.drawable.baseline_emoji_food_beverage_24),
            Foods("Food3",R.drawable.baseline_fastfood_24),
            Foods("Food4",R.drawable.baseline_emoji_food_beverage_24),
            Foods("Food5",R.drawable.baseline_fastfood_24),
            Foods("Food6",R.drawable.baseline_emoji_food_beverage_24),
            Foods("Food7",R.drawable.baseline_fastfood_24),
            Foods("Food8",R.drawable.baseline_emoji_food_beverage_24),
            Foods("Food9",R.drawable.baseline_fastfood_24),

        )
        val adapter= FoodsAdapter(MySharedPref(requireContext())){
            val action = FoodFragmentDirections.actionFoodFragmentToFoodDetailsFragment(it.name,it.imageUrl)
            view.findNavController().navigate(action)
        }
        binding.tvFoods.adapter = adapter
        adapter.submitList(namesList)

        binding.apply {

            binding.ADD.setOnClickListener {

                namesList.add(1,Foods(strings.random(),R.drawable.baseline_food_bank_24))

                adapter.notifyItemInserted(1)
            }


            binding.Remove.setOnClickListener {
                namesList.removeAt(1)
                adapter.notifyItemRemoved(1)
            }
            //Remove By Index
            binding.positionButton.setOnClickListener {
                val x = binding.positionText.text.toString()
                namesList.removeAt(x.toInt())
                adapter.notifyItemRemoved(x.toInt())
            }



        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}