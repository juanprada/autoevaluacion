package co.com.poli.autoevaluacion.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="programas")
public class Programa {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long programasID;
	private String nombre;
	private String facultad;
	@Column(name="nro_semestres")
	private String nroSemestres;
	
	@Column(name="anio_creacion")
	private String anioCreacion;
	
	@Column(name="nro_creditos")
	private Integer nroCreditos;
	
	@Column(name="res_reg_calidad")
	private String resolucionRegistroCalidad;
	
	public Long getProgramasID() {
		return programasID;
	}
	public void setProgramasID(Long programasID) {
		this.programasID = programasID;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	public String getNroSemestres() {
		return nroSemestres;
	}
	public void setNroSemestres(String nroSemestres) {
		this.nroSemestres = nroSemestres;
	}
	public String getAnioCreacion() {
		return anioCreacion;
	}
	public void setAnioCreacion(String anioCreacion) {
		this.anioCreacion = anioCreacion;
	}
	public Integer getNroCreditos() {
		return nroCreditos;
	}
	public void setNroCreditos(Integer nroCreditos) {
		this.nroCreditos = nroCreditos;
	}
	public String getResolucionRegistroCalidad() {
		return resolucionRegistroCalidad;
	}
	public void setResolucionRegistroCalidad(String resolucionRegistroCalidad) {
		this.resolucionRegistroCalidad = resolucionRegistroCalidad;
	}
}
