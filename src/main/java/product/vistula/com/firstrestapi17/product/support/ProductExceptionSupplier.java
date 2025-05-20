package product.vistula.com.firstrestapi17.product.support;

import product.vistula.com.firstrestapi17.product.support.exception.ProductNotFoundException;

import java.util.function.Supplier;

public class ProductExceptionSupplier {
    public static Supplier<ProductNotFoundException> productNotFound(Long id){
        return () -> new ProductNotFoundException(id);
    }
}
