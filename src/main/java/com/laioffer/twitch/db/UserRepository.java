package com.laioffer.twitch.db;

import com.laioffer.twitch.db.entity.UserEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface UserRepository extends ListCrudRepository<UserEntity, Long> {

    // SELECT * FROM user where last_name = :last_name
    List<UserEntity> findByLastName(String lastName);

    // SELECT * FROM user where first_name = :first_name
    List<UserEntity> findByFirstName(String firstName);

    // SELECT * FROM user where username = :username
    // Return only 1 UserEntity, because username is unique
    UserEntity findByUsername(String username);

    @Modifying
    @Query("UPDATE users SET first_name = :firstName, last_name = :lastName WHERE username = :username")
    void updateNameByUsername(String username, String firstName, String lastName);
}
