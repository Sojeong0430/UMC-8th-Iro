package umc.UMC8thSpring.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.UMC8thSpring.domain.common.BaseEntity;
import umc.UMC8thSpring.domain.enums.Gender;
import umc.UMC8thSpring.domain.enums.MemberStatus;
import umc.UMC8thSpring.domain.enums.Role;
import umc.UMC8thSpring.domain.enums.SocialType;
import umc.UMC8thSpring.domain.mapping.MemberAgree;
import umc.UMC8thSpring.domain.mapping.MemberMission;
import umc.UMC8thSpring.domain.mapping.MemberPrefer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@DynamicUpdate
@DynamicInsert // null인 경우 그냥 쿼리를 보내지 않도록 한다.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = false, length = 40)
    private String specAddress;

    @Enumerated(EnumType.STRING)
    //@Column(nullable = false, length = 10)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    //@Column(nullable = false, length = 10)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    //@Column(nullable = false, length = 15)
    private MemberStatus status;

    private LocalDate inactiveDate;

    @ColumnDefault("0")
    private Integer point;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    public void encodePassword(String password) {
        this.password = password;
    }
}
