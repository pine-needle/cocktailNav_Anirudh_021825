package com.action.bottomnavigation.ui.Random

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.action.bottomnavigation.data.ApiDetails
import com.action.bottomnavigation.data.ApiReference
import com.action.bottomnavigation.data.model.DrinkModel
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomViewModel @Inject constructor(private val _apiDetails: ApiDetails) : ViewModel() {

    private val _randomCocktail = MutableLiveData<DrinkModel?>()
    val randomCocktail: MutableLiveData<DrinkModel?> get() = _randomCocktail

        fun getRandomCocktail() {
            viewModelScope.launch {
                val result = _apiDetails.getRandomCocktail()
                val drink = result.drinks.firstOrNull()

                if (result!= null) {
                    _randomCocktail.postValue(drink)
                } else {
                    Log.d("API Error", "getCocktailByFirstLetter: No valid drink found")
                }

            }
        }
    }


