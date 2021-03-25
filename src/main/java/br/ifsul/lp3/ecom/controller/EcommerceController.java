package br.ifsul.lp3.ecom.controller;

import br.ifsul.lp3.ecom.dto.ProdutoDTO;
import br.ifsul.lp3.ecom.dto.ProdutoExportadoDTO;
import br.ifsul.lp3.ecom.entity.Produto;
import br.ifsul.lp3.ecom.service.BuscarProdutoService;
import br.ifsul.lp3.ecom.service.CadastraProdutoService;
import br.ifsul.lp3.ecom.service.DeletarProdutoService;
import br.ifsul.lp3.ecom.service.EditarProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@RestController(value = "ecommerce")
@RequestMapping("ecommerce")
public class EcommerceController {

    @Autowired
    private BuscarProdutoService buscarProdutoService;

    @Autowired
    private CadastraProdutoService cadastraProdutoService;

    @Autowired
    private EditarProdutoService editarProdutoService;

    @Autowired
    private DeletarProdutoService deletarProdutoService;

    @PostMapping(value = "/produtos/cadastrar")
    public ResponseEntity<Produto> cadastrar(@RequestBody ProdutoExportadoDTO produtoExportadoDTO) {
        Produto produto = cadastraProdutoService.cadastrarProduto(produtoExportadoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @PutMapping(value = "/produtos/{id}/editar")
    public ResponseEntity<Produto> editar(@PathVariable(value = "id") Integer id, @RequestBody ProdutoExportadoDTO produtoExportadoDTO) {
        Produto novoProduto = editarProdutoService.editarProduto(id, produtoExportadoDTO);
        if (Objects.isNull(novoProduto)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    @DeleteMapping(value = "/produtos/{id}/deletar")
    public ResponseEntity<Integer> deletar(@PathVariable(value = "id") Integer id) {
        boolean sucessoNaDelecao = deletarProdutoService.deletarPorId(id);
        if (sucessoNaDelecao) {
            return ResponseEntity.status(HttpStatus.OK).body(id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id);
        }
    }

    @GetMapping(value = "/produtos/{id}")
    public ResponseEntity<Produto> buscaProduto(@PathVariable(value = "id") Integer id) {
        Produto novoProduto = buscarProdutoService.buscarPorId(id);
        if (Objects.isNull(novoProduto)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(novoProduto);
    }

    @GetMapping(value = "/produtos")
    public ResponseEntity<List<ProdutoExportadoDTO>> listarTodos() {
        List<ProdutoExportadoDTO> produtos = buscarProdutoService.listarTodosProdutosExportados();
        if (produtos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(produtos);
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }

    @GetMapping(path = "/produtos/{pagina}/{elementosPorPagina}")
    public ResponseEntity<List<Produto>> listarPaginada(@PathVariable Integer pagina, @PathVariable Integer elementosPorPagina) {
        List<Produto> produtos = buscarProdutoService.listarPaginado(pagina, elementosPorPagina);
        if (produtos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(produtos);
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }


    @GetMapping(value = "/produtos/nome/{nome}")
    public ResponseEntity<List<ProdutoDTO>> listarPorNome(@PathVariable(value = "nome") String nome) {
        List<ProdutoDTO> produtos = buscarProdutoService.listarPorNome(nome);
        if (produtos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(produtos);
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }

    @GetMapping(value = "/produtos/data")
    public ResponseEntity<List<Produto>> listarPorRange(@RequestParam Date dateInicial, @RequestParam Date dataFinal) {
        List<Produto> produtos = buscarProdutoService.listarPorRange(dateInicial, dataFinal);
        if (produtos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(produtos);
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }
}



