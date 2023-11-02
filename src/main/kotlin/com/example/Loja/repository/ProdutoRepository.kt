package com.example.Loja.repository

import com.example.Loja.model.Produto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface ProdutoRepository: JpaRepository<Produto, Long> {

    fun findByNome(nomeProduto: String, paginacao: Pageable): Page<Produto>

}