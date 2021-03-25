package br.ifsul.lp3.ecom.service;

import br.ifsul.lp3.ecom.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public boolean deletarPorId(Integer id) {
        try {
            produtoRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
