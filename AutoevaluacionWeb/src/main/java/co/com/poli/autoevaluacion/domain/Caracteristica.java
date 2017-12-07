package co.com.poli.autoevaluacion.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="caracteristicas")
public class Caracteristica {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long caracteristicaID;
	
	private String nombre;
	
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="factorID")
	private Factor factor;

	public Long getCaracteristicaId() {
		return caracteristicaID;
	}

	public void setCaracteristicaId(Long caracteristicaId) {
		this.caracteristicaID = caracteristicaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Factor getFactor() {
		return factor;
	}

	public void setFactor(Factor factor) {
		this.factor = factor;
	}
	
}
