package umc.UMC8thSpring.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.UMC8thSpring.domain.Store;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
    Optional<Store> findById(Long id);
}
