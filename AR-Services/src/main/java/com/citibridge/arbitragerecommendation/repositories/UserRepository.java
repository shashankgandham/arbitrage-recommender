package com.citibridge.arbitragerecommendation.repositories;

import org.springframework.data.repository.CrudRepository;

import com.citibridge.arbitragerecommendation.login_entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);

}
