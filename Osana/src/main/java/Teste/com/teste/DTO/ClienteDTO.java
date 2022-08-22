package Teste.com.teste.DTO;

import Teste.com.teste.Model.Cliente;

public class ClienteDTO {

	private Long id;
	private String name;
	private String contract;
	private String cnpj;
	
	public ClienteDTO (){		
	}

	public ClienteDTO(Long id, String name, String contract, String cnpj) {
		this.id = id;
		this.name = name;
		this.contract = contract;
		this.cnpj = cnpj;
	}
	
	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.name = cliente.getName();
		this.contract = cliente.getContract();
		this.cnpj = cliente.getCnpj();
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

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
