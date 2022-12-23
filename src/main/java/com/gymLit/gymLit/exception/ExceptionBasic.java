package com.gymLit.gymLit.exception;

public class ExceptionBasic extends Exception{
    private static final long serialVersionUID = 1L;

    public ExceptionBasic(String message){
        super(message);
    }
    public static String NotFoundException(Long id){
        return "Registry "+id+" not found";
    }
    public static String AlreadyExists(){
        return "registration already registered ";
    }
}
