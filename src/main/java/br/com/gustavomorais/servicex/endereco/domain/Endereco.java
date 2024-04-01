package br.com.gustavomorais.servicex.endereco.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Endereco {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ENDERECO")
	private Long idEndereco;
	@Column(name = "LOGRADOURO")
	private String logradouro;
	@Column(name = "NUMERO")
	private String numero;
	@Column(name = "CEP")
	private String cep;
	@Column(name = "COMPLEMENTO")
	private String complemento;
}
