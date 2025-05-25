package umc.UMC8thSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.UMC8thSpring.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
}
