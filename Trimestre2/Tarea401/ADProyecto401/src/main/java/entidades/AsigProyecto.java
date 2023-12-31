package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Juan
 */
@Entity
@Table(name = "asig_proyecto")
public class AsigProyecto implements Serializable{
    @Id
    @ManyToOne
    @JoinColumn(name = "dni_emp",columnDefinition = "char")
    private Empleado empleado;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_proyecto")
    private Proyecto proyecto;
    @Column(name = "fecha_inicio")
//    @Temporal(TemporalType.DATE)
    private LocalDate fechaInicio;
    @Column(name = "fecha_fin")
//    @Temporal(TemporalType.DATE)
    private LocalDate fechaFin;
    
    
    // getters y setters

    public AsigProyecto() {
    }

    public AsigProyecto(Empleado empleado, Proyecto proyecto, LocalDate fechaInicio, LocalDate fechaFin) {
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

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsigProyecto that = (AsigProyecto) o;
        return Objects.equals(empleado, that.empleado) &&
                Objects.equals(proyecto, that.proyecto);
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
