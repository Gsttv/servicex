package br.com.gustavomorais.servicex.categoria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gustavomorais.servicex.categoria.domain.Categoria;
import br.com.gustavomorais.servicex.categoria.respositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria criarCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public List<Categoria> recuperarTodasCategoria() {
		return categoriaRepository.findAll();
	}
	
	public Optional<Categoria> recuperarCategoriaPorId(Long id) {
		return categoriaRepository.findById(id);
	}
	
	public Categoria atualizarCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public void deletarCategoria(Long id) {
		categoriaRepository.deleteById(id);
	}
	

}
