package co.com.poli.autoevaluacion.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="documentos_indicadores")
public class DocumentoIndicador {

	@Id
	@Column(name="documentos_indicadoresID")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long documentosIndicadoresID;
	
	@ManyToOne
	@JoinColumn(name="indicadorID")
	private Indicador indicador;
	
	private String archivo;
	
	@ManyToOne
	@JoinColumn(name="autoevaluacionDetalleID")
	private AutoevaluacionDetalle autoevaluacionDetalle;

	public Long getDocumentosIndicadoresID() {
		return documentosIndicadoresID;
	}

	public void setDocumentosIndicadoresID(Long documentosIndicadoresID) {
		this.documentosIndicadoresID = documentosIndicadoresID;
	}

	public Indicador getIndicador() {
		return indicador;
	}

	public void setIndicador(Indicador indicador) {
		this.indicador = indicador;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public AutoevaluacionDetalle getAutoevaluacionDetalle() {
		return autoevaluacionDetalle;
	}

	public void setAutoevaluacionDetalle(AutoevaluacionDetalle autoevaluacionDetalle) {
		this.autoevaluacionDetalle = autoevaluacionDetalle;
	}
	
}
