package umc.UMC8thSpring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFoodCategory is a Querydsl query type for FoodCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFoodCategory extends EntityPathBase<FoodCategory> {

    private static final long serialVersionUID = -1934124823L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFoodCategory foodCategory = new QFoodCategory("foodCategory");

    public final umc.UMC8thSpring.domain.common.QBaseEntity _super = new umc.UMC8thSpring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QFoodCategory(String variable) {
        this(FoodCategory.class, forVariable(variable), INITS);
    }

    public QFoodCategory(Path<? extends FoodCategory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFoodCategory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFoodCategory(PathMetadata metadata, PathInits inits) {
        this(FoodCategory.class, metadata, inits);
    }

    public QFoodCategory(Class<? extends FoodCategory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

