package pe.edu.cibertec.DSWII_Grupo10.exception;

public class MaxUploadSizeExceedException extends RuntimeException {
    public MaxUploadSizeExceedException (String message){
        super(message);
    }
}