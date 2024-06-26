package br.com.gustavomorais.servicex.pagamento.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;

import br.com.gustavomorais.servicex.ordemservico.domain.OrdemServico;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonTypeName("pagamentoBoleto") //Jackson framework de serializacao
public class PagamentoBoleto extends Pagamento {

	@Column(name = "DATA_VENCIMENTO")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataVencimento;
	
	@Column(name = "DATA_PAGAMENTO")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataPagamento;

	public PagamentoBoleto(Long idPagamento, StatusPagamento statusPagamento, OrdemServico ordemServico, Date dataVencimento, Date dataPagamento) {
		super(idPagamento, statusPagamento, ordemServico);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}
	
	

}
