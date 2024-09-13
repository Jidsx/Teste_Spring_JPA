package com.example.ac1.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac1.models.Categoria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaProdutoRepository {
    @Autowired
    private EntityManager entityManager;

    // Salvar
    @Transactional
    public Categoria salvar(Categoria categoria) {
        categoria = entityManager.merge(categoria);
        return categoria;
    }

    // Excluir
    @Transactional
    public void excluir(Categoria categoria) {
        entityManager.remove(categoria);
    }

    // Obter Todos
    public List<Categoria> obterTodos() {
        return entityManager
                .createQuery("from Categoria", Categoria.class).getResultList();
    }

    // Obter por id
    public List<Categoria> obterPorId(int id) {
        String jpql = " select c from tbl_categoria c where c.id like :id";
        TypedQuery<Categoria> query = entityManager.createQuery(jpql, Categoria.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

}
