package umc.UMC8thSpring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.UMC8thSpring.apiPayload.ApiResponse;
import umc.UMC8thSpring.service.ReviewService.ReviewService;
import umc.UMC8thSpring.validation.annotation.ValidateStoreExists;
import umc.UMC8thSpring.web.dto.ReviewRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Operation(summary = "리뷰 작성 API", description = "리뷰를 작성합니다.")
    @PostMapping
    public ApiResponse<String> join(@RequestBody @Valid ReviewRequestDTO.postReivewDto request,
                                    @RequestParam @ValidateStoreExists Long storeId){
        reviewService.createReview(request, storeId);
        return ApiResponse.onSuccess("리뷰 작성이 완료되었습니다");
    }
}
