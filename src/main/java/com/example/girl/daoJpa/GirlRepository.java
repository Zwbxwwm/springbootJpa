package com.example.girl.daoJpa;

import com.example.girl.demain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,Integer> {
    //使用age作为查询
    public List<Girl> findByAge(Integer age);
}
