package umc.UMC8thSpring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.UMC8thSpring.apiPayload.ApiResponse;
import umc.UMC8thSpring.converter.MissionConverter;
import umc.UMC8thSpring.domain.Mission;
import umc.UMC8thSpring.service.MissionService.MissionService;
import umc.UMC8thSpring.validation.annotation.CheckMissionNotInProgress;
import umc.UMC8thSpring.validation.annotation.ValidatePage;
import umc.UMC8thSpring.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;

    @Operation(summary = "도전 중인 미션 추가 API", description = "도전 중인 미션을 추가합니다.")
    @PostMapping("/starting")
    public ApiResponse<String> createMemberMission (@RequestParam @CheckMissionNotInProgress Long missionId){
        return ApiResponse.onSuccess("미션 추가가 완료되었습니다");
    }

    @Operation(summary = "특정 가게의 미션 조회 API", description = "특정 가게의 미션을 조회합니다.")
    @GetMapping("/store")
    public ApiResponse<MissionResponseDTO.missionPreviewListDto> getStoreMission (@RequestParam(name="store_id") Long storeId,
                                                                                  @RequestParam(name="page") @ValidatePage Integer page){
        Page<Mission> missionList = missionService.getMissionList(page);
        return ApiResponse.onSuccess(MissionConverter.toMissionPreViewListDTO(missionList));
    }
}
