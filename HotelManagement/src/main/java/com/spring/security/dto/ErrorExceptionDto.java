package com.spring.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
public class ErrorExceptionDto implements Serializable {
    /**
     * custom code default
     */
    private String code;

    /**
     * message about problem
     */
    private String message;
}
