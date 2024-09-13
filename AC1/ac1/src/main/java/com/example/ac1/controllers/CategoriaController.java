package com.example.ac1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac1.models.Categoria;
import com.example.ac1.repository.CategoriaProdutoRepository;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaProdutoRepository categoriaproduto;

    @GetMapping()
    public List<Categoria> getCategoria() {
        return categoriaproduto.obterTodos();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void postCategoria(@RequestBody Categoria categoria) {
        categoriaproduto.salvar(categoria);
    }
}
