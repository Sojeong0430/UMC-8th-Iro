package umc.UMC8thSpring.service.StoreService;

import org.springframework.data.domain.Page;
import umc.UMC8thSpring.domain.Review;
import umc.UMC8thSpring.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
    Page<Review> getReviewList(Long StoreId, Integer page);
}
