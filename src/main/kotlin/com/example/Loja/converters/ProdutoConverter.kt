package com.example.Loja.converters

import com.example.Loja.dtos.ProdutoResponseDTO
import com.example.Loja.model.Produto
import org.springframework.stereotype.Component


@Component
class ProdutoConverter {

    fun toProduto(dto: com.example.Loja.dtos.ProdutoDTO): Produto{
        return Produto(
            nome= dto.nome,
            preco = dto.preco,
            descricao = dto.descricao
        )
    }

    fun toProdutoResponseDTO(produto: Produto): ProdutoResponseDTO{
        return ProdutoResponseDTO(
            id = produto.id,
            nome = produto.nome,
            preco = produto.preco,
            descricao = produto.descricao
        )
    }
}