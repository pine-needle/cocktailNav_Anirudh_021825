package com.action.bottomnavigation.data

import com.action.bottomnavigation.data.model.CocktailModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiDetails {

    @GET(ApiReference.END_POINT)
    suspend fun getCockTailByFirstLetter(
        @Query("f") firstLetter: String="c"
    ): CocktailModel


    @GET(ApiReference.END_POINT1)
    suspend fun getRandomCocktail(): CocktailModel
}