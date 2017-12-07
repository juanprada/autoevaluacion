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
@Table(name="estudiantes")
public class Estudiante {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long estudianteID;
	
	private String periodo;
	
	private Long inscritos;
	
	private Long matriculados;
	
	private Long primiparos;
	
	private Long egresados;
	
	private Long graduados;
	
	private Long admitidos;
	
	private Long retirados;
	
	@Column(name="tasa_desercion")
	private Long tasaDesercion;
	
	@Column(name="porcentaje_culminan")
	private Long porcentajeCulminan;
	
	@Column(name="nro_est_otras_ies_nales")
	private Long nroEstudiantesOtrasIESNales;
	
	@Column(name="nro_est_otras_ies_internales")
	private Long nroEstudiantesOtrasIESInternales;
	
	@Column(name="nro_est_visit_nales")
	private Long nroEstudiantesVisitaNales;
	
	@Column(name="nro_est_visit_internales")
	private Long nroEstudiantesVisitaInternales;

	@ManyToOne
	@JoinColumn(name="programasID")
	private Programa programa;
	
	public Long getEstudianteID() {
		return estudianteID;
	}

	public void setEstudianteID(Long estudianteID) {
		this.estudianteID = estudianteID;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Long getInscritos() {
		return inscritos;
	}

	public void setInscritos(Long inscritos) {
		this.inscritos = inscritos;
	}

	public Long getMatriculados() {
		return matriculados;
	}

	public void setMatriculados(Long matriculados) {
		this.matriculados = matriculados;
	}

	public Long getPrimiparos() {
		return primiparos;
	}

	public void setPrimiparos(Long primiparos) {
		this.primiparos = primiparos;
	}

	public Long getEgresados() {
		return egresados;
	}

	public void setEgresados(Long egresados) {
		this.egresados = egresados;
	}

	public Long getGraduados() {
		return graduados;
	}

	public void setGraduados(Long graduados) {
		this.graduados = graduados;
	}

	public Long getAdmitidos() {
		return admitidos;
	}

	public void setAdmitidos(Long admitidos) {
		this.admitidos = admitidos;
	}

	public Long getRetirados() {
		return retirados;
	}

	public void setRetirados(Long retirados) {
		this.retirados = retirados;
	}

	public Long getTasaDesercion() {
		return tasaDesercion;
	}

	public void setTasaDesercion(Long tasaDesercion) {
		this.tasaDesercion = tasaDesercion;
	}

	public Long getPorcentajeCulminan() {
		return porcentajeCulminan;
	}

	public void setPorcentajeCulminan(Long porcentajeCulminan) {
		this.porcentajeCulminan = porcentajeCulminan;
	}

	public Long getNroEstudiantesOtrasIESNales() {
		return nroEstudiantesOtrasIESNales;
	}

	public void setNroEstudiantesOtrasIESNales(Long nroEstudiantesOtrasIESNales) {
		this.nroEstudiantesOtrasIESNales = nroEstudiantesOtrasIESNales;
	}

	public Long getNroEstudiantesOtrasIESInternales() {
		return nroEstudiantesOtrasIESInternales;
	}

	public void setNroEstudiantesOtrasIESInternales(Long nroEstudiantesOtrasIESInternales) {
		this.nroEstudiantesOtrasIESInternales = nroEstudiantesOtrasIESInternales;
	}

	public Long getNroEstudiantesVisitaNales() {
		return nroEstudiantesVisitaNales;
	}

	public void setNroEstudiantesVisitaNales(Long nroEstudiantesVisitaNales) {
		this.nroEstudiantesVisitaNales = nroEstudiantesVisitaNales;
	}

	public Long getNroEstudiantesVisitaInternales() {
		return nroEstudiantesVisitaInternales;
	}

	public void setNroEstudiantesVisitaInternales(Long nroEstudiantesVisitaInternales) {
		this.nroEstudiantesVisitaInternales = nroEstudiantesVisitaInternales;
	}

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}
	
}
