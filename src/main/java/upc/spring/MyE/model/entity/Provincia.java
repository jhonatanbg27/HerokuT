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
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Provincias")
public class Provincia implements Serializable{
	public Provincia() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ProvinciaId;
	
	@Column(name="NProvincia",nullable = false,length = 40)
	private String NProvincia;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="DepartamentoId", nullable = false)	
	private Departamento Departamento;

	public Integer getProvinciaId() {
		return ProvinciaId;
	}

	public void setProvinciaId(Integer provinciaId) {
		ProvinciaId = provinciaId;
	}

	public String getNProvincia() {
		return NProvincia;
	}

	public void setNProvincia(String nProvincia) {
		NProvincia = nProvincia;
	}

	public Departamento getDepartamento() {
		return Departamento;
	}

	public void setDepartamento(Departamento departamento) {
		Departamento = departamento;
	}

	public Provincia(Integer provinciaId, String nProvincia, upc.spring.MyE.model.entity.Departamento departamento) {
		super();
		ProvinciaId = provinciaId;
		NProvincia = nProvincia;
		Departamento = departamento;
	}
	

	
	
}
