package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.interceptador.LogInterceptador;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
//@Interceptors({LogInterceptador.class})
public class AutorDao {

	@PersistenceContext
	private EntityManager manager;

	@PostConstruct
	void aposCriacao() {
		System.out.println("[INFO Construcao] AutorDao carregado.");
	}

	public void salva(Autor autor) {

		System.out.println("Salvando o autor" + autor.getNome());

		manager.persist(autor);

		System.out.println("Salvo " + autor.getNome());

//		throw new LivrariaException();
	}

	public List<Autor> todosAutores() {
		return manager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.manager.find(Autor.class, autorId);
		return autor;
	}

}
