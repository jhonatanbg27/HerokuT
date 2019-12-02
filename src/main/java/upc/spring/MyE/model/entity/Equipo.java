package upc.spring.MyE.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="Equipos")
public class Equipo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer EquipoId;
	
	@Column(name="NEquipo",nullable = false,length = 40)
	private String NEquipo;
	
	
	@OneToMany(mappedBy = "Equipo")
	private List<Modelo> modelos;


	public Integer getEquipoId() {
		return EquipoId;
	}


	public void setEquipoId(Integer equipoId) {
		EquipoId = equipoId;
	}


	public String getNEquipo() {
		return NEquipo;
	}


	public void setNEquipo(String nEquipo) {
		NEquipo = nEquipo;
	}





	public Equipo() {
		super();
		// TODO Auto-generated constructor stub
	}





	

	

	

}