package com.bankApplication.user.query.repository;

import com.bankApplication.user.core.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
