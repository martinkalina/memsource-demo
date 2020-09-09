package cz.mkalina.memsourcedemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class LoginResponse {

    private String token;
    private String expires;
}
