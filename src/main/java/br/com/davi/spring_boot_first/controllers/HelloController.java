package br.com.davi.spring_boot_first.controllers;

import org.springframework.web.bind.annotation.*;


@RestController   // diz que é uma API REST (retorna JSON/texto direto)
@RequestMapping("/v1/hello")    // prefix com versão

public class HelloController {


    @GetMapping("/{id}")
    public String pegarId(@PathVariable("id") String id) {    // pega o param id e coloca na variável id
        return "Hello World " + id;
    }


    @GetMapping("/name")
    public String pegarNome(@RequestParam(value = "name", required = false) String name) {    // nome é obrigatório por default
        return "fala " + name;
    }


    @PostMapping("/criar")
    public String createUser(@RequestBody String user){    // recebe dados JSON do corpo da requisição e transforma em User
        return "createUser: " + user;
    }

}
