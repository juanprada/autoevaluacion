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
@Table(name="factores")
public class Factor {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long factorID;
	private String nombre;
	private String descripcion;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="factorID", insertable=false, updatable=false)
	private List<CaracteristicaFactor> caracteristicas;
	
	public Long getFactorID() {
		return factorID;
	}
	public void setFactorID(Long factorID) {
		this.factorID = factorID;
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
	public List<CaracteristicaFactor> getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(List<CaracteristicaFactor> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	
}
