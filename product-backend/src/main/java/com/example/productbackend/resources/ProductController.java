package com.example.productbackend.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.productbackend.models.Product;

@RestController
@CrossOrigin

public class ProductController {

    private List<Product> products = new ArrayList<>();

    @PostMapping("products")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        product.setId(products.size() + 1);
        products.add(product);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();

        return ResponseEntity.created(location).body(product);

    }

    @GetMapping("products/{id}")

    public ResponseEntity<Product> getProduct(@PathVariable int id) {

        Product prod = products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        return ResponseEntity.ok(prod);
    }

    @GetMapping("products")
    public List<Product> getProducts() {

        return products;
    }
}

// public Product(int id, String name, String description, boolean promotion,
// boolean newProduct, int idCategory,
// double price)

// if( id <= products.size()){
// return ResponseEntity.ok(products.get(id - 1 ));
// }else{
// throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found");
// }

// Arrays.asList(
// new Product(1, "RTX 4090", "Description 01", false, false, 1, 5090.90),
// new Product(2, "RTX 2090", "Description 02", true, true, 2, 2090.90),
// new Product(3, "RTX 3090", "Description 03", false, true, 3, 5390.90),
// new Product(4, "RTX 4090", "Description 04", true, false, 4, 4090.90));
// @PostConstruct
// public void init() {
// Product obj = new Product(1, "RTX 4090", 5090.90);
// Product obj2 = new Product(2, "RTX 2090",2090.9);
// Product obj3 = new Product(3,"RTX 3090", 5390.90);
// Product obj4 = new Product(4, "RTX 4090", 4090.90);
// products.add(obj);
// products.add(obj2);
// products.add(obj3);
// products.add(obj4);

// }