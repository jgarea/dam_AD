/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import entidades.Empleado;
import entidades.Proyecto;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Juan
 */
public class EmpleadoRepositorio implements Repositorio<Empleado, String>{

    private Session sesion;

    public EmpleadoRepositorio(Session sesion) {
        this.sesion = sesion;
    }
    @Override
    public void insertarUno(Empleado t) {
        Transaction trx = sesion.beginTransaction();
	sesion.save(t);
	trx.commit();
    }

    @Override
    public void borrar(Empleado t) {
        Transaction trx = sesion.beginTransaction();
	sesion.delete(t);
	trx.commit();
    }

    @Override
    public List<Empleado> encontrarTodos() {
        Query query = sesion.createQuery("SELECT e FROM Empleado e");
        List<Empleado> listDatos = query.getResultList();

        return listDatos;
    }

    @Override
    public Empleado encontrarUnoPorID(String key) {
        Transaction trx = this.sesion.beginTransaction();

        Query query = this.sesion.createQuery("SELECT e FROM Empleado e where e.dni=:dni");

        query.setParameter("dni", key);

        Empleado empleado = (Empleado) query.getSingleResult();

        trx.commit();

        return empleado;
    }

    @Override
    public void actualizar(Empleado t) {
        Transaction trx = sesion.beginTransaction();
	sesion.update(t);
	trx.commit();
    }
    
}
