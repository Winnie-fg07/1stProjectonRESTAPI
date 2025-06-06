package product.vistula.com.firstrestapi17.product.api.response;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import product.vistula.com.firstrestapi17.product.api.request.ProductRequest;
import product.vistula.com.firstrestapi17.product.api.request.UpdateProductRequest;
import product.vistula.com.firstrestapi17.product.api.response.ProductResponse;
import product.vistula.com.firstrestapi17.product.service.ProductService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.create(productRequest);
        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find product by ID")
    public ResponseEntity<ProductResponse> find(@PathVariable Long id) {
        ProductResponse productResponse = productService.find(id);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }
        @PutMapping("/{id}")
                @Operation(summary = "Update product")
        public ResponseEntity<ProductResponse> update(@PathVariable Long id, @RequestBody UpdateProductRequest updateProductRequest) {
            ProductResponse productResponse = productService.update(id,updateProductRequest);
            return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

    @GetMapping
    @Operation(summary = "Find all products")
    public ResponseEntity<List<ProductResponse>> findAll() {
        List<ProductResponse> productResponse = productService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Delete Item")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
