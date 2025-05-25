package umc.UMC8thSpring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.UMC8thSpring.apiPayload.ApiResponse;
import umc.UMC8thSpring.service.StoreService.StoreService;
import umc.UMC8thSpring.web.dto.StoreRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {

    private final StoreService storeService;

    @Operation(summary = "특정 지역 가게 추가 API", description = "가게를 추가합니다.")
    @PostMapping
    public ApiResponse<String> createMemberMission (@RequestParam StoreRequestDTO.storeAddDTO request,
                                                    @RequestParam Long regionId) {
        storeService.createStore(request,regionId);
        return ApiResponse.onSuccess("가게 추가가 완료되었습니다");
    }
}
