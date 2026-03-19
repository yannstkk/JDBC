package portos.data;

@SuppressWarnings("serial")
public class AppliException extends Exception {


    public AppliException() {
    }


    public AppliException(String arg0) {
        super(arg0);
    }

    public AppliException(Throwable arg0) {
        super(arg0);
    }

    public AppliException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }


}
