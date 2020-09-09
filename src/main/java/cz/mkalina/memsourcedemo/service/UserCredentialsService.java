package cz.mkalina.memsourcedemo.service;

import cz.mkalina.memsourcedemo.client.MemsourceClient;
import cz.mkalina.memsourcedemo.persistence.UserCredentials;
import cz.mkalina.memsourcedemo.persistence.UserCredentialsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
@RequiredArgsConstructor
public class UserCredentialsService {

    private final UserCredentialsRepository repository;
    private final MemsourceClient memsourceClient;

    public boolean store(String name, String password) {


        try {
            memsourceClient.authenticate(name, password);
            saveToDb(name, password);
            return true;
        } catch (HttpClientErrorException e){
            return false;
        }
    }

    private void saveToDb(String name, String password) {
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
