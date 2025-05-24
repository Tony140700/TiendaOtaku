package com.example.tiendaotaku.repositorio;


import com.example.tiendaotaku.model.ProductoOtaku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoOtakuRepositorio extends JpaRepository<ProductoOtaku, Long> {
}


