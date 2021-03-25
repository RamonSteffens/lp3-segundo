package br.ifsul.lp3.ecom.service;


import br.ifsul.lp3.ecom.dto.ProdutoExportadoDTO;
import br.ifsul.lp3.ecom.entity.Produto;
import br.ifsul.lp3.ecom.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EditarProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto editarProduto(Integer id, ProdutoExportadoDTO produtoExportadoDTO) {
        Optional<Produto> produtoAntigo = produtoRepository.findById(id);

        if (produtoAntigo.isPresent()) {
            Produto novoProduto = Produto.buildByExportadoDTO(produtoExportadoDTO);
            novoProduto.setId(id);
            produtoRepository.save(novoProduto);
        }
        return null;
    }
}
