package umc.UMC8thSpring.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.UMC8thSpring.apiPayload.code.status.ErrorStatus;
import umc.UMC8thSpring.apiPayload.exception.handler.TempHandler;
import umc.UMC8thSpring.config.security.jwt.JwtTokenProvider;
import umc.UMC8thSpring.converter.MemberConverter;
import umc.UMC8thSpring.domain.Member;
import umc.UMC8thSpring.repository.MemberRepository.MemberRepository;
import umc.UMC8thSpring.web.dto.MemberResponseDTO;

@Service
@RequiredArgsConstructor
public class MemberQueryServicelmpl implements MemberQueryService {

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional(readOnly = true)
    public MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request) {
        Authentication authentication = jwtTokenProvider.extractAuthentication(request);
        String email = authentication.getName();

        Member member = memberRepository.findByEmail(email)

                .orElseThrow(()-> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));
        return MemberConverter.toMemberInfoDTO(member);
    }
}
