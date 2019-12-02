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
@Table(name="Lugares")
public class Lugar implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer LugarId;
	//Esta es la direccion
	@Column(name="NLugar",nullable = false,length = 40)
	private String NLugar;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="DistritoId", nullable = false)	
	private Distrito Distrito;

	public Integer getLugarId() {
		return LugarId;
	}

	public void setLugarId(Integer lugarId) {
		LugarId = lugarId;
	}

	public String getNLugar() {
		return NLugar;
	}

	public void setNLugar(String nLugar) {
		NLugar = nLugar;
	}

	public Distrito getDistrito() {
		return Distrito;
	}

	public void setDistrito(Distrito distrito) {
		Distrito = distrito;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Lugar() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}