package com.example.ac1.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac1.models.Produtos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ProdutoRepository {
    @Autowired
    private EntityManager entityManager;

    // Salvar
    @Transactional
    public Produtos salvar(Produtos produtos) {
        produtos = entityManager.merge(produtos);
        return produtos;
    }

    // Excluir
    @Transactional
    public void excluir(Produtos produtos) {
        entityManager.remove(produtos);
    }

    // Obter Todos
    public List<Produtos> obterTodos() {
        return entityManager
                .createQuery("from Produtos", Produtos.class).getResultList();
    }

    // Obter por id
    public List<Produtos> obterPorId(int id) {
        String jpql = " select p from tbl_produtos p where p.id like :id";
        TypedQuery<Produtos> query = entityManager.createQuery(jpql, Produtos.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
}
