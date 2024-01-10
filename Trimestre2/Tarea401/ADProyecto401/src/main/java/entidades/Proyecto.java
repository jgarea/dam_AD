/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Juan
 */

@Entity
@Table(name = "proyecto")
public class Proyecto implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "fecha_inicio")
//    @Temporal(TemporalType.DATE)
    private LocalDate fecha_inicio;
    
    @Column(name = "fecha_fin")
//    @Temporal(TemporalType.DATE)
    private LocalDate fecha_fin;
    
    @ManyToOne
    @JoinColumn(name = "dni_jefe_proyecto")
    private Empleado jefeProyecto;

    @ManyToMany(mappedBy = "proyectos")
    private List<Empleado> empleados;
    
    public Proyecto() {
    }

    public Proyecto(int id, String nombre, LocalDate fecha_inicio, Empleado jefeProyecto) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_inicio = fecha_inicio;
        this.jefeProyecto = jefeProyecto;
    }

    public Proyecto(String nombre, LocalDate fecha_inicio, LocalDate fecha_fin, Empleado jefeProyecto) {
        this.nombre = nombre;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.jefeProyecto = jefeProyecto;
    }

    public Proyecto(int id, String nombre, LocalDate fecha_inicio, LocalDate fecha_fin, Empleado jefeProyecto, List<Empleado> empleados) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.jefeProyecto = jefeProyecto;
        this.empleados = empleados;
    }
    
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Empleado getJefeProyecto() {
        return jefeProyecto;
    }

    public void setJefeProyecto(Empleado jefeProyecto) {
        this.jefeProyecto = jefeProyecto;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

  
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + Objects.hashCode(this.fecha_inicio);
        hash = 89 * hash + Objects.hashCode(this.fecha_fin);
        hash = 89 * hash + Objects.hashCode(this.jefeProyecto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Proyecto other = (Proyecto) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Proyecto{" + "id=" + id + ", nombre=" + nombre + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", jefeProyecto=" + jefeProyecto + ", empleados=" + empleados + '}';
    }

    
    
   



   
    
    
    
}
