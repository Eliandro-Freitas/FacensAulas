package com.example.aula3.repository;

import java.util.List;

import com.example.aula3.entity.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProdutoRepository extends JpaRepository<Produto,Integer>{
    @Query("select p from tb_produto p left join fetch p.usuarios where p.prod_nome = :nome")
    List<Produto> findProdutoByName(@Param("nome") int nome);

    @Query(value = "SELECT top 10 * FROM tb_produto", nativeQuery = true)
    List<Produto> findTopProdutos();

    @Query(value = "SELECT * FROM tb_produto ORDER BY NAME ASC", nativeQuery = true)
    List<Produto> findAllOrderByProd_nomeAsc();

    @Query(value = "SELECT top 10 * FROM tp_produto ORDER BY prod_qtd", nativeQuery = true)
    List<Produto> findTopTeenProdutosWithQuantity();
}