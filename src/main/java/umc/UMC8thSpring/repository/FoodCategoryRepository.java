package umc.UMC8thSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.UMC8thSpring.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
