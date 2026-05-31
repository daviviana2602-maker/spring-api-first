package br.com.davi.spring_boot_first.controllers;

import br.com.davi.spring_boot_first.database.entity.ProdutoEntity;
import br.com.davi.spring_boot_first.service.EditarService;
import br.com.davi.spring_boot_first.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController   // diz que é uma API REST (retorna JSON/texto direto)
@RequestMapping("/v1/produto")    // prefix com versão
@RequiredArgsConstructor    // Pega todos os private final e joga dentro do construtor


public class ProdutoController {


    private final ProdutoService produtoService;    // produtoService é o retorno da classe ProdutoService


    @GetMapping("/listar")
    public List<ProdutoEntity> listar(){
        return produtoService.getProdutos();    // retorna a resposta do getProdutos
    }


    @PutMapping("/editar")
    public int editarQuantidade(@RequestParam(value = "id") int id, @RequestParam(value = "quantidade") int quantidade){
        return EditarService.editar(id, quantidade);
    }


}
