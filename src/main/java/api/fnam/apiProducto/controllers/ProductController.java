package api.fnam.apiProducto.controllers;

import api.fnam.apiProducto.model.Product;
import api.fnam.apiProducto.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/${spring.nameApi}/${spring.version}/product")
@Tag(name = "Product Controller", description = "Controlador para gestionar productos")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Crear un producto", description = "Recibe un objeto Product en JSON y lo guarda en la base de datos")
    @ApiResponse(responseCode = "200", description = "Producto creado correctamente",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)))
    @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @Operation(summary = "Listar los productos", description = "Devuelve una lista con todos los productos")
    @ApiResponse(responseCode = "200", description = "Productos listados correctamente",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)))
    @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    @GetMapping("/getAll")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
    
    @Operation(summary = "Buscar un producto por su id", description = "Recibe un id y devuelve el producto correspondiente")
    @ApiResponse(responseCode = "200", description = "Producto encontrado",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)))
    @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    @GetMapping("/getById/{id}")
    public Product getById(@PathVariable int id){
        return productService.findById(id);
    }

    @Operation(summary = "Buscar un producto por su nombre", description = "Recibe un nombre y devuelve los productos que coincidan")
    @ApiResponse(responseCode = "200", description = "Productos encontrados",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)))
    @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    @GetMapping("/searchByName/{name}")
    public List<Product> searchByName(@PathVariable String name){
        return productService.searchByName(name);
    }

    @Operation(summary = "Eliminar un producto", description = "Recibe un id y elimina el producto correspondiente")
    @ApiResponse(responseCode = "200", description = "Producto eliminado correctamente",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)))
    @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id){
        return productService.deleteProduct(id);
    }

    @Operation(summary = "Actualizar un producto", description = "Recibe un objeto Product en JSON y lo actualiza en la base de datos")
    @ApiResponse(responseCode = "200", description = "Producto actualizado correctamente",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)))
    @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }
}
