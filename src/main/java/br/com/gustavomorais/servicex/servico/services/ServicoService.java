package br.com.gustavomorais.servicex.servico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gustavomorais.servicex.servico.domain.Servico;
import br.com.gustavomorais.servicex.servico.respositories.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository repository;
	
	public List<Servico> buscarTodosServicos(){
		return repository.findAll();
	}
	
	public Optional<Servico> buscarServicoPorId(Long id) {
		return repository.findById(id);
	}
	
	public Servico criarServico(Servico servico){
		return repository.save(servico);
	}
	
	public Servico atualizarServico(Servico servico) {
		return repository.save(servico);
	}
	
	public void apagarServico(Long id) {
		repository.deleteById(id);
	}
}
