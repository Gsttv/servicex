package br.com.gustavomorais.servicex.endereco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gustavomorais.servicex.endereco.domain.Endereco;
import br.com.gustavomorais.servicex.endereco.respositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Endereco criarCategoria(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public List<Endereco> recuperarTodasCategoria() {
		return enderecoRepository.findAll();
	}
	
	public Optional<Endereco> recuperarCategoriaPorId(Long id) {
		return enderecoRepository.findById(id);
	}
	
	public Endereco atualizarCategoria(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public void deletarEndereco(Long id) {
		enderecoRepository.deleteById(id);
	}
}
