package com.action.bottomnavigation.data.model
import com.google.gson.annotations.SerializedName

data class DrinkModel(
    val dateModified: String,
    val idDrink: String,
    val strAlcoholic: String,
    val strCategory: String,
    val strCreativeCommonsConfirmed: String,
    val strDrink: String,
    val strDrinkAlternate: Any,
    val strDrinkThumb: String,
    val strGlass: String,
    val strIBA: String,
    val strImageAttribution: String,
    val strImageSource: String,
    val strIngredient1: String,
    val strIngredient2: String,
    val strIngredient3: String,
    val strIngredient4: String,
    val strIngredient5: String,
    val strIngredient6: String,
    val strIngredient7: Any,
    val strIngredient8: Any,
    val strIngredient9: Any,
    val strIngredient10: Any,
    val strIngredient11: Any,
    val strIngredient12: Any,
    val strIngredient13: Any,
    val strIngredient14: Any,
    val strIngredient15: Any,
    val strInstructions: String,
    val strInstructionsDE: String,
    val strInstructionsES: String,
    val strInstructionsFR: String,
    val strInstructionsIT: String,
    @SerializedName("strInstructionsZH-HANS")
    val strInstructionsZHHANS: Any,
    @SerializedName("strInstructionsZH-HANT")
    val strInstructionsZHHANT: Any,
    val strMeasure1: String,
    val strMeasure2: String,
    val strMeasure3: String,
    val strMeasure4: String,
    val strMeasure5: String,
    val strMeasure6: String,
    val strMeasure7: Any,
    val strMeasure8: Any,
    val strMeasure9: Any,
    val strMeasure10: Any,
    val strMeasure11: Any,
    val strMeasure12: Any,
    val strMeasure13: Any,
    val strMeasure14: Any,
    val strMeasure15: Any,
    val strTags: String,
    val strVideo: String
)

