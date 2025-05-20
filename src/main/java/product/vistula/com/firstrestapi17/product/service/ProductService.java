package product.vistula.com.firstrestapi17.product.service;

import org.springframework.stereotype.Service;
import product.vistula.com.firstrestapi17.product.api.request.UpdateProductRequest;
import product.vistula.com.firstrestapi17.product.domain.Product;
import product.vistula.com.firstrestapi17.product.api.request.ProductRequest;
import product.vistula.com.firstrestapi17.product.api.response.ProductResponse;
import product.vistula.com.firstrestapi17.product.repository.ProductRepository;
import product.vistula.com.firstrestapi17.product.support.ProductExceptionSupplier;
import product.vistula.com.firstrestapi17.product.support.ProductMapper;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductResponse create(ProductRequest productRequest) {
    Product product = productRepository.save(productMapper.toProduct(productRequest));
    return productMapper.toProductResponse(product);
    }

    public ProductResponse find(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));
        return productMapper.toProductResponse(product);
    }
    public ProductResponse update(Long id, UpdateProductRequest updateProductRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));
        productRepository.save(productMapper.toProduct(product, updateProductRequest));
        return productMapper.toProductResponse(product);
    }
    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream().map(productMapper::toProductResponse).collect(Collectors.toList());
    }

    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));
        productRepository.deleteById(product.getId());
    }

}

