package iftm.extensao.model.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-03-10T10:58:30.044-0300")
@StaticMetamodel(Pessoa.class)
public class Pessoa_ {
	public static volatile SingularAttribute<Pessoa, Integer> id;
	public static volatile SingularAttribute<Pessoa, String> nome;
	public static volatile ListAttribute<Pessoa, Projeto> participacoes;
	public static volatile ListAttribute<Pessoa, Projeto> projetosAutor;
	public static volatile SingularAttribute<Pessoa, String> cpf;
}
