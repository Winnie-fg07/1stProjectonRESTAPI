package product.vistula.com.firstrestapi17.product.api.request;

public class UpdateProductRequest extends ProductRequest {
    private final long id;
    public UpdateProductRequest(String name, long id) {
        super(name);
        this.id = id;
    }
    public long getId() {return id;}
}
