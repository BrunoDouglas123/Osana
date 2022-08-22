package Teste.com.teste.Model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "os")
public class Os implements Serializable {
	private static final long serialVersionUID = -3928407830218096274L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_os", nullable = false)
	private Long id;
	
	@Column(name = "motive", length = 45, nullable = false)
	private String motive;
	
	@Column(name = "obs", length = 45, nullable = false)
	private String obs;
	
	@Column(name = "devolution", length = 45, nullable = false)
	private LocalDate devolution;
	
	@Column(name = "dateos", length = 45, nullable = false)
	private LocalDate dateos;
	
	@ManyToOne
	@JoinColumn(name = "id_status")
	private Status status;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "id_prioridade")
	private Prioridade prioridade;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	public Os() {	
	}

	public Os(Long id, String motive, String obs, LocalDate devolution, LocalDate dateos,
			Status status, Cliente cliente, Prioridade prioridade, Usuario usuario) {
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
