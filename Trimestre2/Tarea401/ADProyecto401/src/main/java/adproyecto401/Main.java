package adproyecto401;

import entidades.Proyecto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import repositorio.ProyectoRepositorio;

/**
 *
 * @author Juan
 */
public class Main {

    static Scanner sc;
	static ProyectoRepositorio pRepositorio;
	
    public static void main(String[] args) {
        System.out.println("Ejercicio 404");
		
		sc = new Scanner(System.in);
		
		Session session = HibernateUtil.get().openSession();
                
                pRepositorio= new ProyectoRepositorio(session);
                
                mostrarMenu();
                
                session.close();
                System.out.println("Conexion cerrada");
    }

    private static void mostrarMenu() {
        List<Proyecto> lista=pRepositorio.encontrarTodos();
        
//        for (Proyecto proyecto : lista) {
//            System.out.println(proyecto);
//        }

        
        
//        Proyecto p= new Proyecto();
//        p.setId(7);
//        pRepositorio.insertarUno(p);
        
    }
}
