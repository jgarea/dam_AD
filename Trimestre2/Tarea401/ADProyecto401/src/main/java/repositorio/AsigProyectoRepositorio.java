/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import entidades.AsigProyecto;
import entidades.Empleado;
import entidades.Proyecto;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Juan
 */
public class AsigProyectoRepositorio implements Repositorio<AsigProyecto, Object[]>{

    private Session sesion;

    public AsigProyectoRepositorio(Session sesion) {
        this.sesion = sesion;
    }
    @Override
    public void insertarUno(AsigProyecto t) {
        Transaction trx = sesion.beginTransaction();
	sesion.save(t);
	trx.commit();
    }

    @Override
    public void borrar(AsigProyecto t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<AsigProyecto> encontrarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    @Override
    public void actualizar(AsigProyecto t) {
        Transaction trx = sesion.beginTransaction();
	sesion.update(t);
	trx.commit();
    }

    
    public AsigProyecto encontrarUnoPorID(Empleado emp, Proyecto id) {
        Transaction trx = sesion.beginTransaction();

        Query query = sesion.createQuery("SELECT a FROM AsigProyecto a WHERE a.empleado = :emp AND a.proyecto = :id");
        query.setParameter("emp", emp);
        query.setParameter("id", id);

        AsigProyecto asig = (AsigProyecto) query.getSingleResult();

        trx.commit();

        return asig;
    }

    @Override
    public AsigProyecto encontrarUnoPorID(Object[] key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
