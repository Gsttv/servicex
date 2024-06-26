package br.com.gustavomorais.servicex.ordemservico.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gustavomorais.servicex.ordemservico.domain.OrdemServico;
import br.com.gustavomorais.servicex.ordemservico.services.OrdemServicoService;

@RestController
@RequestMapping(value = "/ordemServico")
public class OrdemServicoResource {
	
	@Autowired
	private OrdemServicoService ordemServicoService;
	
	@GetMapping
	public ResponseEntity<List<OrdemServico>> buscarTodasOrdens(){
		return new ResponseEntity<List<OrdemServico>>(ordemServicoService.buscarTodasOrdensServico(),HttpStatus.FOUND);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrdemServico> buscarOrdemPorId(@PathVariable Long id){
		return ordemServicoService.buscarOrdemServicoPorId(id)
				.map(ordemServico -> new ResponseEntity(HttpStatus.FOUND))
				.orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
		
	}
	
	/*
	 * @PostMapping public ResponseEntity<OrdemServico>
	 * criarOrdemServico(@ResponseBody OrdemServico ordemServico){
	 * ordemServicoService.criarOrdemServico(ordemServico); URI uri =
	 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand
	 * (ordemServicoService.getIdOrdemServico()); }
	 */

}
