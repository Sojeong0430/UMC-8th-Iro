package umc.UMC8thSpring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.UMC8thSpring.apiPayload.ApiResponse;
import umc.UMC8thSpring.converter.StoreConverter;
import umc.UMC8thSpring.domain.Review;
import umc.UMC8thSpring.service.StoreService.StoreQueryService;
import umc.UMC8thSpring.service.StoreService.StoreService;
import umc.UMC8thSpring.web.dto.StoreRequestDTO;
import umc.UMC8thSpring.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {

    private final StoreService storeService;
    private final StoreQueryService storeQueryService;

    @Operation(summary = "특정 지역 가게 추가 API", description = "가게를 추가합니다.")
    @PostMapping
    public ApiResponse<String> createMemberMission (@RequestParam StoreRequestDTO.storeAddDTO request,
                                                    @RequestParam Long regionId) {
        storeService.createStore(request,regionId);
        return ApiResponse.onSuccess("가게 추가가 완료되었습니다");
    }

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList( @PathVariable(name = "storeId") Long storeId,@RequestParam(name = "page") Integer page){
        Page<Review>  reviewList = storeQueryService.getReviewList(storeId,page);
        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(reviewList));
    }
}