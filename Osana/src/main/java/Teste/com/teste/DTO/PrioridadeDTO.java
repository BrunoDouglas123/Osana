package Teste.com.teste.DTO;

import Teste.com.teste.Model.Prioridade;

public class PrioridadeDTO {
	
	private Long id;
	private String name;
	
	public PrioridadeDTO() {		
	}
	
	public PrioridadeDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public PrioridadeDTO(Prioridade priority) {
		this.id = priority.getId();
		this.name = priority.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
