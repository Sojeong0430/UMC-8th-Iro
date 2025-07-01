package umc.UMC8thSpring.service.MemberService;

import umc.UMC8thSpring.domain.Member;
import umc.UMC8thSpring.web.dto.MemberRequestDTO;
import umc.UMC8thSpring.web.dto.MemberResponseDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
    MemberResponseDTO.LoginResultDTO loginMember(MemberRequestDTO.LoginRequestDTO request);
}
