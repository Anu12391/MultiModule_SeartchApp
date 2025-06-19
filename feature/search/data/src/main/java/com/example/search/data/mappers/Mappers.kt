package com.example.search.data.mappers

import com.example.search.data.model.RecipesDTO
import com.example.search.data.model.RecipesDetailsDTO
import com.example.search.domain.model.Recipes
import com.example.search.domain.model.RecipesDetails

fun List<RecipesDTO>.toDomain():List<Recipes>{
   return map{Recipes(
        strCategory=it.strCategory,
        strMealAlternate=it.strMealAlternate,
        strArea=it.strArea,
        strCreativeCommonsConfirmed=it.strCreativeCommonsConfirmed,
        strIngredient19=it.strIngredient19,
        strTags=it.strTags,
        idMeal=it.idMeal,
        strInstructions=it.strInstructions,
        strMealThumb=it.strMealThumb,
        strYoutube=it.strYoutube,
        strMeal=it.strMeal,
        dateModified=it.dateModified,
        strSource=it.strSource,
        ingredientPair=it.getIngredientsWithItsMeasure())
    }
}
fun List<RecipesDetailsDTO>.toDomain():List<RecipesDetails>{
     return map{RecipesDetails(
          strIngredient10=it.strIngredient10,
          strIngredient12=it.strIngredient12,
          strIngredient11=it.strIngredient11,
          strIngredient14=it.strIngredient14,
          strCategory=it.strCategory,
          strIngredient13=it.strIngredient13,
          strIngredient16=it.strIngredient16,
          strIngredient15=it.strIngredient15,
          strMealAlternate=it.strMealAlternate,
          strIngredient18=it.strIngredient18,
          strIngredient17=it.strIngredient17,
          strArea=it.strArea,
          strCreativeCommonsConfirmed=it.strCreativeCommonsConfirmed,
          strIngredient19=it.strIngredient19,
          strTags=it.strTags,
          idMeal=it.idMeal,
          strInstructions=it.strInstructions,
          strIngredient1=it.strIngredient1,
          strIngredient3=it.strIngredient3,
          strIngredient2=it.strIngredient2,
          strIngredient20=it.strIngredient20,
          strIngredient5=it.strIngredient5,
          strIngredient4=it.strIngredient4,
          strIngredient7=it.strIngredient7,
          strIngredient6=it.strIngredient6,
          strIngredient9=it.strIngredient8,
          strIngredient8=it.strIngredient8,
          strMealThumb=it.strMealThumb,
          strMeasure20=it.strMeasure20,
          strYoutube=it.strYoutube,
          strMeal=it.strMeal,
          strMeasure12=it.strMeasure12,
          strMeasure13=it.strMeasure13,
          strMeasure10=it.strMeasure10,
          strMeasure11=it.strMeasure11,
          dateModified=it.dateModified,
          strSource=it.strSource,
          strMeasure9=it.strMeasure9,
          strMeasure7=it.strMeasure7,
          strMeasure8=it.strMeasure8,
          strMeasure5=it.strMeasure5,
          strMeasure6=it.strMeasure6,
          strMeasure3=it.strMeasure3,
          strMeasure4=it.strMeasure4,
          strMeasure1=it.strMeasure1,
          strMeasure18=it.strMeasure18,
          strMeasure2=it.strMeasure2,
          strMeasure19=it.strMeasure19,
          strMeasure16=it.strMeasure16,
          strMeasure17=it.strMeasure17,
          strMeasure14=it.strMeasure14,
          strMeasure15=it.strMeasure15)
     }



}

fun RecipesDTO.getIngredientsWithItsMeasure():List<Pair<String,String>> {
     val list= mutableListOf<Pair<String,String>>()
     list.add(Pair(strIngredient1.getOrEmpty(),strMeasure1.getOrEmpty()))
     list.add(Pair(strIngredient2.getOrEmpty(),strMeasure2.toString()))
     list.add(Pair(strIngredient3.getOrEmpty(),strMeasure3.getOrEmpty()))
     list.add(Pair(strIngredient4.getOrEmpty(),strMeasure4.getOrEmpty()))
     list.add(Pair(strIngredient5.getOrEmpty(),strMeasure5.getOrEmpty()))
     list.add(Pair(strIngredient6.getOrEmpty(),strMeasure6.getOrEmpty()))
     list.add(Pair(strIngredient7.getOrEmpty(),strMeasure7.getOrEmpty()))
     list.add(Pair(strIngredient8.getOrEmpty(),strMeasure8.getOrEmpty()))
     list.add(Pair(strIngredient9.getOrEmpty(),strMeasure9.getOrEmpty()))
     list.add(Pair(strIngredient10.getOrEmpty(),strMeasure10.getOrEmpty()))
     list.add(Pair(strIngredient11.getOrEmpty(),strMeasure11.getOrEmpty()))
     list.add(Pair(strIngredient12.getOrEmpty(),strMeasure12.getOrEmpty()))
     list.add(Pair(strIngredient13.getOrEmpty(),strMeasure13.getOrEmpty()))
     list.add(Pair(strIngredient14.getOrEmpty(),strMeasure14.getOrEmpty()))
     list.add(Pair(strIngredient15.getOrEmpty(),strMeasure15.getOrEmpty()))
     list.add(Pair(strIngredient16.getOrEmpty(),strMeasure16.getOrEmpty()))
     list.add(Pair(strIngredient17.getOrEmpty(),strMeasure17.getOrEmpty()))
     list.add(Pair(strIngredient18.getOrEmpty(),strMeasure18.getOrEmpty()))
     list.add(Pair(strIngredient19.getOrEmpty(),strMeasure19.getOrEmpty()))
     return list

}

fun String?.getOrEmpty()=this?.ifEmpty { "" }?:""