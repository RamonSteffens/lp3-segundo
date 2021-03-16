Tema: Ecommerce
Produto:
{
"id": Integer,
"data_criacao": Date,
"nome": String,
"valor": BigDecimal,
"estoque": Integer,
"ativo": Boolean
}

Repository<Produto, Long>:

Optional<Produto> findById(Long id);
List<Produto> findByNome(String nome);

POST - Cadastrar um produto
GET - Buscar um produto por um ID
GET (ALL) - Buscar todos os produtos
GET (NOME) - Buscar produtos pelo nome