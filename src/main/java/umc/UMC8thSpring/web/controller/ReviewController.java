package umc.UMC8thSpring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.UMC8thSpring.apiPayload.ApiResponse;
import umc.UMC8thSpring.converter.StoreConverter;
import umc.UMC8thSpring.domain.Review;
import umc.UMC8thSpring.service.ReviewService.ReviewService;
import umc.UMC8thSpring.service.StoreService.StoreQueryService;
import umc.UMC8thSpring.validation.annotation.ValidatePage;
import umc.UMC8thSpring.validation.annotation.ValidateStoreExists;
import umc.UMC8thSpring.web.dto.ReviewRequestDTO;
import umc.UMC8thSpring.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final StoreQueryService storeQueryService;

    @Operation(summary = "리뷰 작성 API", description = "리뷰를 작성합니다.")
    @PostMapping
    public ApiResponse<String> join(@RequestBody @Valid ReviewRequestDTO.postReivewDto request,
                                    @RequestParam @ValidateStoreExists Long storeId){
        reviewService.createReview(request, storeId);
        return ApiResponse.onSuccess("리뷰 작성이 완료되었습니다");
    }

    @Operation(summary = "내가 작성한 리뷰 목록 API", description = "내가 작성한 리뷰 목록을 불러옵니다.")
    @GetMapping(value="/member")
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> myReviews(@RequestParam(defaultValue = "0", name="page") @ValidatePage Integer pageNum){
        Page<Review> reviewList = reviewService.getMyReviewList(pageNum);
        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(reviewList));
    }
}
