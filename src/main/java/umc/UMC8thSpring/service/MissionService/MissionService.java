package umc.UMC8thSpring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.UMC8thSpring.apiPayload.code.status.ErrorStatus;
import umc.UMC8thSpring.apiPayload.exception.handler.TempHandler;
import umc.UMC8thSpring.domain.Member;
import umc.UMC8thSpring.domain.Mission;
import umc.UMC8thSpring.domain.mapping.MemberMission;
import umc.UMC8thSpring.repository.MemberMissionRepository;
import umc.UMC8thSpring.repository.MemberRepository.MemberRepository;
import umc.UMC8thSpring.repository.MissionRepository;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;

    public void addMemberMission(Long missionId){
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new TempHandler(ErrorStatus._BAD_REQUEST));

        Member member = memberRepository.findById(1);
        MemberMission memberMission = MemberMission.builder()
                .mission(mission)
                .member(member)
                .build();
        memberMissionRepository.save(memberMission);
    }

    public Page<Mission> getMissionList(Integer page) {
        Page<Mission> missionPage = missionRepository.findAll(PageRequest.of(page, 10));
        return missionPage;
    }
}
