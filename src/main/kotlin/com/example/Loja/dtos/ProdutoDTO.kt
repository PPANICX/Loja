package com.example.Loja.dtos

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty

data class ProdutoDTO(
    @field:NotEmpty(message = "O produto deve ter um Nome")
    val nome: String,
    @field:NotEmpty(message = "O produto deve ter um Preço")
    val preco: String,
    @field:NotEmpty(message = "O produto deve ter uma Descrição")
    val descricao: String
)
