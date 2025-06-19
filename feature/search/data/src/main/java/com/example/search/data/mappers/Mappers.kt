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
        strSource=it.strSource)
    }
}
fun RecipesDetailsDTO.toDomain():RecipesDetails{
     return RecipesDetails(
          strIngredient10=strIngredient10,
          strIngredient12=strIngredient12,
          strIngredient11=strIngredient11,
          strIngredient14=strIngredient14,
          strCategory=strCategory,
          strIngredient13=strIngredient13,
          strIngredient16=strIngredient16,
          strIngredient15=strIngredient15,
          strMealAlternate=strMealAlternate,
          strIngredient18=strIngredient18,
          strIngredient17=strIngredient17,
          strArea=strArea,
          strCreativeCommonsConfirmed=strCreativeCommonsConfirmed,
          strIngredient19=strIngredient19,
          strTags=strTags,
          idMeal=idMeal,
          strInstructions=strInstructions,
          strIngredient1=strIngredient1,
          strIngredient3=strIngredient3,
          strIngredient2=strIngredient2,
          strIngredient20=strIngredient20,
          strIngredient5=strIngredient5,
          strIngredient4=strIngredient4,
          strIngredient7=strIngredient7,
          strIngredient6=strIngredient6,
          strIngredient9=strIngredient8,
          strIngredient8=strIngredient8,
          strMealThumb=strMealThumb,
          strMeasure20=strMeasure20,
          strYoutube=strYoutube,
          strMeal=strMeal,
          strMeasure12=strMeasure12,
          strMeasure13=strMeasure13,
          strMeasure10=strMeasure10,
          strMeasure11=strMeasure11,
          dateModified=dateModified,
          strSource=strSource,
          strMeasure9=strMeasure9,
          strMeasure7=strMeasure7,
          strMeasure8=strMeasure8,
          strMeasure5=strMeasure5,
          strMeasure6=strMeasure6,
          strMeasure3=strMeasure3,
          strMeasure4=strMeasure4,
          strMeasure1=strMeasure1,
          strMeasure18=strMeasure18,
          strMeasure2=strMeasure2,
          strMeasure19=strMeasure19,
          strMeasure16=strMeasure16,
          strMeasure17=strMeasure17,
          strMeasure14=strMeasure14,
          strMeasure15=strMeasure15)




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