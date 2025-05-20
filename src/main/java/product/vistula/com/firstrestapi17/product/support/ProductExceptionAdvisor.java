package product.vistula.com.firstrestapi17.product.support;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import product.vistula.com.firstrestapi17.response.ErrorMessageResponse;
import product.vistula.com.firstrestapi17.product.support.exception.ProductNotFoundException;

public class ProductExceptionAdvisor {
    private static final Logger LOG = LoggerFactory.getLogger(ProductExceptionAdvisor.class);

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessageResponse productNotFound(ProductNotFoundException e) {
        LOG.error(e.getMessage(), e);
        return new ErrorMessageResponse(e.getLocalizedMessage());
    }
}
