package api.fnam.apiProducto.services;

import api.fnam.apiProducto.model.Product;
import api.fnam.apiProducto.repository.RepositoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private RepositoryProduct repositoryProduct;

    // Metodo para guardar un producto
    public Product saveProduct(Product product){
        return repositoryProduct.addProduct(product);
    }

    // Metodo para obtener todos los productos
    public List<Product> getProducts(){
        return repositoryProduct.getProducts();
    }

    // Metodo para buscar un producto por su id
    public Product findById(int id) {
        return repositoryProduct.findById(id);
    }

    // Metodo para buscar un producto por su nombre
    public List<Product> searchByName(String name){
        return repositoryProduct.searchByName(name);
    }

    // Metodo para eliminar un producto
    public String deleteProduct(Integer id){
        return repositoryProduct.delete(id);
    }

    // Metodo para actualizar un producto
    public Product updateProduct(Product product){
        return repositoryProduct.updateProduct(product);
    }
}
