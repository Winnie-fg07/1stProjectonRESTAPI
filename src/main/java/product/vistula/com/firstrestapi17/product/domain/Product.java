package product.vistula.com.firstrestapi17.product.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name="products")
public class Product {

    @Id
    @GeneratedValue
    private Long Id;
    private String name;

    public Product(String name) { this.name = name; }

    public Product() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
