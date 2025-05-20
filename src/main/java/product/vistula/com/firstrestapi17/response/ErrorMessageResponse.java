package product.vistula.com.firstrestapi17.response;

public class ErrorMessageResponse {
    private final String message;

    public ErrorMessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
