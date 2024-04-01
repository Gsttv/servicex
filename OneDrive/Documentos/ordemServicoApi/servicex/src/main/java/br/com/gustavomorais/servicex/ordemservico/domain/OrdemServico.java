package br.com.gustavomorais.servicex.ordemservico.domain;

import java.sql.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.gustavomorais.servicex.pagamento.domain.Pagamento;
import br.com.gustavomorais.servicex.servico.domain.Servico;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "ORDEM_SERVICO")
@NoArgsConstructor
public class OrdemServico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ORDEM_SERVICO")
	private Long idOrdemServico;
	
	@Column(name = "DATA_SOLICITACAO")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataSolicitacao;
	
	@Column(name = "VALOR_ORDEM_SERVICO")
	private Double valorOrdemServico;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "ordemServico")
	private Pagamento pagamento;
	
	@ManyToMany
	//manyToMany sempre sera criado uma terceira tabela, 
	@JoinTable(name = "SERVICO_OS", joinColumns = @JoinColumn(name = "ID_ORDEM_SERVICO"),inverseJoinColumns = @JoinColumn(name = "ID_SERVICO"))
	private Set<Servico> servico;
	

}
