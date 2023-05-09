package ua.sirkostya009.shoeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.sirkostya009.shoeservice.dao.Review;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review, UUID> {
}
