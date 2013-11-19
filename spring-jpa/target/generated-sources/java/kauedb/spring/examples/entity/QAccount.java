package kauedb.spring.examples.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QAccount is a Querydsl query type for Account
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAccount extends EntityPathBase<Account> {

    private static final long serialVersionUID = 1956544560;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QAccount account = new QAccount("account");

    public final QCostumer costumer;

    public final DateTimePath<java.util.Date> expiredDate = createDateTime("expiredDate", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QAccount(String variable) {
        this(Account.class, forVariable(variable), INITS);
    }

    public QAccount(Path<? extends Account> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAccount(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAccount(PathMetadata<?> metadata, PathInits inits) {
        this(Account.class, metadata, inits);
    }

    public QAccount(Class<? extends Account> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.costumer = inits.isInitialized("costumer") ? new QCostumer(forProperty("costumer")) : null;
    }

}

