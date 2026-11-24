package in.jatint4r.springbootcrudoperations.exception;

public class ResourceNotFoundException extends  RuntimeException  {
    public ResourceNotFoundException(String message){
       super(message);
    }
}
