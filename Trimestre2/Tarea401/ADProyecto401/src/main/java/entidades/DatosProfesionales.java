/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Juan
 */

    @Entity
@Table(name = "datos_profesionales")
public class DatosProfesionales implements Serializable{
    @Id
    @OneToOne
    @JoinColumn(name = "dni")
    private Empleado empleado;
    private String categoria;
    private Double sueldoBruto;
    // getters y setters

    public DatosProfesionales() {
    }

    public DatosProfesionales(Empleado empleado, String categoria, Double sueldoBruto) {
        this.empleado = empleado;
        this.categoria = categoria;
        this.sueldoBruto = sueldoBruto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(Double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatosProfesionales that = (DatosProfesionales) o;
        return Objects.equals(empleado, that.empleado) &&
                Objects.equals(categoria, that.categoria) &&
                Objects.equals(sueldoBruto, that.sueldoBruto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empleado, categoria, sueldoBruto);
    }
    
    @Override
    public String toString() {
        return "DatosProfesionales{" + "empleado=" + empleado + ", categoria=" + categoria + ", sueldoBruto=" + sueldoBruto + '}';
    }
    
    
}

