package api.fnam.apiProducto.repository;

import api.fnam.apiProducto.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RepositoryProduct {

    private List<Product> products = new ArrayList<>();

    public RepositoryProduct(){
        createProduct();
    }

    // Metodo para crear productos de prueba
    public void createProduct(){
        products.add(new Product(1, "Product 1", 10, 100.0));
        products.add(new Product(2, "Product 2", 20, 200.0));
        products.add(new Product(3, "Product 3", 30, 300.0));
        products.add(new Product(4, "Product 4", 40, 400.0));
        products.add(new Product(5, "Product 5", 50, 500.0));
    }

    // Metodo para obtener todos los productos
    public List<Product> getProducts(){
        return products;
    }

    // Metodo para buscar un producto por su id
    public Product findById(int id){
        for(int i= 0; i < products.size(); i++){
            if(products.get(i).getId() == id){
                return products.get(i);
            }
        }
        return null;
    }

    // Metodo para buscar un producto por su nombre
    public List<Product> searchByName(String name){
        return products.stream()
                .filter(x -> x.getName().startsWith(name))
                .collect(Collectors.toList());
    }

    // Metodo para agregar un producto
    public Product addProduct(Product product){
        products.add(product);
        return product;
    }

    // Metodo para eliminar un producto
    public String delete(Integer id) {
        products.removeIf(x -> x.getId() == id);
        return "Producto eliminado";
    }

    // Metodo para actualizar un producto
    public Product  updateProduct(Product product){
        for(int i= 0; i < products.size(); i++){
            if(products.get(i).getId() == product.getId()){
                products.get(i).setName(product.getName());
                products.get(i).setCount(product.getCount());
                products.get(i).setPrice(product.getPrice());
                return products.get(i);
            }
        }
        return null;
    }
}
