package cz.mkalina.memsourcedemo.service;

import cz.mkalina.memsourcedemo.persistence.UserCredentials;
import cz.mkalina.memsourcedemo.persistence.UserCredentialsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCredentialsService {

    private final UserCredentialsRepository repository;

    public void store(String name, String password) {

        var credentials = repository.findById(UserCredentials.SINGLE_RECORD_ID)
                .orElse(new UserCredentials(name, password));
        credentials.setName(name);
        credentials.setPassword(password);
        repository.save(credentials);
    }

    public UserCredentials load(){
        return repository.findById(1L).orElseThrow(() -> new IllegalArgumentException("Credentials not stored yet."));
    }

}
