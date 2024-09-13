package com.example.ac1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_produtos")
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 200, nullable = false)
    private String prodNome;
    @Column(nullable = false)
    private Integer prodQtd;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false) 
    private Categoria categoria;

    public Produtos() {
    }

    public Produtos(int id, String prodNome, Integer prodQtd, Categoria categoria) {
        this.id = id;
        this.prodNome = prodNome;
        this.prodQtd = prodQtd;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdNome() {
        return prodNome;
    }

    public void setProdNome(String prodNome) {
        this.prodNome = prodNome;
    }

    public Integer getProdQtd() {
        return prodQtd;
    }

    public void setProdQtd(Integer prodQtd) {
        this.prodQtd = prodQtd;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Produtos [id=" + id + ", prodNome=" + prodNome + ", prodQtd=" + prodQtd + ", categoria=" + categoria
                + "]";
    }
    
}
