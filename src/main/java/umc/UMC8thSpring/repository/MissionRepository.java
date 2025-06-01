package umc.UMC8thSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.UMC8thSpring.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
