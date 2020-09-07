package Model.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Itinerario.class)
public abstract class Itinerario_ {

	public static volatile SingularAttribute<Itinerario, Integer> qtdLugares;
	public static volatile SingularAttribute<Itinerario, Municipio> municipioDestino;
	public static volatile SingularAttribute<Itinerario, Integer> id;
	public static volatile SingularAttribute<Itinerario, Municipio> municipioOrigem;

}

