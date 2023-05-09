package ua.sirkostya009.shoeservice.dto;

import ua.sirkostya009.shoeservice.dao.Shoe;
import ua.sirkostya009.shoeservice.dao.ShoeSize;

import java.util.Set;
import java.util.TreeSet;

public record DetailedShoeDto(
        String id,
        String name,
        String description,
        Double rating,
        String color,
        String material,
        String country,
        Set<Integer> sizes,
        String previewImage,
        int price
) {
    public static DetailedShoeDto of(Shoe shoe) {
        return new DetailedShoeDto(
                shoe.getId().toString(),
                shoe.getName(),
                shoe.getDescription(),
                shoe.getRating(),
                shoe.getColor(),
                shoe.getMaterial(),
                shoe.getCountryManufacturer(),
                new TreeSet<>(shoe.getSizes().stream().map(ShoeSize::getSize).toList()),
                shoe.getImageFileName(),
                shoe.getPrice()
        );
    }
}
