package cz.mkalina.memsourcedemo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Long> {
}
