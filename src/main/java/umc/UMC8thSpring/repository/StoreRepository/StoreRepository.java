package umc.UMC8thSpring.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.UMC8thSpring.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}
