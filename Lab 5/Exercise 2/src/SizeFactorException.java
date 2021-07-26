public class SizeFactorException extends Throwable{

    public String getMessage() {
        String str = "You can't shrink or expand with a value less than 1.";
        return str;
    }

}