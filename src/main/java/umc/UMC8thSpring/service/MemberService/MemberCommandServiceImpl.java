package umc.UMC8thSpring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.UMC8thSpring.apiPayload.code.status.ErrorStatus;
import umc.UMC8thSpring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.UMC8thSpring.converter.MemberConverter;
import umc.UMC8thSpring.converter.MemberPreferConverter;
import umc.UMC8thSpring.domain.FoodCategory;
import umc.UMC8thSpring.domain.Member;
import umc.UMC8thSpring.domain.mapping.MemberPrefer;
import umc.UMC8thSpring.repository.FoodCategoryRepository;
import umc.UMC8thSpring.repository.MemberRepository.MemberRepository;
import umc.UMC8thSpring.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}