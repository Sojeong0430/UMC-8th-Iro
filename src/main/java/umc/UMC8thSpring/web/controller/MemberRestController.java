package umc.UMC8thSpring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.UMC8thSpring.apiPayload.ApiResponse;
import umc.UMC8thSpring.converter.MemberConverter;
import umc.UMC8thSpring.converter.MissionConverter;
import umc.UMC8thSpring.domain.Member;
import umc.UMC8thSpring.domain.Mission;
import umc.UMC8thSpring.service.MemberService.MemberCommandService;
import umc.UMC8thSpring.service.MemberService.MemberQueryService;
import umc.UMC8thSpring.service.MissionService.MissionService;
import umc.UMC8thSpring.validation.annotation.ValidatePage;
import umc.UMC8thSpring.web.dto.MemberRequestDTO;
import umc.UMC8thSpring.web.dto.MemberResponseDTO;
import umc.UMC8thSpring.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MissionService missionService;
    private final MemberQueryService memberQueryService;

    @Operation(summary = "회원 가입", description = "회원 정보를 받아 회원가입을 처리합니다.")
    @PostMapping
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/login")
    @Operation(summary = "유저 로그인 API",description = "유저가 로그인하는 API입니다.")
    public ApiResponse<MemberResponseDTO.LoginResultDTO> login(@RequestBody @Valid MemberRequestDTO.LoginRequestDTO request) {
        return ApiResponse.onSuccess(memberCommandService.loginMember(request));
    }

    @Operation(summary = "내가 진행중인 미션 목록 API", description = "내가 진행중인 미션 목록을 조회합니다.")
    @GetMapping("/missions")
    public ApiResponse<MissionResponseDTO.missionPreviewListDto> getStoreMission (@RequestParam(name="page") @ValidatePage Integer page){
        Page<Mission> missionList = missionService.getMissionList(page);
        return ApiResponse.onSuccess(MissionConverter.toMissionPreViewListDTO(missionList));
    }

    @GetMapping("/info")
    @Operation(summary = "유저 내 정보 조회 API - 인증 필요",
            description = "유저가 내 정보를 조회하는 API입니다.",
            security = { @SecurityRequirement(name = "JWT TOKEN") }
    )
    public ApiResponse<MemberResponseDTO.MemberInfoDTO> getMyInfo(HttpServletRequest request) {
        return ApiResponse.onSuccess(memberQueryService.getMemberInfo(request));
    }

}