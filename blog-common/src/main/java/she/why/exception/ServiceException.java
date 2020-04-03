package she.why.exception;

/**
 *  自定义异常类
 */
public class ServiceException extends RuntimeException {

    public ServiceException(){};

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
    public ServiceException(Throwable cause) {
        super(cause);
    }
}
