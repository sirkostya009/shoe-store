package ua.sirkostya009.shoeservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.sirkostya009.shoeservice.dao.Review;
import ua.sirkostya009.shoeservice.dao.Shoe;
import ua.sirkostya009.shoeservice.dto.ReviewPostDto;
import ua.sirkostya009.shoeservice.exception.NotFoundException;
import ua.sirkostya009.shoeservice.repository.ReviewRepository;
import ua.sirkostya009.shoeservice.repository.ShoeRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShoeServiceImpl implements ShoeService {
    private final ShoeRepository shoeRepository;
    private final ReviewRepository reviewRepository;

    @Value("${shoes-per-page:20}")
    private int shoesPerPage;

    @Override
    public Page<Shoe> findAll(int page) {
        return shoeRepository.findAllPopular(pageRequest(page));
    }

    @Override
    public Shoe findById(UUID id) {
        return shoeRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Page<Review> findAllReviews(UUID id, int page) {
        return shoeRepository.findAllReviewsOf(id, pageRequest(page));
    }

    @Override
    @Transactional
    public Review addReview(UUID id, String uid, String username, ReviewPostDto dto) {
        var shoe = findById(id);

        var review = reviewRepository.save(Review.builder()
                        .shoe(shoe)
                        .text(dto.text())
                        .authorId(uid)
                        .authorName(username)
                        .rating(dto.rating())
                        .build());

        // Reevaluating new rating score for the shoe
        var totalReviewScore = shoeRepository.sumRatings(id);
        var totalReviews = shoeRepository.countRatings(id);
        shoe.setRating((double) totalReviewScore / totalReviews);

        return review;
    }

    private PageRequest pageRequest(int page) {
        return PageRequest.of(page, shoesPerPage);
    }
}
