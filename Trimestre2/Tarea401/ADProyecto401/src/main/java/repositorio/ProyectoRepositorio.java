/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import entidades.Proyecto;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Juan
 */
public class ProyectoRepositorio implements Repositorio<Proyecto, Integer> {

    private Session sesion;

    public ProyectoRepositorio(Session sesion) {
        this.sesion = sesion;
    }

    @Override
    public void insertarUno(Proyecto t) {
        Transaction trx = sesion.beginTransaction();
        sesion.save(t);
        trx.commit();
    }

    @Override
    public void borrar(Proyecto t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Proyecto> encontrarTodos() {

        Query query = sesion.createQuery("SELECT p FROM Proyecto p");
        List<Proyecto> listDatos = query.getResultList();

        return listDatos;

    }

    @Override
    public Proyecto encontrarUnoPorID(Integer nombre) {
        Transaction trx = this.sesion.beginTransaction();

        Query query = this.sesion.createQuery("SELECT p FROM Proyecto p where p.id=:id");

        query.setParameter("id", nombre.intValue());

        Proyecto proyecto = (Proyecto) query.getSingleResult();

        trx.commit();

        return proyecto;
    }

    @Override
    public void actualizar(Proyecto t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
