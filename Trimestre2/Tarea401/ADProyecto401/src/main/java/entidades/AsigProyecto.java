/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Juan
 */
@Entity
@Table(name = "asig_proyecto")
public class AsigProyecto implements Serializable{
    @Id
    @ManyToOne
    @JoinColumn(name = "dni_emp")
    private Empleado empleado;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_proyecto")
    private Proyecto proyecto;
    private Date fechaInicio;
    private Date fechaFin;
    
    
    // getters y setters

    public AsigProyecto() {
    }

    public AsigProyecto(Empleado empleado, Proyecto proyecto, Date fechaInicio, Date fechaFin) {
        this.empleado = empleado;
        this.proyecto = proyecto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsigProyecto that = (AsigProyecto) o;
        return Objects.equals(empleado, that.empleado) &&
                Objects.equals(proyecto, that.proyecto) &&
                Objects.equals(fechaInicio, that.fechaInicio) &&
                Objects.equals(fechaFin, that.fechaFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empleado, proyecto, fechaInicio,fechaFin);
    }
    
    @Override
    public String toString() {
        return "AsigProyecto{" + "empleado=" + empleado + ", proyecto=" + proyecto + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }
    
    
}
