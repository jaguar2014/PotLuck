package com.ashu.demo.config;

import com.ashu.demo.model.AppRole;
import com.ashu.demo.repository.AppRoleRepository;
import com.ashu.demo.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;//Remove the annotation after you have run this method once in a database that persists to storage.
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    AppRoleRepository roleRepo;

    @Autowired
    AppUserRepository userRepository;



    @Override
    public void run(String... strings) throws Exception {

        //Add all data that should be in the database at the beginning of the application
        AppRole role = new AppRole();
        role.setRoleName("USER");
        roleRepo.save(role);

        role = new AppRole();
        role.setRoleName("ADMIN");
        roleRepo.save(role);




    }}