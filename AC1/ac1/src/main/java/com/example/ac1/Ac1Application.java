package com.example.ac1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac1.models.Categoria;
import com.example.ac1.models.Produtos;
import com.example.ac1.repository.CategoriaProdutoRepository;
import com.example.ac1.repository.ProdutoRepository;

@SpringBootApplication
public class Ac1Application {

	@Bean
	public CommandLineRunner init(
			@Autowired CategoriaProdutoRepository categoriaRepository,
			@Autowired ProdutoRepository produtoRepository) {
		return args -> {
			System.out.println("=== CRIANDO AS CATEGORIAS ===");
			Categoria c1 = categoriaRepository.salvar(
					new Categoria(0, "Teste1", "Teste1"));

			Categoria c2 = categoriaRepository.salvar(
					new Categoria(0, "Teste2", "Teste2"));

			List<Categoria> listaCategorias = categoriaRepository.obterTodos();
			listaCategorias.forEach(System.out::println);

			System.out.println("=== CRIANDO OS PRODUTOS ===");
			produtoRepository.salvar(
					new Produtos(0, "TestedoTeste1", 10, c1));
					produtoRepository.salvar(
					new Produtos(0, "TestedoTeste2", 20, c2));
			List<Produtos> listaProdutos = produtoRepository.obterTodos();
			listaProdutos.forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);
	}

}
