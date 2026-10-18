package com.ecom.product_service.controller;


import com.ecom.product_service.dto.ProductRequestDto;
import com.ecom.product_service.dto.ProductResponseDto;
import com.ecom.product_service.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto) {
        return productService.createProduct(productRequestDto);
    }
    @GetMapping("/{productId}")
    public ProductResponseDto getProductById(@PathVariable String productId) {
        return productService.getProductById(productId);
    }
    @GetMapping
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAllProducts();
    }
    @PatchMapping("/{productId}/stock")
    public ProductResponseDto updateStock(@PathVariable String productId, @RequestParam Integer stockQuantity) {
        return productService.updateStock(productId, stockQuantity);
    }
    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable String productId) {
        return productService.deleteProduct(productId);

    }

}

//
//E-commerce APIs — Postman Sequence
//1. Create Category
//
//POST http://localhost:8080/categories
//
//Body → raw → JSON
//
//{
//    "categoryName": "Electronics",
//        "description": "Electronic products"
//}
//2. Get All Categories
//
//GET http://localhost:8080/categories
//
//Parameters: None.
//
//3. Create Product
//
//POST http://localhost:8081/products
//
//        {
//        "name": "Samsung Mobile",
//        "description": "Android smartphone",
//        "price": 25000,
//        "stockQuantity": 10,
//        "categoryId": 1
//        }
//        4. Get All Products
//
//GET http://localhost:8081/products
//
//Parameters: None.
//
//5. Get Product by ID
//
//GET http://localhost:8081/products/PROD001
//
//Path parameter: productId = PROD001
//
//6. Create Order
//
//POST http://localhost:8082/orders
//
//        {
//        "productId": "PROD001",
//        "quantity": 2
//        }
//        7. Get Order Details
//
//GET http://localhost:8082/orders/ORDER001
//
//Path parameter: orderId = ORDER001
//
//8. Process Payment
//
//POST http://localhost:6002/payments
//
//        {
//        "orderId": "ORDER001"
//        }
//        9. Verify Order Status
//
//GET http://localhost:8082/orders/ORDER001
//
//Parameters: Use the actual order ID returned by the Create Order API.
//
//        Flow: Category → Product → Order → Payment → Verify Status.