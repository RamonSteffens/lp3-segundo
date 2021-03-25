package br.ifsul.lp3.ecom.service;

import br.ifsul.lp3.ecom.dto.ProdutoDTO;
import br.ifsul.lp3.ecom.dto.ProdutoExportadoDTO;
import br.ifsul.lp3.ecom.entity.Produto;
import br.ifsul.lp3.ecom.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class BuscarProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoExportadoDTO> listarTodosProdutosExportados() {
        List<Produto> produtos = produtoRepository.findAll();

        List<ProdutoExportadoDTO> exportadosDTO = buildExportacaoDTO(produtos);

        return exportadosDTO;
    }

    public List<Produto> listarPorRange(Date dateInicial, Date dataFinal) {
        return produtoRepository.findAllByDataCriacaoBetween(dateInicial, dataFinal);
    }

    private List<ProdutoExportadoDTO> buildExportacaoDTO(List<Produto> produtos) {
        List<ProdutoExportadoDTO> exportadosDTO = new ArrayList<>();
        produtos.forEach(produto -> {
            exportadosDTO.add(ProdutoExportadoDTO.buildPorProduto(produto));
        });
        return exportadosDTO;
    }

    public List<ProdutoDTO> listarPorNome(String nome) {
        List<Produto> produtos = produtoRepository.findByNome(nome);
        List<ProdutoDTO> produtosDTO = new ArrayList<>();
        produtos.forEach(produto -> produtosDTO.add(ProdutoDTO.buildByProduct(produto)));

        return produtosDTO;
    }

    public Produto buscarPorId(Integer id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public List<Produto> listarPaginado(Integer pagina, Integer elementosPorPagina) {
        return produtoRepository.findAll(PageRequest.of(pagina, elementosPorPagina)).getContent();
    }
}
