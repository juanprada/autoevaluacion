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
@Table(name="profesores")
public class Profesor {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long profesorID;
	
	private String nombres;
	
	private String apellidos;
	
	@Column(name="tipo_identificacion")
	private String tipoIdentificacion;
	
	private String cedula;
	
	@Column(name="nivel_academico")
	private String nivelAcademico;
	
	@Column(name="area_conocimiento")
	private String areaConocimiento;
	
	private String titulo;
	
	private String institucion;
	
	private String dedicacion;
	
	@Column(name="numero_horas")
	private Integer numeroHoras;
	
	@Column(name="horas_dedicacion_docencia")
	private Integer horasDedicacionDocencia;
	
	@Column(name="horas_investigacion")
	private Integer horasInvestigacion;
	
	@Column(name="horas_extension")
	private Integer horasExtension;
	
	@Column(name="forma_contratacion")
	private String formaContratacion;
	
	@ManyToOne
	@JoinColumn(name="programasID")
	private Programa programa;
	
	public Long getProfesorID() {
		return profesorID;
	}

	public void setProfesorID(Long profesorID) {
		this.profesorID = profesorID;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNivelAcademico() {
		return nivelAcademico;
	}

	public void setNivelAcademico(String nivelAcademico) {
		this.nivelAcademico = nivelAcademico;
	}

	public String getAreaConocimiento() {
		return areaConocimiento;
	}

	public void setAreaConocimiento(String areaConocimiento) {
		this.areaConocimiento = areaConocimiento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getDedicacion() {
		return dedicacion;
	}

	public void setDedicacion(String dedicacion) {
		this.dedicacion = dedicacion;
	}

	public Integer getNumeroHoras() {
		return numeroHoras;
	}

	public void setNumeroHoras(Integer numeroHoras) {
		this.numeroHoras = numeroHoras;
	}

	public Integer getHorasDedicacionDocencia() {
		return horasDedicacionDocencia;
	}

	public void setHorasDedicacionDocencia(Integer horasDedicacionDocencia) {
		this.horasDedicacionDocencia = horasDedicacionDocencia;
	}

	public Integer getHorasInvestigacion() {
		return horasInvestigacion;
	}

	public void setHorasInvestigacion(Integer horasInvestigacion) {
		this.horasInvestigacion = horasInvestigacion;
	}

	public Integer getHorasExtension() {
		return horasExtension;
	}

	public void setHorasExtension(Integer horasExtension) {
		this.horasExtension = horasExtension;
	}

	public String getFormaContratacion() {
		return formaContratacion;
	}

	public void setFormaContratacion(String formaContratacion) {
		this.formaContratacion = formaContratacion;
	}

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}
	
}
