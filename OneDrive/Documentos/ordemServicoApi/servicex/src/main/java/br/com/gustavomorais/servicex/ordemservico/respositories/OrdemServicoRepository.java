package br.com.gustavomorais.servicex.ordemservico.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gustavomorais.servicex.ordemservico.domain.OrdemServico;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

}
