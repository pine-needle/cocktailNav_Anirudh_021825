package com.action.bottomnavigation.ui.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.action.bottomnavigation.data.model.CocktailModel
import com.action.bottomnavigation.databinding.FragmentListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {


        private var _binding: FragmentListBinding? = null
        private val binding get() = _binding!!

        private val listViewModel: ListViewModel by viewModels()

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            _binding = FragmentListBinding.inflate(inflater, container, false)

            // Fetch cocktail data on fragment creation
            listViewModel.getCockTailByFirstLetter()

            // Observe API response
            listViewModel.cockTail.observe(viewLifecycleOwner) { cocktailModel ->
                if (!cocktailModel.drinks.isNullOrEmpty()) {
                    setupUI(cocktailModel)
                } else {
                    Log.d("RecyclerView", "No cocktails found, not updating UI")
                }
            }

            return binding.root
        }

        private fun setupUI(cocktailModel: CocktailModel) {
            binding.rvcocktail.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = ListAdapter(cocktailModel?.drinks ?: emptyList())
            }
        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }

}