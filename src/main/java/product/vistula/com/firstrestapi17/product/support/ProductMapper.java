package product.vistula.com.firstrestapi17.product.support;

import org.springframework.stereotype.Component;
import product.vistula.com.firstrestapi17.product.api.request.UpdateProductRequest;
import product.vistula.com.firstrestapi17.product.domain.Product;
import product.vistula.com.firstrestapi17.product.api.request.ProductRequest;
import product.vistula.com.firstrestapi17.product.api.response.ProductResponse;

@Component
public class ProductMapper {

    public Product toProduct(ProductRequest productRequest) {
        return new Product(productRequest.getName());
    }

    public Product toProduct(Product product,UpdateProductRequest updateProductRequest) {
        product.setName(updateProductRequest.getName());
        return product;
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName());
    }
}