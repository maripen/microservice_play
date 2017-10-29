package com.itemsharing.userservice.Repository;

import com.itemsharing.userservice.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

       User findByUsername(String username);

}
