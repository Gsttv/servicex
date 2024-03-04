package br.com.gustavomorais.servicex.categoria.domain;

import java.util.List;

import br.com.gustavomorais.servicex.servico.domain.Servico;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CATEGORIA")
@Data
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CATEGORIA")
	private Integer idCategoria;
	
	@Column(name = "NOME_CATEGORIA")
	private String nomeCategoria;
	
	@Column(name = "SERVICOS")
	@OneToMany(mappedBy = "categoria",cascade = CascadeType.ALL)
	private List<Servico> servico;
	
	public Categoria() {}

}
