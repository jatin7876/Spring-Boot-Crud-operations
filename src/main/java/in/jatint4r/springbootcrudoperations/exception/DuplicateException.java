package in.jatint4r.springbootcrudoperations.exception;

public class DuplicateException extends RuntimeException {
    public DuplicateException(String message){
        super(message);
    }
}
