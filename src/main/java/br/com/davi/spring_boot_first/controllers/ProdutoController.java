package br.com.davi.spring_boot_first.controllers;

import br.com.davi.spring_boot_first.dto.request.CriarProdutoRequest;
import br.com.davi.spring_boot_first.dto.request.EditarProdutoRequest;
import br.com.davi.spring_boot_first.dto.response.CriarProdutoResponse;
import br.com.davi.spring_boot_first.dto.response.EditarProdutoResponse;
import br.com.davi.spring_boot_first.dto.response.ListarProdutoResponse;
import br.com.davi.spring_boot_first.service.CriarProdutoService;
import br.com.davi.spring_boot_first.service.DeletarProdutoService;
import br.com.davi.spring_boot_first.service.EditarProdutoService;
import br.com.davi.spring_boot_first.service.ListarProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController   // diz que é uma API REST (retorna JSON direto)
@RequestMapping("/v1/produto")    // prefix com versão
@RequiredArgsConstructor    // Pega todos os private final e joga dentro do construtor


public class ProdutoController {

    private final CriarProdutoService criarProdutoService;
    private final ListarProdutoService listarProdutoService;
    private final EditarProdutoService editarProdutoService;
    private final DeletarProdutoService deletarProdutoService;



    @PostMapping("/criar")
    public CriarProdutoResponse criarProduto(
            @Valid @RequestBody CriarProdutoRequest criarProdutoRequest      // dados da requisição convertidos para objeto
    )
    {
        return criarProdutoService.criarNovoProduto(
            criarProdutoRequest.getName(),
            criarProdutoRequest.getPreco(),
            criarProdutoRequest.getQuantidade());
    }


    @GetMapping("/listar")
    public List<ListarProdutoResponse> listar(){
        return listarProdutoService.listarProdutos();
    }


    @PutMapping("/editar")
    public EditarProdutoResponse editarQuantidade(
        @RequestBody EditarProdutoRequest editarProdutoRequest      // dados da requisição convertidos para objeto
    )
    {
        return editarProdutoService.editar(
            editarProdutoRequest.getId(),
            editarProdutoRequest.getNome(),
            editarProdutoRequest.getPreco(),
            editarProdutoRequest.getQuantidade());
    }


    @DeleteMapping("/{id}")
    public Long removerProduto(
        @PathVariable Long id
    )
    {
        return deletarProdutoService.deletarProduto(id);
    }

}

