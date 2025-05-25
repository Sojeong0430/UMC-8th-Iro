package umc.UMC8thSpring.repository.MemberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.UMC8thSpring.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findById(long id);
}
