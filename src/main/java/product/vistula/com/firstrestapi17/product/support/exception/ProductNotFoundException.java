package product.vistula.com.firstrestapi17.product.support.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super();String.format("Product with id %d not found",id);
    }
}
