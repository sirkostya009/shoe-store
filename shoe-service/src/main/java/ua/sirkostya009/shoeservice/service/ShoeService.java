package ua.sirkostya009.shoeservice.service;

import org.springframework.data.domain.Page;
import ua.sirkostya009.shoeservice.dao.Review;
import ua.sirkostya009.shoeservice.dao.Shoe;
import ua.sirkostya009.shoeservice.dto.ReviewPostDto;

import java.util.UUID;

public interface ShoeService {
    Page<Shoe> findAll(int page);

    Shoe findById(UUID id);

    Page<Review> findAllReviews(UUID id, int page);

    Review addReview(UUID id, String uid, String username, ReviewPostDto dto);
}
