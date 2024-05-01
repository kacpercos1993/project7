package org.example.model.command;

import lombok.Data;

import java.util.Map;

@Data
public class CreatePersonCommand {
    private String dataType;
    private Map<String, String> params;
}
