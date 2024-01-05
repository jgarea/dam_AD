package repositorio;

import java.util.List;

/**
 *
 * @author Juan
 */
public interface Repositorio<T,K> {
	void insertarUno(T t);
	void borrar(T t);
	List<T> encontrarTodos();
	T encontrarUnoPorID(K nombre);
	void actualizar(T t);
}