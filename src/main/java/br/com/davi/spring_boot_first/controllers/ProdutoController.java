package br.com.davi.spring_boot_first.controllers;

import br.com.davi.spring_boot_first.database.entity.ProdutoEntity;
import br.com.davi.spring_boot_first.dto.request.CriarProdutoRequest;
import br.com.davi.spring_boot_first.dto.request.EditarProdutoRequest;
import br.com.davi.spring_boot_first.dto.response.CriarProdutoResponse;
import br.com.davi.spring_boot_first.dto.response.EditarProdutoResponse;
import br.com.davi.spring_boot_first.service.CriarProdutoService;
import br.com.davi.spring_boot_first.service.EditarService;
import br.com.davi.spring_boot_first.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController   // diz que é uma API REST (retorna JSON direto)
@RequestMapping("/v1/produto")    // prefix com versão
@RequiredArgsConstructor    // Pega todos os private final e joga dentro do construtor


public class ProdutoController {


    private final ProdutoService produtoService;                // objeto do ProdutoService fornecido pelo Spring
    private final EditarService editarService;                  // objeto do EditarService fornecido pelo Spring
    private final CriarProdutoService criarProdutoService;      // objeto do CriarProdutoService fornecido pelo Spring


    @GetMapping("/listar")
    public List<ProdutoEntity> listar(){
        return produtoService.getProdutos();
    }


    @PutMapping("/editar")
    public EditarProdutoResponse editarQuantidade(
            @RequestBody EditarProdutoRequest editarProdutoRequest      // dados da requisição convertidos para objeto
    )
    {
        return editarService.editar(
            editarProdutoRequest.getId(),
            editarProdutoRequest.getQuantidade());
    }


    @PostMapping("/criar")
    public CriarProdutoResponse criarProduto(
        @RequestBody CriarProdutoRequest criarProdutoRequest      // dados da requisição convertidos para objeto
    )
    {
        return criarProdutoService.criarNovoProduto(
            criarProdutoRequest.getName(),
            criarProdutoRequest.getPreco(),
            criarProdutoRequest.getQuantidade());
    }

}

