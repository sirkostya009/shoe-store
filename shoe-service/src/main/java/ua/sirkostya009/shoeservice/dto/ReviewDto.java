package ua.sirkostya009.shoeservice.dto;

import ua.sirkostya009.shoeservice.dao.Review;

public record ReviewDto(
        String id,
        Integer rating,
        String author,
        String text
) {
    public static ReviewDto of(Review review) {
        return new ReviewDto(
                review.getId().toString(),
                review.getRating(),
                review.getAuthorName(),
                review.getText()
        );
    }
}
