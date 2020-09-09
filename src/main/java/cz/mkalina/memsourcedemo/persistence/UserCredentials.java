package cz.mkalina.memsourcedemo.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserCredentials {

    public  static final long SINGLE_RECORD_ID = 1L;

    @Id
    private final Long id = SINGLE_RECORD_ID;

    private String name;

    private String password;

}
