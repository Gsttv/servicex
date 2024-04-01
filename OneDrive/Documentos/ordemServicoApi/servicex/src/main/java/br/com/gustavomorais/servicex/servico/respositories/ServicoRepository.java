package br.com.gustavomorais.servicex.servico.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gustavomorais.servicex.servico.domain.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
