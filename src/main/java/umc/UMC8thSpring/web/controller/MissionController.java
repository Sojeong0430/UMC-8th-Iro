package umc.UMC8thSpring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.UMC8thSpring.apiPayload.ApiResponse;
import umc.UMC8thSpring.service.MissionService.MissionService;
import umc.UMC8thSpring.validation.annotation.CheckMissionNotInProgress;

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
}
