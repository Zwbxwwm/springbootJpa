package com.example.girl.service.impl;

import com.example.girl.demain.Girl;

import java.util.List;

public interface IGirlServiceImpl {
    public List<Girl> getGirlsList();

    public Girl addGirl(Girl girl);

    public Girl getGirlById(Integer id);

    public void updateGirlById(Girl girl);

    public void deleteGirlById(Integer id);

    public List<Girl> getGirlByAge(Integer age);

    public void JudgeGirlByAge(Integer id) throws Exception;
}
