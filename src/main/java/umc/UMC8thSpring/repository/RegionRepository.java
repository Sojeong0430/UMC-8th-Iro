package umc.UMC8thSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.UMC8thSpring.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
