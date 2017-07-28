package com.kowalik.dominik.nfc.page_content.exception;

/**
 * Created by dominik on 28.07.17.
 */
public class DocumentNotFoundException extends RuntimeException {
    public DocumentNotFoundException(String msg){
        super(msg);
    }
}
