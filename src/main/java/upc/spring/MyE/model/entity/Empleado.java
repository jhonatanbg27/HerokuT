package upc.spring.MyE.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Empleados")
public class Empleado implements Serializable{			
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer EmpleadoId; 	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer EmpleadoId;
	
	@OneToOne
	@JoinColumn(name="PersonaId",nullable = true)		
	private Persona Persona;
	
	@Column(name="DNI",nullable = false)
	private Integer DNI;
	
	@Column(name="Estado",nullable = false)
	private Boolean Estado;

	@Column(name="Latitud",nullable = true)
	private Double Latitud;
	
	@Column(name="Longitud",nullable = true)
	private Double Longitud;


	public Empleado(Integer empleadoId, upc.spring.MyE.model.entity.Persona persona, Integer dNI, Boolean estado,
			Double latitud, Double longitud) {
		super();
		EmpleadoId = empleadoId;
		Persona = persona;
		DNI = dNI;
		Estado = estado;
		Latitud = latitud;
		Longitud = longitud;
	}


	public Integer getEmpleadoId() {
		return EmpleadoId;
	}


	public void setEmpleadoId(Integer empleadoId) {
		EmpleadoId = empleadoId;
	}


	public Persona getPersona() {
		return Persona;
	}


	public void setPersona(Persona persona) {
		Persona = persona;
	}


	public Integer getDNI() {
		return DNI;
	}


	public void setDNI(Integer dNI) {
		DNI = dNI;
	}


	public Boolean getEstado() {
		return Estado;
	}


	public void setEstado(Boolean estado) {
		Estado = estado;
	}


	public Double getLatitud() {
		return Latitud;
	}


	public void setLatitud(Double latitud) {
		Latitud = latitud;
	}


	public Double getLongitud() {
		return Longitud;
	}


	public void setLongitud(Double longitud) {
		Longitud = longitud;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	
	
}
