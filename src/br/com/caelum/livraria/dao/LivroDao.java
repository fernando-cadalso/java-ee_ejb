package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Livro;

@Stateless
public class LivroDao {

	@PersistenceContext
	private EntityManager em;
	
	void aposCriacao() {
		System.out.println("[INFO-Construcao: LivroDao carregado.");
	}
	
	public void salva(Livro livro) {
		em.persist(livro);
	}
	
	public List<Livro> todosLivros() {
		return em.createQuery("select a from Livro a", Livro.class).getResultList();
	}

	public List<Livro> livrosPeloNome(String nome) {

		TypedQuery<Livro> query = em.createQuery("select l from Livro l where l.titulo like :pLivro", Livro.class);
		query.setParameter("pLivro", "%" + nome + "%");
		return query.getResultList();
	}
	
}
