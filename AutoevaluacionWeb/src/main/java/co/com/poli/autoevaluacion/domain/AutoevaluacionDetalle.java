package co.com.poli.autoevaluacion.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="autoevaluacion_detalle")
public class AutoevaluacionDetalle {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long autoevaluacionDetalleID;
	
	@ManyToOne
	@JoinColumn(name="autoevaluacionID")
	private Autoevaluacion autoevaluacion;
	
	@ManyToOne
	@JoinColumn(name="indicadorID")
	private Indicador indicador;
	
	private Integer calificacion;
	
	private String observaciones;

	public Long getAutoevaluacionDetalleID() {
		return autoevaluacionDetalleID;
	}

	public void setAutoevaluacionDetalleID(Long autoevaluacionDetalleID) {
		this.autoevaluacionDetalleID = autoevaluacionDetalleID;
	}

	public Autoevaluacion getAutoevaluacion() {
		return autoevaluacion;
	}

	public void setAutoevaluacion(Autoevaluacion autoevaluacion) {
		this.autoevaluacion = autoevaluacion;
	}

	public Indicador getIndicador() {
		return indicador;
	}

	public void setIndicador(Indicador indicador) {
		this.indicador = indicador;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
