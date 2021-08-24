package com.digitalinnovationone.live.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends Throwable {

    public RecordNotFoundException(String entityName, Long id){
        super(entityName + "Not Found" + id);
    }
}
