package upc.spring.MyE.model.entity;

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
@Table(name="Modelos")
public class Modelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ModeloId;
	
	@Column(name="SerieModelo",nullable = false,length = 40)
	private String SerieModelo;
	
	@ManyToOne
	@JoinColumn(name="EquipoId", nullable = false)	
	private Equipo Equipo;

	public Integer getModeloId() {
		return ModeloId;
	}

	public void setModeloId(Integer modeloId) {
		ModeloId = modeloId;
	}

	public String getSerieModelo() {
		return SerieModelo;
	}

	public void setSerieModelo(String serieModelo) {
		SerieModelo = serieModelo;
	}

	public Equipo getEquipo() {
		return Equipo;
	}

	public void setEquipo(Equipo equipo) {
		Equipo = equipo;
	}

	public Modelo(Integer modeloId, String serieModelo, upc.spring.MyE.model.entity.Equipo equipo) {
		super();
		ModeloId = modeloId;
		SerieModelo = serieModelo;
		Equipo = equipo;
	}

	public Modelo() {
		super();
		// TODO Auto-generated constructor stub
	}



	
	
	
	
}