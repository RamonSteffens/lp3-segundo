package br.ifsul.lp3.ecom.entity;

import br.ifsul.lp3.ecom.dto.ProdutoExportadoDTO;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@JsonDeserialize
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Date dataCriacao;

    private Double valor;

    private Integer estoque;

    private String imagem;

    private Boolean alcoolico;

    private String ean;

    private String marca;

    private Date dataUltimaAtualização;

    private String descricao;

    public Produto(Integer id, String nome, Date dataCriacao, Double valor, Integer estoque, String imagem, Boolean alcoolico, String ean, String marca, Date dataUltimaAtualização, String descricao) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.valor = valor;
        this.estoque = estoque;
        this.imagem = imagem;
        this.alcoolico = alcoolico;
        this.ean = ean;
        this.marca = marca;
        this.dataUltimaAtualização = dataUltimaAtualização;
        this.descricao = descricao;
    }

    public Produto(String nome, Date dataCriacao, Double valor, Integer estoque, String imagem, Boolean alcoolico, String ean, String marca, Date dataUltimaAtualização, String descricao) {
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.valor = valor;
        this.estoque = estoque;
        this.imagem = imagem;
        this.alcoolico = alcoolico;
        this.ean = ean;
        this.marca = marca;
        this.dataUltimaAtualização = dataUltimaAtualização;
        this.descricao = descricao;
    }

    public Produto() {
    }

    public static Produto buildByExportadoDTO(ProdutoExportadoDTO produto) {
        String nome = produto.getNome();
        Date dataCriacao = produto.getDataCriacao();
        Double valor = produto.getValor();
        Integer estoque = produto.getEstoque();
        String imagem = produto.getImagem();
        Boolean alcoolico = produto.getAlcoolico();
        String ean = produto.getEan();
        String marca = produto.getMarca();
        Date dataUltimaAtualização = produto.getDataUltimaAtualização();
        String descricao = produto.getDescricao();

        return new Produto(nome, dataCriacao, valor, estoque, imagem,
                alcoolico, ean, marca, dataUltimaAtualização, descricao);
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String titulo) {
        this.nome = titulo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Boolean getAlcoolico() {
        return alcoolico;
    }

    public void setAlcoolico(Boolean alcoolico) {
        this.alcoolico = alcoolico;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getDataUltimaAtualização() {
        return dataUltimaAtualização;
    }

    public void setDataUltimaAtualização(Date dataUltimaAtualização) {
        this.dataUltimaAtualização = dataUltimaAtualização;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
