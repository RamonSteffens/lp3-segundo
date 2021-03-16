package br.ifsul.lp3.ecom;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

    @Override
    Optional<Produto> findById(Integer integer);

    List<Produto> findByNome(String nome);

    List<Produto> findByValorGreaterThan(Double valor);
}
