package co.com.poli.autoevaluacion.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Parametros {

	@Id
	private Long parametrosID;
	
	private String codigo;
	
	private String descripcion;
	
	private String valor;

	public Long getParametrosID() {
		return parametrosID;
	}

	public void setParametrosID(Long parametroID) {
		this.parametrosID = parametroID;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
}
