package shu.cssd.transportsystem.foundation.exceptions;

public class ModelNotFoundException extends Exception
{

    private final String id;

    public ModelNotFoundException(String id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "A Model with id " + this.id + " is not found";
    }
}

