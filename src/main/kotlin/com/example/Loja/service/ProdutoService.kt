package com.example.Loja.service

import com.example.Loja.converters.ProdutoConverter
import com.example.Loja.dtos.ProdutoDTO
import com.example.Loja.dtos.ProdutoResponseDTO
import com.example.Loja.exceptions.NotFoundException
import com.example.Loja.model.Produto
import com.example.Loja.repository.ProdutoRepository
import org.springframework.stereotype.Service

private const val PRODUTO_NOT_FOUND_MESSAGE = "Produto não foi encontrado!"

@Service
class ProdutoService (private val repository: ProdutoRepository,
                      val converter: ProdutoConverter) {

    fun listar(): List<ProdutoResponseDTO> {
        return repository.findAll().map(converter::toProdutoResponseDTO)
    }

    fun buscarPorId(id: Long): ProdutoResponseDTO{
        val produto = repository
            .findById(id).orElseThrow { NotFoundException(PRODUTO_NOT_FOUND_MESSAGE) }
        return converter.toProdutoResponseDTO(produto)


    }

    fun cadastrar(dto: ProdutoDTO): ProdutoResponseDTO {
        return converter.toProdutoResponseDTO(
            repository.save(converter.toProduto(dto))
        )
    }

    fun atualizar(id: Long, dto: ProdutoDTO): ProdutoResponseDTO {
        val produto = repository.findById(id)
            .orElseThrow { NotFoundException(PRODUTO_NOT_FOUND_MESSAGE) }
            .copy(
                nome = dto.nome,
                preco = dto.preco,
                descricao = dto.descricao
            )
        return converter.toProdutoResponseDTO(repository.save(produto))    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}


