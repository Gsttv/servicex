package br.com.gustavomorais.servicex.endereco.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavomorais.servicex.endereco.domain.Endereco;
import br.com.gustavomorais.servicex.endereco.services.EnderecoService;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@PostMapping
	public ResponseEntity<Endereco> criarEndereco(@RequestBody Endereco endereco){
		return new ResponseEntity<Endereco>(enderecoService.criarCategoria(endereco),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Endereco>> buscarTodosEnderecos(){
		return new ResponseEntity<List<Endereco>>(enderecoService.recuperarTodasCategoria(),HttpStatus.FOUND);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Endereco>> buscarEnderecoPorId(@PathVariable Long id){
		return new ResponseEntity<Optional<Endereco>>(enderecoService.recuperarCategoriaPorId(id), HttpStatus.FOUND);
	}
	

}
