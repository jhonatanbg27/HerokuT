package upc.spring.MyE.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Ordenes")
public class Orden implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer OrdenId;
	//Esta es la direccion
	
	@ManyToOne
	@JoinColumn(name="EmpleadoId", nullable = false)	
	private Empleado Empleado;
	
	@ManyToOne
	@JoinColumn(name="ClienteId", nullable = false)	
	private Cliente Cliente;
	
	@ManyToOne
	@JoinColumn(name="EjemplarId", nullable = false)	
	private Ejemplar Ejemplar;
	
	@Column(name="NServicio",nullable = false,length = 40)
	private String NServicio;

	@Column(name="FechaGeneracion",nullable = true)
	private Date FechaGeneracion;
	
	@Column(name="NumPuntaje",nullable = true)
	private Integer NumPuntaje;
	
	@Column(name="FechaEjecucion",nullable = true,length = 40)
	private Date FechaEjecucion;

	@Column(name="EstadoFinalizado",nullable = true)
	private Boolean EstadoFinalizado;

	@Column(name="FechaFinalizacion",nullable = true)
	private Date FechaFinalizacion;

	public Integer getOrdenId() {
		return OrdenId;
	}

	public void setOrdenId(Integer ordenId) {
		OrdenId = ordenId;
	}

	public Empleado getEmpleado() {
		return Empleado;
	}

	public void setEmpleado(Empleado empleado) {
		Empleado = empleado;
	}

	public Cliente getCliente() {
		return Cliente;
	}

	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}

	public Ejemplar getEjemplar() {
		return Ejemplar;
	}

	public void setEjemplar(Ejemplar ejemplar) {
		Ejemplar = ejemplar;
	}

	public String getNServicio() {
		return NServicio;
	}

	public void setNServicio(String nServicio) {
		NServicio = nServicio;
	}

	public Date getFechaGeneracion() {
		return FechaGeneracion;
	}

	public void setFechaGeneracion(Date fechaGeneracion) {
		FechaGeneracion = fechaGeneracion;
	}

	public Integer getNumPuntaje() {
		return NumPuntaje;
	}

	public void setNumPuntaje(Integer numPuntaje) {
		NumPuntaje = numPuntaje;
	}

	public Date getFechaEjecucion() {
		return FechaEjecucion;
	}

	public void setFechaEjecucion(Date fechaEjecucion) {
		FechaEjecucion = fechaEjecucion;
	}

	public Boolean getEstadoFinalizado() {
		return EstadoFinalizado;
	}

	public void setEstadoFinalizado(Boolean estadoFinalizado) {
		EstadoFinalizado = estadoFinalizado;
	}

	public Date getFechaFinalizacion() {
		return FechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		FechaFinalizacion = fechaFinalizacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Orden(Integer ordenId, upc.spring.MyE.model.entity.Empleado empleado,
			upc.spring.MyE.model.entity.Cliente cliente, upc.spring.MyE.model.entity.Ejemplar ejemplar,
			String nServicio, Date fechaGeneracion, Integer numPuntaje, Date fechaEjecucion, Boolean estadoFinalizado,
			Date fechaFinalizacion) {
		super();
		OrdenId = ordenId;
		Empleado = empleado;
		Cliente = cliente;
		Ejemplar = ejemplar;
		NServicio = nServicio;
		FechaGeneracion = fechaGeneracion;
		NumPuntaje = numPuntaje;
		FechaEjecucion = fechaEjecucion;
		EstadoFinalizado = estadoFinalizado;
		FechaFinalizacion = fechaFinalizacion;
	}

	public Orden() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}