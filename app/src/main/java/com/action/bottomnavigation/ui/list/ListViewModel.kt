package com.action.bottomnavigation.ui.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.action.bottomnavigation.data.ApiDetails
import com.action.bottomnavigation.data.model.CocktailModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val _apiDetails:ApiDetails): ViewModel() {

    private val _cockTail: MutableLiveData<CocktailModel> = MutableLiveData()
    val cockTail: LiveData<CocktailModel> = _cockTail

    fun getCockTailByFirstLetter() {
        viewModelScope.launch {
            try {
                val result = _apiDetails.getCockTailByFirstLetter(firstLetter = "c")
                if (result.drinks.isNullOrEmpty()) {
                    Log.d("API Error", "getCockTailByFirstLetter: Cocktail data is empty")
                } else {
                    _cockTail.postValue(result)
                }
            } catch (e: Exception) {
                Log.e("API Error", "Failed to fetch data: ${e.message}")
            }
        }
    }
}


    
