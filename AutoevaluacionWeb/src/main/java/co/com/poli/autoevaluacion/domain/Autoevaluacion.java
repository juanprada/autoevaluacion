package co.com.poli.autoevaluacion.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="autoevaluacion")
public class Autoevaluacion {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long autoevaluacionID;
	
	@ManyToOne
	@JoinColumn(name="programasID")
	private Programa programa;
	
	private String periodo;

	public Long getAutoevaluacionID() {
		return autoevaluacionID;
	}

	public void setAutoevaluacionID(Long autoevaluacionID) {
		this.autoevaluacionID = autoevaluacionID;
	}

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	
}
