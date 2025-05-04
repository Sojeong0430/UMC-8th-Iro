package umc.UMC8thSpring.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.UMC8thSpring.domain.FoodCategory;
import umc.UMC8thSpring.domain.Member;
import umc.UMC8thSpring.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPrefer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private FoodCategory foodCategory;

}
