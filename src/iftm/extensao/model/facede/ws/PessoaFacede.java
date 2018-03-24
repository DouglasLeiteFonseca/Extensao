package iftm.extensao.model.facede.ws;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import iftm.extensao.model.dao.PessoaDao;
import iftm.extensao.model.domain.Pessoa;
@WebService(serviceName="ws/pessoa")
public class PessoaFacede {
	@Inject
	private PessoaDao pessoaDao;
	@WebMethod(operationName="retornaTodasAsPessoas")
	public List<Pessoa> getPessoas(){
		List<Pessoa>pessoas = pessoaDao.getPessoas();
		for(Pessoa p:pessoas) {
			p.setParticipacoes(null);
			p.setProjetosAutor(null);
		}
		return pessoas;
	}
	
	@WebMethod(operationName="retornaPessoaPorID")
	public Pessoa getPessoa(@WebParam(name="idPessoa")Integer id) {
		Pessoa p = pessoaDao.getPessoaId(id);
		p.setParticipacoes(null);
		p.setProjetosAutor(null);
		return p;
	}
	
	@WebMethod(operationName="excluirPessoa")
	public void excluirPessoa(@WebParam(name="idPessoa") Integer id) {
		pessoaDao.excluirPessoa(id);
	}
	
	@WebMethod(operationName="salvarPessoa")
	public void salvarPessoa(@WebParam(name="Pessoa") Pessoa pessoa) {
		pessoaDao.salvarPessoa(pessoa);
	}
	
	@WebMethod(operationName="atualizarPessoa")
	public void atualizarPessoa(@WebParam(name="Pessoa") Pessoa pessoa) {
		pessoaDao.atualizarPessoa(pessoa);
	}
}
