package br.ifsul.lp3.ecom.service;

import br.ifsul.lp3.ecom.dto.ProdutoExportadoDTO;
import br.ifsul.lp3.ecom.entity.Produto;
import br.ifsul.lp3.ecom.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastraProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto cadastrarProduto(ProdutoExportadoDTO produtoExportadoDTO) {
        Produto produto = Produto.buildByExportadoDTO(produtoExportadoDTO);
        return produtoRepository.save(produto);
    }
}
