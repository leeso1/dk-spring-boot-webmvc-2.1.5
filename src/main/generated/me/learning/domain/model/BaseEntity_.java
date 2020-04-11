package me.learning.domain.model;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BaseEntity.class)
public abstract class BaseEntity_ {

	public static volatile SingularAttribute<BaseEntity, LocalDateTime> created;
	public static volatile SingularAttribute<BaseEntity, LocalDateTime> updated;

	public static final String CREATED = "created";
	public static final String UPDATED = "updated";

}

