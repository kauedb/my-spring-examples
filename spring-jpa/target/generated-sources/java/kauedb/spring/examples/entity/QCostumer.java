package kauedb.spring.examples.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QCostumer is a Querydsl query type for Costumer
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCostumer extends EntityPathBase<Costumer> {

    private static final long serialVersionUID = -2058182417;

    public static final QCostumer costumer = new QCostumer("costumer");

    public final StringPath firstName = createString("firstName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lastName = createString("lastName");

    public QCostumer(String variable) {
        super(Costumer.class, forVariable(variable));
    }

    public QCostumer(Path<? extends Costumer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCostumer(PathMetadata<?> metadata) {
        super(Costumer.class, metadata);
    }

}

