package umc.demo.converter;

import lombok.extern.java.Log;
import umc.demo.domain.Food;
import umc.demo.domain.Likefood;

import java.util.List;
import java.util.stream.Collectors;

public class LikeFoodConverter {

    public static List<Likefood> toLikefoodList(List<Food> foodCategoryList){

        return foodCategoryList.stream()
                .map(category_number ->
                        Likefood.builder()
                            .category_number(category_number)
                            .build()
                ).collect(Collectors.toList());
    }



}
