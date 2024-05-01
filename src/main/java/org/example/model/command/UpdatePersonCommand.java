package org.example.model.command;

import lombok.Data;

import java.util.Map;

@Data
public class UpdatePersonCommand {
    private String dataType;
    private Map<String, String> params;
}
