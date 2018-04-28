package iftm.extensao.model.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import iftm.extensao.model.domain.Pessoa;

public class PessoaDao {
	@PersistenceContext(unitName="ExtensaoPU")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> getPessoas(){
		Query query = entityManager.createQuery("from Pessoa");
		return query.getResultList();
	}
	public List<Pessoa> getPessoasBusca(String nome){
		Query query = entityManager.createQuery("from Pessoa where nome like '%"+nome+"%'");
		return query.getResultList();
	}
	
	public Pessoa getPessoaId(int id) {
		return entityManager.find(Pessoa.class, id);
	}
	@Transactional
	public void salvarPessoa(Pessoa pessoa) {
		entityManager.persist(pessoa);
	}
	@Transactional
	public void excluirPessoa(Integer id) {
		entityManager.remove(entityManager.getReference(Pessoa.class, id));
	}
	@Transactional
	public void atualizarPessoa(Pessoa pessoa) {
		pessoa = entityManager.merge(pessoa);
		entityManager.persist(pessoa);
	}
	
}
