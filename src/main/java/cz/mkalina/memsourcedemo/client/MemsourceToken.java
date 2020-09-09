package cz.mkalina.memsourcedemo.client;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class MemsourceToken {

    private final String token;

    private final ZonedDateTime expires;

}
