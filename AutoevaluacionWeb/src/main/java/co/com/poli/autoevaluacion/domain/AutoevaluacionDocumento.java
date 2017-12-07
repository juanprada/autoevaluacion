package co.com.poli.autoevaluacion.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="autoevaluacion_documentos")
public class AutoevaluacionDocumento {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long autoevaluacionDocumentoID;
	
	@ManyToOne
	@JoinColumn(name="autoevaluacionID")
	private Autoevaluacion autoevaluacion;
	
	private String archivo;

	public Long getAutoevaluacionDocumentoID() {
		return autoevaluacionDocumentoID;
	}

	public void setAutoevaluacionDocumentoID(Long autoevaluacionDocumentoID) {
		this.autoevaluacionDocumentoID = autoevaluacionDocumentoID;
	}

	public Autoevaluacion getAutoevaluacion() {
		return autoevaluacion;
	}

	public void setAutoevaluacion(Autoevaluacion autoevaluacion) {
		this.autoevaluacion = autoevaluacion;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	
}
