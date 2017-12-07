package co.com.poli.autoevaluacion.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="indicadores")
public class IndicadorCaracteristica {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long indicadorID;
	
	private String nombre;
	
	private String descripcion;
	
	private Long caracteristicaID;

	public Long getIndicadorID() {
		return indicadorID;
	}

	public void setIndicadorID(Long indicadorID) {
		this.indicadorID = indicadorID;
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

	public Long getCaracteristicaID() {
		return caracteristicaID;
	}

	public void setCaracteristicaID(Long caracteristicaID) {
		this.caracteristicaID = caracteristicaID;
	}

	
}
