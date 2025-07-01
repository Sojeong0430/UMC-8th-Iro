package umc.UMC8thSpring.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import umc.UMC8thSpring.web.dto.MemberResponseDTO;

public interface MemberQueryService {
    MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request);
}
