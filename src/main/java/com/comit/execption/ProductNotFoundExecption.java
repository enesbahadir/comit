package com.comit.execption;

public class ProductNotFoundExecption extends RuntimeException {
    public ProductNotFoundExecption(Integer id) {
        super("Could not find product " + id);
    }
    public ProductNotFoundExecption(String message) {
        super(message);
    }
}
