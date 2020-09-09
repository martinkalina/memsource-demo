package cz.mkalina.memsourcedemo.client;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
public class MemsourceToken {

    private final String token;

    private final ZonedDateTime expires;

}
