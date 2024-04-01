package br.com.gustavomorais.servicex.ordemservico.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gustavomorais.servicex.ordemservico.domain.OrdemServico;
@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

}
