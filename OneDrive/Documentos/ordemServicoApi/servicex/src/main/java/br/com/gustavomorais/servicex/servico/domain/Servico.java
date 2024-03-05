package br.com.gustavomorais.servicex.servico.domain;

import java.util.List;

import br.com.gustavomorais.servicex.categoria.domain.Categoria;
import br.com.gustavomorais.servicex.ordemservico.domain.OrdemServico;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "SERVICO")
@Data
public class Servico {
	
	@Id
	@Column(name = "ID_SERVICO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idServico;
	
	@Column(name = "NOME_SERVICO")
	private String nome;
	
	@Column(name = "VALOR_SERVICO")
	private Double valor;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ID_CAYEGORIA")
	private Categoria categoria;
	
	@OneToMany(mappedBy = "servico")
	@JoinColumn(name = "ID_ORDEM_SERVICO")
	private List<OrdemServico> ordemServico;
	
}
