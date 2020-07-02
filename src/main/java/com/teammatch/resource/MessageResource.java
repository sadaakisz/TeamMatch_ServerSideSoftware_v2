package com.teammatch.resource;

import lombok.Data;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

@Data
public class MessageResource {
    private Long id;
    private String message;
    private String sentDate;
    private boolean isHyperLink;

}
