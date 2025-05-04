package umc.UMC8thSpring.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.UMC8thSpring.domain.Member;
import umc.UMC8thSpring.domain.Mission;
import umc.UMC8thSpring.domain.common.BaseEntity;
import umc.UMC8thSpring.domain.enums.MissionStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;
}
