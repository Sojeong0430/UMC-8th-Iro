package umc.UMC8thSpring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberPrefer is a Querydsl query type for MemberPrefer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberPrefer extends EntityPathBase<MemberPrefer> {

    private static final long serialVersionUID = -823088425L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberPrefer memberPrefer = new QMemberPrefer("memberPrefer");

    public final umc.UMC8thSpring.domain.common.QBaseEntity _super = new umc.UMC8thSpring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final umc.UMC8thSpring.domain.QFoodCategory foodCategory;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.UMC8thSpring.domain.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMemberPrefer(String variable) {
        this(MemberPrefer.class, forVariable(variable), INITS);
    }

    public QMemberPrefer(Path<? extends MemberPrefer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberPrefer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberPrefer(PathMetadata metadata, PathInits inits) {
        this(MemberPrefer.class, metadata, inits);
    }

    public QMemberPrefer(Class<? extends MemberPrefer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodCategory = inits.isInitialized("foodCategory") ? new umc.UMC8thSpring.domain.QFoodCategory(forProperty("foodCategory"), inits.get("foodCategory")) : null;
        this.member = inits.isInitialized("member") ? new umc.UMC8thSpring.domain.QMember(forProperty("member")) : null;
    }

}

