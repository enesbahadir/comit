package com.comit.controller;

import com.comit.model.Product;
import com.comit.service.ProductService;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    //@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/products")
    public Product createUser(@RequestBody Product newProduct)
    {
        return productService.createProduct(newProduct);
                /*EntityModel.of(newProduct,
                linkTo(methodOn(RegisterController.class).getPreschoolById(newPreschool.getId())).withSelfRel(),
                linkTo(methodOn(RegisterController.class).listOfPreschools()).withRel("preschools"));*/
    }


    //@CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/products/{id}")
    public Product updateProduct (@RequestBody Product newProduct, @PathVariable Integer id)
    {
        return productService.updateProduct(newProduct, id);

    }

    @DeleteMapping("/products/{id}")
    //@CrossOrigin(origins = "http://localhost:4200")
    void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }

    @GetMapping("products")
    //@CrossOrigin(origins = "http://localhost:4200")
    public List<Product> getProducts()
    {
        return productService.getProducts();
    }

    @GetMapping("/products/{id}")
    //@CrossOrigin(origins = "http://localhost:4200")
    public Product getProduct(@PathVariable Integer id)
    {
        return productService.getProductById(id);
    }

    @GetMapping("products/page")
    @ResponseBody
    //@CrossOrigin(origins = "http://localhost:4200")
    public List<Product> findAllPaginatedProducts(@RequestParam("pageNumber") int pageNumber) {
        Page<Product> resultPage = productService.getPaginatedProducts(pageNumber);
        return resultPage.getContent();
    }

    @GetMapping("products/search")
    //@CrossOrigin(origins = "http://localhost:4200")
    public List<Product> findAllSearchedProducts(@RequestParam("search") String keyword) {
        return productService.getProdcuts(keyword);
    }
}
