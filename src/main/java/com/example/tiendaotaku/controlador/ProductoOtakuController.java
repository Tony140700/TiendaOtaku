package com.example.tiendaotaku.controlador;

import com.example.tiendaotaku.model.ProductoOtaku;
import com.example.tiendaotaku.servicio.ProductoOtakuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/productos")
public class ProductoOtakuController {

    @Autowired
    ProductoOtakuService productoOtakuService;

    @Operation(summary = "Obtener todos los productos")
    @ApiResponse(responseCode = "200", description = "Lista de productos encontrada con éxito")
    @GetMapping
    public List<ProductoOtaku> getAllProductos() {
        return productoOtakuService.getAllProductoOtaku();
    }

    @Operation(summary = "Obtener producto por id")
    @ApiResponse(responseCode = "200", description = "Producto encontrado con exito")
    @ApiResponse(responseCode = "404", description = "Producto no encontrado")

    @GetMapping("/{id}")
    public ProductoOtaku obtenerPorId(@PathVariable Long id) {
        return productoOtakuService.getProductoOtakuById(id);
    }


    @Operation(summary = "Crear un nuevo producto")
    @ApiResponse(responseCode = "200", description = "Producto creado correctamente")
    @ApiResponse(responseCode = "400", description = "Producto no creado por error de validación")
    @PostMapping
    public ProductoOtaku crearProducto(@Valid @RequestBody ProductoOtaku producto) {
        return productoOtakuService.createProducto(producto);
    }

    @Operation(summary = "Actualizar un producto existente")
    @ApiResponse(responseCode = "200", description = "Producto actualizado")
    @ApiResponse(responseCode = "404", description = "Producto no encontrado correctamnte")
    @ApiResponse(responseCode = "400", description = "Producto no actualizado por error de validación")
    @PutMapping("/{id}")
    public ProductoOtaku actualizarProducto(@PathVariable Long id, @Valid @RequestBody ProductoOtaku producto) {
        return productoOtakuService.updateProducto(id, producto);
    }

    @Operation(summary = "Eliminar un producto")
    @ApiResponse(responseCode = "204", description = "Producto eliminado")
    @ApiResponse(responseCode = "404", description = "Producto no eliminado correctamete")
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoOtakuService.deleteProducto(id);
    }


}
