package br.inatel.labs.labrest.client.model;

public class Curso {
	
	private Long id;
	
	private String description;
	
	private Integer cargaHorario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCargaHorario() {
		return cargaHorario;
	}

	public void setCargaHorario(Integer cargaHorario) {
		this.cargaHorario = cargaHorario;
	}
	
	

}
