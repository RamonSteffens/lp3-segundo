package br.ifsul.lp3.ecom.dto;

import br.ifsul.lp3.ecom.entity.Produto;

public class ProdutoDTO {

    private String nome;

    private Double valor;

    private String ean;

    public ProdutoDTO(String nome, Double valor, String ean) {
        this.nome = nome;
        this.valor = valor;
        this.ean = ean;
    }

    public ProdutoDTO() {
    }

    public static ProdutoDTO buildByProduct(Produto produto) {
        String nome = produto.getNome();
        String ean = produto.getEan();
        Double valor = produto.getValor();

        return new ProdutoDTO(nome, valor, ean);
    }

    @Override
    public String toString() {
        return "ProdutoDTO{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", ean='" + ean + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }
}
