package com.example.tiendaotaku.servicio;


import com.example.tiendaotaku.model.ProductoOtaku;
import com.example.tiendaotaku.repositorio.ProductoOtakuRepositorio;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductoOtakuService {
    @Autowired
    private ProductoOtakuRepositorio productoOtakuRepositorio;

    public List<ProductoOtaku> getAllProductoOtaku() {
        return productoOtakuRepositorio.findAll();
    }

    public ProductoOtaku getProductoOtakuById(Long id) {
        return productoOtakuRepositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto con ID " + id + " no encontrado"));
    }


    public ProductoOtaku createProducto(ProductoOtaku productoOtaku) {
        return productoOtakuRepositorio.save(productoOtaku);
    }

    public void deleteProducto(Long id) {
        if (!productoOtakuRepositorio.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto con ID " + id + " no encontrado");
        }
        productoOtakuRepositorio.deleteById(id);
    }


    public ProductoOtaku updateProducto(Long id, ProductoOtaku productoActualizado) {
        ProductoOtaku productoExistente = productoOtakuRepositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto con ID " + id + " no encontrado"));

        productoExistente.setNombre(productoActualizado.getNombre());
        productoExistente.setCategoria(productoActualizado.getCategoria());
        productoExistente.setPrecio(productoActualizado.getPrecio());
        productoExistente.setStock(productoActualizado.getStock());

        return productoOtakuRepositorio.save(productoExistente);
    }


    @PostConstruct
    public void cargarProductosIniciales() {
        productoOtakuRepositorio.save(new ProductoOtaku("Figura de Luffy", "Figura", 35, 5));
        productoOtakuRepositorio.save(new ProductoOtaku("Manga de Naruto", "Manga", 24, 25));
        productoOtakuRepositorio.save(new ProductoOtaku("Póster de One Piece", "Póster", 30, 10));
    }


}
