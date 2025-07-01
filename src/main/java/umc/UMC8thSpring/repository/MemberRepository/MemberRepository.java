package umc.UMC8thSpring.repository.MemberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.UMC8thSpring.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findById(long id);

    Optional<Member> findByEmail (String email);
}
