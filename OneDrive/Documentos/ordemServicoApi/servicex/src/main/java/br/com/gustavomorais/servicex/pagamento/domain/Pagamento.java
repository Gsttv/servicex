package br.com.gustavomorais.servicex.pagamento.domain;

import br.com.gustavomorais.servicex.ordemservico.domain.OrdemServico;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PAGAMENTO")
public abstract class Pagamento {

	@Id
	private Long idPagamento;
	
	@Column(name = "STATUS_PAGAMENTO")
	private Integer statusPagamento;
	
	@OneToOne
	@JoinColumn(name = "ID_ORDEM_SERVICO")
	@MapsId
	private OrdemServico ordemServico;

	public Pagamento(Long idPagamento, StatusPagamento statusPagamento, OrdemServico ordemServico) {
		this.idPagamento = idPagamento;
		this.statusPagamento = (statusPagamento == null) ? null : statusPagamento.getCod();
		this.ordemServico = ordemServico;
	}

	public Long getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(Long idPagamento) {
		this.idPagamento = idPagamento;
	}

	public StatusPagamento getStatusPagamento() {
		return StatusPagamento.toEnum(statusPagamento);
	}

	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento.getCod();
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}
	
	
	
	
	
}
