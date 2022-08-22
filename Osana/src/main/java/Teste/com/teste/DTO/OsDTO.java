package Teste.com.teste.DTO;

import java.time.LocalDate;

import Teste.com.teste.Model.Os;

public class OsDTO {

	private Long id;
	private String motive;
	private String obs;
	private LocalDate devolution;
	private LocalDate dateos;
	
	private StatusDTO status;
	private ClienteDTO cliente;
	private PrioridadeDTO prioridade;
	private UsuarioDTO usuario;
	
	public OsDTO(Long id, String motive, String obs, LocalDate devolution, LocalDate dateos,
			StatusDTO status, ClienteDTO cliente, PrioridadeDTO prioridade, UsuarioDTO usuario) {
		this.id = id;
		this.motive = motive;
		this.obs = obs;
		this.devolution = devolution;
		this.dateos = dateos;
		this.status = status;
		this.cliente = cliente;
		this.prioridade = prioridade;
		this.usuario = usuario;
	}

	public OsDTO(Os os) {
		this.id = os.getId();
		this.motive = os.getMotive();
		this.obs = os.getObs();
		this.devolution = os.getDevolution();
		this.dateos = os.getDateos();
		this.status = new StatusDTO(os.getStatus());
		this.cliente = new ClienteDTO(os.getCliente());
		this.prioridade = new PrioridadeDTO(os.getPrioridade());
		this.usuario = new UsuarioDTO(os.getUsuario());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMotive() {
		return motive;
	}

	public void setMotive(String motive) {
		this.motive = motive;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public LocalDate getDevolution() {
		return devolution;
	}

	public void setDevolution(LocalDate devolution) {
		this.devolution = devolution;
	}

	public LocalDate getDateos() {
		return dateos;
	}

	public void setDateos(LocalDate dateos) {
		this.dateos = dateos;
	}

	public StatusDTO getStatus() {
		return status;
	}

	public void setStatus(StatusDTO status) {
		this.status = status;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public PrioridadeDTO getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(PrioridadeDTO prioridade) {
		this.prioridade = prioridade;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
}
