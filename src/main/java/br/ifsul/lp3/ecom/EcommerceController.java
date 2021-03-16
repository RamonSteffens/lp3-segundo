package br.ifsul.lp3.ecom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("ecommerce")
public class EcommerceController {

    @Autowired
    private ProdutoRepository produtoRepository;

//	@PostMapping
//	public ResponseEntity<Produto> cadastrar(@RequestBody Produto f) {
//		if(f != null && f.getTitulo() != null) {
//			f = produtoRepository.save( f );
//			return ResponseEntity.ok(f);
//		}
//		else {
//			return ResponseEntity.noContent().build();
//		}
//	}

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestParam String nome, @RequestParam Date dataCriacao,
                                             @RequestParam Double valor, @RequestParam Integer estoque) {
        Produto f = new Produto();
        f.setNome(nome);
        f.setDataCriacao(dataCriacao);
        f.setValor(valor);
        f.setEstoque(estoque);
        f = produtoRepository.save(f);
        return ResponseEntity.ok(f);
    }

    @GetMapping(path = {"", "{pagina}"})
    @ResponseBody
    public List<Produto> listar(@PathVariable(required = false) Integer pagina) {
        if (pagina != null) {
            return produtoRepository.findAll(PageRequest.of(pagina, 2)).getContent();
        } else {
            return produtoRepository.findAll();
        }
    }

    @GetMapping(path = "/produtos")
    @ResponseBody
    public List<Produto> listar(@RequestParam(name = "nome") String nome) {
            return produtoRepository.findByNome(nome);
    }

    @GetMapping(path = "/produto/{id}")
    @ResponseBody
    public Produto buscaProduto(@PathVariable Integer id) {
        return produtoRepository.findById(id).orElse(null);
    }
}
