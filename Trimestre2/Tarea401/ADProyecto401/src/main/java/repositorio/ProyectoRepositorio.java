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
        
        Query query = sesion.createQuery("SELECT p.nombre FROM Proyecto p where id=1");
List<Proyecto> listDatos = query.getResultList();
for (Proyecto datos : listDatos){
    System.out.println(datos);
}

        return null;
        
    }

    @Override
    public Proyecto encontrarUnoPorID(Integer nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizar(Proyecto t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
