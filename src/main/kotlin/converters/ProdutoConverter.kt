package convertersimport

import com.example.Loja.model.Produto
import dtos.ProdutoDTO
import org.springframework.stereotype.Component


@Component
    class ProdutoConverter {

fun toProduto(dto: ProdutoDTO): Produto{

            return Produto(
                nome = dto.nome,
                preco = dto.preco,
                descricao = dto.descricao
            )
        }
    }