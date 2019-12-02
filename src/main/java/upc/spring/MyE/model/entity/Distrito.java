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

@Entity
@Table(name="Distritos")
public class Distrito implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer DistritoId;
	
	@Column(name="NDistrito",nullable = false,length = 40)
	private String NDistrito;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ProvinciaId", nullable = false)	
	private Provincia Provincia;

	public Integer getDistritoId() {
		return DistritoId;
	}

	public void setDistritoId(Integer distritoId) {
		DistritoId = distritoId;
	}

	public String getNDistrito() {
		return NDistrito;
	}

	public void setNDistrito(String nDistrito) {
		NDistrito = nDistrito;
	}

	public Provincia getProvincia() {
		return Provincia;
	}

	public void setProvincia(Provincia provincia) {
		Provincia = provincia;
	}

	public Distrito(Integer distritoId, String nDistrito, upc.spring.MyE.model.entity.Provincia provincia) {
		super();
		DistritoId = distritoId;
		NDistrito = nDistrito;
		Provincia = provincia;
	}

	public Distrito() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}