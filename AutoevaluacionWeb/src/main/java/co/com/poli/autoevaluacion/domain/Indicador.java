package co.com.poli.autoevaluacion.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="indicadores")
public class Indicador {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long indicadorID;
	
	private String nombre;
	
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="caracteristicaID")
	private Caracteristica caracteristica;

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

	public Caracteristica getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(Caracteristica caracteristica) {
		this.caracteristica = caracteristica;
	}
}
