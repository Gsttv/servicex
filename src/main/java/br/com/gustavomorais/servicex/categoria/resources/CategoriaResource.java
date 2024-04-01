package br.com.gustavomorais.servicex.categoria.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavomorais.servicex.categoria.domain.Categoria;
import br.com.gustavomorais.servicex.categoria.services.CategoriaService;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping
	public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria){
		return new ResponseEntity<Categoria>(categoriaService.criarCategoria(categoria),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Categoria>> buscarTodasCategorias(){
		return new ResponseEntity<List<Categoria>>(categoriaService.recuperarTodasCategoria(),HttpStatus.FOUND);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> buscarCategoriasPorId(@PathVariable Long id){
		return categoriaService.recuperarCategoriaPorId(id)
		.map(categoria -> new ResponseEntity(categoria,HttpStatus.OK))
		.orElseGet(()-> new ResponseEntity(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletarCategoria(@PathVariable Long id){
		categoriaService.deletarCategoria(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria){
		if(!categoriaService.recuperarCategoriaPorId(id).isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		categoria.setIdCategoria(id);
		Categoria categoriaAtualizada = categoriaService.atualizarCategoria(categoria);
		return new ResponseEntity<Categoria>(categoriaAtualizada,HttpStatus.OK);
		
		
	}
	
}
