package br.ifsul.lp3.ecom.repository;

import br.ifsul.lp3.ecom.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Override
    Optional<Produto> findById(Integer integer);

    List<Produto> findByNome(String nome);

    List<Produto> findAllByDataCriacaoBetween(Date dataInicio, Date dataFim);

    List<Produto> findByValorGreaterThan(Double valor);
}
