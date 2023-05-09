package ua.sirkostya009.shoeservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.sirkostya009.shoeservice.dao.Review;
import ua.sirkostya009.shoeservice.dao.Shoe;

import java.util.List;
import java.util.UUID;

public interface ShoeRepository extends JpaRepository<Shoe, UUID> {
    @Query("select s from Shoe s order by s.rating desc")
    Page<Shoe> findAllPopular(Pageable pageable);

    @Query("select r from Review r where r.shoe.id = :id")
    Page<Review> findAllReviewsOf(UUID id,
                                  Pageable pageable);

    @Query("select r.rating from Review r where r.shoe.id = :id")
    List<Integer> getReviewRatings(UUID id);

    @Query("select sum(r.rating) from Review r where r.shoe.id = :id")
    int sumRatings(UUID id);

    @Query("select count(r.rating) from Review r where r.shoe.id = :id")
    int countRatings(UUID id);
}
