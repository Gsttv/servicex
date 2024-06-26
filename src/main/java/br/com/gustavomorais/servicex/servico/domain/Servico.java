package br.com.gustavomorais.servicex.servico.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.gustavomorais.servicex.categoria.domain.Categoria;
import br.com.gustavomorais.servicex.ordemservico.domain.OrdemServico;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
	
	// Define a entidade que contém a chave estrangeira e é responsável por gerenciar a relação.
	@ManyToOne
	@JoinColumn(name="ID_CATEGORIA")
	private Categoria categoria;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "servico", cascade = CascadeType.ALL)
	private List<OrdemServico> ordemServico;
	
}
