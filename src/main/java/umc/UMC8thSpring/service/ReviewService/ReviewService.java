package umc.UMC8thSpring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.UMC8thSpring.domain.Member;
import umc.UMC8thSpring.domain.Review;
import umc.UMC8thSpring.domain.Store;
import umc.UMC8thSpring.repository.MemberRepository.MemberRepository;
import umc.UMC8thSpring.repository.ReviewRepository;
import umc.UMC8thSpring.repository.StoreRepository.StoreRepository;
import umc.UMC8thSpring.web.dto.ReviewRequestDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    public void createReview(ReviewRequestDTO.postReivewDto request, Long storeId) {

        Optional<Store> store = storeRepository.findById(storeId);
        Member member = memberRepository.findById(1);

        Review review = Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .body(request.getBody())
                .store(store.get())
                .member(member)
                .build();

        reviewRepository.save(review);
    }
}
