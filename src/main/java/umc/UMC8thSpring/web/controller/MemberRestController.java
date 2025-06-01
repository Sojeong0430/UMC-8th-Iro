package umc.UMC8thSpring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "회원 가입", description = "회원 정보를 받아 회원가입을 처리합니다.")
    @PostMapping
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @Operation(summary = "내가 진행중인 미션 목록 API", description = "내가 진행중인 미션 목록을 조회합니다.")
    @GetMapping("/missions")
    public ApiResponse<MissionResponseDTO.missionPreviewListDto> getStoreMission (@RequestParam(name="page") @ValidatePage Integer page){
        Page<Mission> missionList = missionService.getMissionList(page);
        return ApiResponse.onSuccess(MissionConverter.toMissionPreViewListDTO(missionList));
    }

}