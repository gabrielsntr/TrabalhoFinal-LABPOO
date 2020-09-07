package Model.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Assento.class)
public abstract class Assento_ {

	public static volatile SingularAttribute<Assento, Integer> numeroAssento;
	public static volatile SingularAttribute<Assento, String> nomePassageiro;
	public static volatile SingularAttribute<Assento, Integer> id;
	public static volatile SingularAttribute<Assento, Itinerario> itinerario;
	public static volatile SingularAttribute<Assento, String> telefonePassageiro;

}

