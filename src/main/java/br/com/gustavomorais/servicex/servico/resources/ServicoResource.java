package br.com.gustavomorais.servicex.servico.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavomorais.servicex.servico.domain.Servico;
import br.com.gustavomorais.servicex.servico.services.ServicoService;

@RestController
@RequestMapping("/servico")
public class ServicoResource {

	@Autowired
	private ServicoService service;
	
	@GetMapping
	public ResponseEntity<List<Servico>> buscarTodosServicos(){
		return new ResponseEntity<List<Servico>>(service.buscarTodosServicos(), HttpStatus.FOUND);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Servico>> buscarServicoPorId(@PathVariable Long id){
		return service.buscarServicoPorId(id)
				.map(servico -> new ResponseEntity(servico,HttpStatus.FOUND)) //map é um operador intermediário disponível na classe Optional
				.orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
	}
	
	@PostMapping
	public ResponseEntity<Servico> criarServico(@RequestBody Servico servico){
		return new ResponseEntity<Servico>(service.criarServico(servico), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Servico> atualizarServico(@PathVariable Long id,@RequestBody Servico servico){
		if(!service.buscarServicoPorId(id).isPresent()) {
			return new ResponseEntity<Servico>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Servico>(service.criarServico(servico), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarServico(@PathVariable Long id){
		service.apagarServico(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
