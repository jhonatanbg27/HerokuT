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
@Table(name="Clientes")
public class Cliente implements Serializable{			
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer ClienteId; 	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ClienteId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PersonaId")		
	private Persona Persona;	

	@Column(name="Ruc",nullable = true)
	private Integer Ruc;

	public Integer getClienteId() {
		return ClienteId;
	}

	public void setClienteId(Integer clienteId) {
		ClienteId = clienteId;
	}

	public Persona getPersona() {
		return Persona;
	}

	public void setPersona(Persona persona) {
		Persona = persona;
	}

	public Integer getRuc() {
		return Ruc;
	}

	public void setRuc(Integer ruc) {
		Ruc = ruc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Cliente(Integer clienteId, upc.spring.MyE.model.entity.Persona persona, Integer ruc) {
		super();
		ClienteId = clienteId;
		Persona = persona;
		Ruc = ruc;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
