package cz.mkalina.memsourcedemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ConfigurationRequest {

    private String userName;

    private String password;
}
