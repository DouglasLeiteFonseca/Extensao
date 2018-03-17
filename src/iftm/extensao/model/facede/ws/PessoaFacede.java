package iftm.extensao.model.facede.ws;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

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
		Pessoa p = new Pessoa();
		if(id == 1) {
			p.setId(1);
			p.setNome("Douglas");
		}else {
			p.setId(2);
			p.setNome("Melissa");
		}
		return p;
	}
}
