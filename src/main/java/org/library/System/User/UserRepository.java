package org.library.System.User;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
    @Query(value = "select * from users",nativeQuery = true)
    List<User>findAll();
    @Query(value = "select * from users where users.user_name = ?1",nativeQuery = true)
    User findByUserName(String userName);
}
