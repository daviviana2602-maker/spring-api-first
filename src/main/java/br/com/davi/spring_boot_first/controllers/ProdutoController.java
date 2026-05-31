package br.com.davi.spring_boot_first.controllers;

import br.com.davi.spring_boot_first.database.entity.ProdutoEntity;
import br.com.davi.spring_boot_first.dto.request.ProdutoRequest;
import br.com.davi.spring_boot_first.dto.response.ProdutoResponse;
import br.com.davi.spring_boot_first.service.EditarService;
import br.com.davi.spring_boot_first.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController   // diz que é uma API REST (retorna JSON/texto direto)
@RequestMapping("/v1/produto")    // prefix com versão
@RequiredArgsConstructor    // Pega todos os private final e joga dentro do construtor


public class ProdutoController {


    private final ProdutoService produtoService;    // objeto do ProdutoService fornecido pelo Spring
    private final EditarService editarService;      // objeto do EditarService fornecido pelo Spring


    @GetMapping("/listar")
    public List<ProdutoEntity> listar(){
        return produtoService.getProdutos();
    }


    @PutMapping("/editar")
    public ProdutoResponse editarQuantidade(
            @RequestBody ProdutoRequest produtoRequest  // dados da requisição convertidos para objeto
    )
    {
        return editarService.editar(        // passando parametros
                produtoRequest.getId(),
                produtoRequest.getQuantidade());
    }


}
