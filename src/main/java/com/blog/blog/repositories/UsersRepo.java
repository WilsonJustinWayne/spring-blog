package com.blog.blog.repositories;

import com.blog.blog.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
