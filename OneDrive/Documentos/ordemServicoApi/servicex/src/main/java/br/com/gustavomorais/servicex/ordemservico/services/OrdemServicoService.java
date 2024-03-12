package br.com.gustavomorais.servicex.ordemservico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gustavomorais.servicex.ordemservico.domain.OrdemServico;
import br.com.gustavomorais.servicex.ordemservico.respositories.OrdemServicoRepository;

@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	public List<OrdemServico> buscarTodasOrdensServico(){
		return ordemServicoRepository.findAll();	
	}
	
	public Optional<OrdemServico> buscarOrdemServicoPorId(Long id){
		return ordemServicoRepository.findById(id);
	}
	
	public OrdemServico criarOrdemServico(OrdemServico ordemServico) {
		return ordemServicoRepository.save(ordemServico);
	}
	
	
}
