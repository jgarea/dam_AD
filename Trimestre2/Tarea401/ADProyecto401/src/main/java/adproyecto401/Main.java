package adproyecto401;

import entidades.AsigProyecto;
import entidades.Empleado;
import entidades.Proyecto;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.hibernate.Session;
import repositorio.AsigProyectoRepositorio;
import repositorio.EmpleadoRepositorio;
import repositorio.ProyectoRepositorio;

/**
 *
 * @author Juan
 */
public class Main {

    static Scanner sc;
    static ProyectoRepositorio pRepositorio;
    static EmpleadoRepositorio eRepositorio;
    static AsigProyectoRepositorio aRepositorio;

    public static void main(String[] args) {
        System.out.println("Ejercicio 404");

        sc = new Scanner(System.in);

        try (Session session = HibernateUtil.get().openSession();) {

            pRepositorio = new ProyectoRepositorio(session);
            eRepositorio = new EmpleadoRepositorio(session);
            aRepositorio = new AsigProyectoRepositorio(session);
            mostrarMenu(session);

            session.close();
            System.out.println("Conexion cerrada");
        }
    }

    private static void mostrarMenu(Session session) {
        int opcion = 0;
        do {
            session.clear();
            System.out.println("----Menu----");
            System.out.println("0. Salir.");
            System.out.println("1. Empleado.");
            System.out.println("2. Proyecto.");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    mostrarMenuEmpleado();
                    break;
                case 2:
                    mostrarMenuProyecto();
                    break;
            }

        } while (opcion != 0);
    }

    private static void mostrarMenuEmpleado() {
        System.out.println("----Menu----");
        System.out.println("0. Salir.");
        System.out.println("1. Crear.");
        System.out.println("2. Borrar.");
        System.out.println("3. Modificar.");
        int opcion = 0;
        opcion = Integer.parseInt(sc.nextLine());
        switch (opcion) {
            case 1:
                Empleado e = crearEmpleado();
                eRepositorio.insertarUno(e);
                break;
            case 2:
                eRepositorio.borrar(crearEmpleado());
                break;
            case 3:
                Empleado ea = crearEmpleado();
                ea.setNombre("ALBA");
                eRepositorio.actualizar(ea);
                break;

        }
    }

    private static Empleado crearEmpleado() {
        return new Empleado("32453343C", "Alba");
    }

    private static void mostrarMenuProyecto() {
        System.out.println("----Menu----");
        System.out.println("0. Salir.");
        System.out.println("1. Crear.");
        System.out.println("2. Borrar.");
        System.out.println("3. Modificar.");
        System.out.println("4. Asignar empleado a proyecto.");
        System.out.println("5.Indicar el fin de la participación de un empleado en un proyecto.	");
        int opcion = 0;
        opcion = Integer.parseInt(sc.nextLine());
        switch (opcion) {
            case 4:
                System.out.println("Selecciona el proyecto");
                Proyecto p= pRepositorio.encontrarUnoPorID(1);
                Empleado e= eRepositorio.encontrarUnoPorID("32453343C");
                aRepositorio.insertarUno(new AsigProyecto(e, p, LocalDate.now(), null));
                break;
            case 5:
                System.out.println("Selecciona el proyecto");
                Proyecto pe= pRepositorio.encontrarUnoPorID(1);
                Empleado ee= eRepositorio.encontrarUnoPorID("32453343C");
                AsigProyecto ap=aRepositorio.encontrarUnoPorID(ee, pe);
                ap.setFechaFin(LocalDate.now());
                aRepositorio.actualizar(ap);
                break;
        }
        
    }
}
