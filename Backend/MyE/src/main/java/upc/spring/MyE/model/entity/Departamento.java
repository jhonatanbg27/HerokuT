package upc.spring.MyE.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Departamentos")
public class Departamento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Departamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer DepartamentoId;
	
	@Column(name="NDepartamento",nullable = false,length = 40)
	private String NDepartamento;

	public Integer getDepartamentoId() {
		return DepartamentoId;
	}

	public void setDepartamentoId(Integer departamentoId) {
		DepartamentoId = departamentoId;
	}

	public String getNDepartamento() {
		return NDepartamento;
	}

	public void setNDepartamento(String nDepartamento) {
		NDepartamento = nDepartamento;
	}

	public Departamento(Integer departamentoId, String nDepartamento) {
		super();
		DepartamentoId = departamentoId;
		NDepartamento = nDepartamento;
	}

	
	
	
}
