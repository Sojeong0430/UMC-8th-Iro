package umc.UMC8thSpring.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import umc.UMC8thSpring.domain.Member;
import umc.UMC8thSpring.repository.MemberRepository.MemberRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(username) // 1. 사용자 조회
                .orElseThrow(() -> new UsernameNotFoundException("해당 이메일을 가진 유저가 존재하지 않습니다."));

        return org.springframework.security.core.userdetails.User // 2. User 객체로 변환하여 반환
                .withUsername(member.getEmail())
                .password(member.getPassword())
                .roles(member.getRole().name())
                .build();
    }
}
