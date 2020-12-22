package com.mitocode.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "signos")
public class Signos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer signosId;

	@ManyToOne
	@JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(name = "FK_signos_paciente"))
	private Paciente paciente;

	@Column(name = "fecha", nullable = false)
	private LocalDateTime fecha;
	
	@Column(name = "temperatura", nullable = false)
	private String temperatura;
	
	@Column(name = "pulso", nullable = false)
	private String pulso;
	
	@Column(name = "ritmo_respiratorio", nullable = false)
	private String ritmoRespiratorio;
	
	public Signos() {
		super();
	}

	public Signos(Integer signosId, Paciente paciente, LocalDateTime fecha, String temperatura, String pulso,
			String ritmoRespiratorio) {
		this();
		this.signosId = signosId;
		this.paciente = paciente;
		this.fecha = fecha;
		this.temperatura = temperatura;
		this.pulso = pulso;
		this.ritmoRespiratorio = ritmoRespiratorio;
	}

	public Integer getSignosId() {
		return signosId;
	}

	public void setSignosId(Integer signosId) {
		this.signosId = signosId;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public String getPulso() {
		return pulso;
	}

	public void setPulso(String pulso) {
		this.pulso = pulso;
	}

	public String getRitmoRespiratorio() {
		return ritmoRespiratorio;
	}

	public void setRitmoRespiratorio(String ritmoRespiratorio) {
		this.ritmoRespiratorio = ritmoRespiratorio;
	}

}
