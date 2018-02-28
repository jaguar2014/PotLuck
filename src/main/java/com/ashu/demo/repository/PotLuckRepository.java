package com.ashu.demo.repository;

import com.ashu.demo.model.AppUser;
import com.ashu.demo.model.PotLuck;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PotLuckRepository extends CrudRepository<PotLuck, Long> {

    List<PotLuck> findPotLucksByAppUsersIn(List<AppUser> appUsers);
    List<PotLuck> findByAppUsers(AppUser appUser);
}
