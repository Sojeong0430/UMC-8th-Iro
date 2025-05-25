package umc.UMC8thSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.UMC8thSpring.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
