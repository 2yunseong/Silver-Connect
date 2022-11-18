package com.confident.silverconnect.domain.Household;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QHousehold is a Querydsl query type for Household
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHousehold extends EntityPathBase<Household> {

    private static final long serialVersionUID = -1377319066L;

    public static final QHousehold household = new QHousehold("household");

    public final StringPath address = createString("address");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> residentAge = createNumber("residentAge", Integer.class);

    public final StringPath residentName = createString("residentName");

    public final StringPath residentPhoneNumber = createString("residentPhoneNumber");

    public final EnumPath<Risk> risk = createEnum("risk", Risk.class);

    public QHousehold(String variable) {
        super(Household.class, forVariable(variable));
    }

    public QHousehold(Path<? extends Household> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHousehold(PathMetadata metadata) {
        super(Household.class, metadata);
    }

}

