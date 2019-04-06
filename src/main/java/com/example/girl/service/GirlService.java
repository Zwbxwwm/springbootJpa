package com.example.girl.service;

import com.example.girl.daoJpa.GirlRepository;
import com.example.girl.demain.Girl;
import com.example.girl.service.impl.IGirlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GirlService implements IGirlServiceImpl {

    @Autowired
    private GirlRepository girlRepository;

    /**
     * 获取所有女生的列表
     * @return
     */
    public List<Girl> getGirlsList(){
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @param girl
     * @return
     */
    public Girl addGirl(Girl girl){
        return girlRepository.save(girl);
    }

    /**
     * 根据Id来获取一个女生生对象
     * @param id
     * @return
     */
    public Girl getGirlById(Integer id){
        return girlRepository.findById(id).get();
    }

    /**
     * 更新女生信息（包括Id属性）
     * @param girl
     */
    public void updateGirlById(Girl girl){
        girlRepository.save(girl);
    }

    /**
     * 根据Id删除女生
     * @param id
     */
    public void deleteGirlById(Integer id){
        girlRepository.deleteById(id);
    }

    /**
     * 根据age获取女生列表
     * @param age
     * @return
     */
    public List<Girl> getGirlByAge(Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     * 判断女生的年龄
     * @param id
     * @throws Exception
     */
    public void JudgeGirlByAge(Integer id) throws Exception{
        Girl girl = girlRepository.findById(id).get();
        int age = girl.getAge();
        if(age<11){
            throw new Exception("小学生！");
        }else if(age>=11&&age<16){
            throw new Exception("初中生！");
        }
    }
}
