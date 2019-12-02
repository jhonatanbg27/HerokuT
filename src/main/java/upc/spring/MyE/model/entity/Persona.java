package upc.spring.MyE.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Personas")
public class Persona  implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PersonaId",nullable = false)
	private Integer PersonaId; 
	
	@Column(name="NPersona",nullable = true,length = 40)
	private String NPersona;
	
	@Column(name="ImagenRuta",nullable = true)
	private String ImagenRuta;
	//PARA LOGIN
	@Column(name="Psw",nullable = true,length = 40)
	private String Psw;
	
	@Column(name="NombreUsuario",nullable = true,length = 40)
	private String NombreUsuario;
	
	//
	@Column(name="NumContacto",nullable = true)
	private Integer NumContacto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="LugarId", nullable = true)	
	private Lugar Lugar;

	public Integer getPersonaId() {
		return PersonaId;
	}

	public void setPersonaId(Integer personaId) {
		PersonaId = personaId;
	}

	public String getNPersona() {
		return NPersona;
	}

	public void setNPersona(String nPersona) {
		NPersona = nPersona;
	}

	public String getImagenRuta() {
		return ImagenRuta;
	}

	public void setImagenRuta(String imagenRuta) {
		ImagenRuta = imagenRuta;
	}

	public String getPsw() {
		return Psw;
	}

	public void setPsw(String psw) {
		Psw = psw;
	}

	public String getNombreUsuario() {
		return NombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		NombreUsuario = nombreUsuario;
	}

	public Integer getNumContacto() {
		return NumContacto;
	}

	public void setNumContacto(Integer numContacto) {
		NumContacto = numContacto;
	}

	public Lugar getLugar() {
		return Lugar;
	}

	public void setLugar(Lugar lugar) {
		Lugar = lugar;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Persona(Integer personaId, String nPersona, String imagenRuta, String psw, String nombreUsuario,
			Integer numContacto, upc.spring.MyE.model.entity.Lugar lugar) {
		super();
		PersonaId = personaId;
		NPersona = nPersona;
		ImagenRuta = imagenRuta;
		Psw = psw;
		NombreUsuario = nombreUsuario;
		NumContacto = numContacto;
		Lugar = lugar;
	}

	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}




	
	
}
