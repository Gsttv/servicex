package br.com.gustavomorais.servicex.categoria.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gustavomorais.servicex.categoria.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
