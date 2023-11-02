package com.example.Loja.controller

import com.example.Loja.dtos.ProdutoDTO
import com.example.Loja.dtos.ProdutoResponseDTO
import com.example.Loja.service.ProdutoService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/produtos")
class ProdutoController (private val service: ProdutoService) {

    @GetMapping
    fun listar():List<ProdutoResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ProdutoResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastra(@RequestBody @Valid dto: ProdutoDTO,
                 uriBuilder: UriComponentsBuilder
    ): ResponseEntity<ProdutoResponseDTO> {
        val produtoResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/produtos/${produtoResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(produtoResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid dto: ProdutoDTO
    ): ProdutoResponseDTO {
        return service.atualizar(id, dto)
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }


}