package umc.UMC8thSpring.service.MemberService;

import umc.UMC8thSpring.domain.Member;
import umc.UMC8thSpring.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
