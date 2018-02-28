package com.ashu.demo.repository;

import com.ashu.demo.model.AppUser;
import com.ashu.demo.model.PotLuck;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    AppUser findAppUserByUsername(String username);

    Iterable<AppUser> findByPotLucksIn(Iterable<PotLuck> potLucks);


}
