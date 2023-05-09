package ua.sirkostya009.shoeservice.dto;

import ua.sirkostya009.shoeservice.dao.Shoe;

public record ShortShoeDto(
        String id,
        String name,
        Double rating,
        String previewImage,
        int price
) {
    public static ShortShoeDto of(Shoe shoe) {
        return new ShortShoeDto(
                shoe.getId().toString(),
                shoe.getName(),
                shoe.getRating(),
                shoe.getImageFileName(),
                shoe.getPrice()
        );
    }
}
