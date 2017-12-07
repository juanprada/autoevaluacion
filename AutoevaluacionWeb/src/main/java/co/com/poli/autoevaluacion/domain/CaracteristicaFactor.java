package co.com.poli.autoevaluacion.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="caracteristicas")
public class CaracteristicaFactor {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long caracteristicaID;
	
	private String nombre;
	
	private String descripcion;
	
	private Long factorID;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="caracteristicaID", insertable=false, updatable=false)
	private List<IndicadorCaracteristica> indicadores;

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

	public Long getFactorID() {
		return factorID;
	}

	public void setFactorID(Long factorID) {
		this.factorID = factorID;
	}

	public List<IndicadorCaracteristica> getIndicadores() {
		return indicadores;
	}

	public void setIndicadores(List<IndicadorCaracteristica> indicadores) {
		this.indicadores = indicadores;
	}
}
