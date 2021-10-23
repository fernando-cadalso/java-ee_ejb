package br.com.caelum.livraria.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {

	@AroundInvoke
	public Object interceptador(InvocationContext contexto) throws Exception {
		
		long millis = System.currentTimeMillis();
		
		/*
		 * Chama o método da classe DAO anotada com o
		 * Interceptador.
		 */
		Object object = contexto.proceed();
		
		/*
		 * Recupera o nome da classe e do método
		 * que foi interceptada e exibe no console.
		 */
		String nomeClasse = contexto.getTarget().getClass().getSimpleName();
		String nomeMetodo = contexto.getMethod().getName();
		System.out.println("Objetos interceptados: " + nomeClasse + "." + nomeMetodo);
		System.out.println("Tempo de processamento em ms: " + (System.currentTimeMillis() - millis));
		
		return object;
		
	}
}
