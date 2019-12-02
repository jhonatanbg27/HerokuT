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
@Table(name="Ejemplares")
public class Ejemplar  implements Serializable{
	public Ejemplar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer EjemplarId;
	
	@Column(name="NEjemplar",nullable = false,length = 40)
	private String NEjemplar;
	
	@Column(name="ImagenRuta",nullable = true)
	private String ImagenRuta;
	
	@ManyToOne
	@JoinColumn(name="ModeloId", nullable = false)	
	private Modelo Modelo;

	public Integer getEjemplarId() {
		return EjemplarId;
	}

	public void setEjemplarId(Integer ejemplarId) {
		EjemplarId = ejemplarId;
	}

	public String getNEjemplar() {
		return NEjemplar;
	}

	public void setNEjemplar(String nEjemplar) {
		NEjemplar = nEjemplar;
	}

	public Modelo getModelo() {
		return Modelo;
	}

	public void setModelo(Modelo modelo) {
		Modelo = modelo;
	}

	public Ejemplar(Integer ejemplarId, String nEjemplar, String imagenRuta,
			upc.spring.MyE.model.entity.Modelo modelo) {
		super();
		EjemplarId = ejemplarId;
		NEjemplar = nEjemplar;
		ImagenRuta = imagenRuta;
		Modelo = modelo;
	}

	public String getImagenRuta() {
		return ImagenRuta;
	}

	public void setImagenRuta(String imagenRuta) {
		ImagenRuta = imagenRuta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}