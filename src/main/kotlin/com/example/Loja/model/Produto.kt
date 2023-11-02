package com.example.Loja.model

import jakarta.persistence.*

@Entity
data class Produto(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val preco: String,
    val descricao: String
)