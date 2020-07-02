package com.teammatch.resource;

import lombok.Data;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

@Data
public class SaveMessageResource {
    @Lob
    @NotNull
    private String message;

    @NotNull
    private String sentDate;

    private boolean isHyperLink;
}
