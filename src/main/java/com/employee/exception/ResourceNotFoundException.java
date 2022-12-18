package com.employee.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    // RuntimeException internally implements serializable interface so
    private static final long serialVersionUID = 1L;
     String ResourceName;
     String FieldName;
     Integer FieldValue;
    public ResourceNotFoundException(String ResourceName, String FieldName, Integer FieldValue){
        super(String.format("%s not found with %s: %s", ResourceName, FieldName,FieldValue));
        this.ResourceName = ResourceName;
        this.FieldName = FieldName;
        this.FieldValue = FieldValue;
    }
}
