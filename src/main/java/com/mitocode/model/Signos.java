package com.mitocode.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "signos")
public class Signos {

	@Id
	private Integer signosId;

	@ManyToOne
	@JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(name = "FK_signos_paciente"))
	private Paciente paciente;

	@Column(name = "fecha", nullable = false)
	private LocalDateTime fecha;
	
	@Column(name = "temperatura", nullable = false)
	private Double temperatura;
	
	@Column(name = "pulso", nullable = false)
	private Double pulso;
	
	@Column(name = "ritmo_respiratorio", nullable = false)
	private Double ritmoRespiratorio;
	
	public Signos() {
		super();
	}

	public Signos(Integer signosId, Paciente paciente, LocalDateTime fecha, Double temperatura, Double pulso,
			Double ritmoRespiratorio) {
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

	public Double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}

	public Double getPulso() {
		return pulso;
	}

	public void setPulso(Double pulso) {
		this.pulso = pulso;
	}

	public Double getRitmoRespiratorio() {
		return ritmoRespiratorio;
	}

	public void setRitmoRespiratorio(Double ritmoRespiratorio) {
		this.ritmoRespiratorio = ritmoRespiratorio;
	}

}
