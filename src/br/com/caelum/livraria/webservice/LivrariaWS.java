package br.com.caelum.livraria.webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Livro;

@WebService //Configura a classe como um web service no padrão JAX-WS
@Stateless
public class LivrariaWS {

	@Inject
	LivroDao dao;
	
	@WebResult(name = "autores") //Agrupa o resultado dentro da tag "autores"
	public List<Livro> getLivrosPeloNome(@WebParam(name = "titulo") String nome){
		/*
		 * A anotação @WebParam define um nome para a tag que enviará a informação
		 * de pesquisa via HTTP POST para o serviço.
		 */
		System.out.println("LivrariaWS: Procurando pelo nome: " + nome);
		
		return dao.livrosPeloNome(nome);
	}
}
