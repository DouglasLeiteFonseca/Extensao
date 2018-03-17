package iftm.extensao.model.facede.rs;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import iftm.extensao.model.dao.PessoaDao;
import iftm.extensao.model.domain.Pessoa;

@Path(value="/pessoa")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class PessoaFacede {
	@Inject
	private PessoaDao pessoaDao;
	@GET
	public List<Pessoa> getPessoas(){
		List<Pessoa>pessoas = pessoaDao.getPessoas();
		for(Pessoa p:pessoas) {
			p.setParticipacoes(null);
			p.setProjetosAutor(null);
		}
		return pessoas;
	}
	@GET
	@Path(value="/{id}")
	public Pessoa getPessoa(@PathParam("id") Integer id) {
		Pessoa p = pessoaDao.getPessoaId(id);
		p.setParticipacoes(null);
		p.setProjetosAutor(null);
		return p;
	}
}
