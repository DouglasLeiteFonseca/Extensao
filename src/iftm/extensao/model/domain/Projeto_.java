package iftm.extensao.model.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-03-10T08:17:39.608-0300")
@StaticMetamodel(Projeto.class)
public class Projeto_ {
	public static volatile SingularAttribute<Projeto, Integer> id;
	public static volatile SingularAttribute<Projeto, String> nome;
	public static volatile SingularAttribute<Projeto, Integer> horas;
	public static volatile SingularAttribute<Projeto, Pessoa> autor;
	public static volatile SingularAttribute<Projeto, Date> dataInicio;
	public static volatile SingularAttribute<Projeto, Date> dataFim;
	public static volatile ListAttribute<Projeto, Pessoa> participantes;
}
