package com.example.girl.controller;

import com.example.girl.common.ServerResponse;
import com.example.girl.demain.Girl;
import com.example.girl.service.impl.IGirlServiceImpl;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/girl")
public class girlController {

    @Autowired
    private IGirlServiceImpl iGirlService;

    @GetMapping("/getGirlList")
    public List<Girl> getGirList(){
        return iGirlService.getGirlsList();
    }

    @PostMapping("/addGirl")
    public ServerResponse<Girl> addGirl(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ServerResponse.error(bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return ServerResponse.success(iGirlService.addGirl(girl));
    }

    @GetMapping("/getGirl/{id}")
    public Girl getGirlById(@PathVariable("id")Integer id){
        return iGirlService.getGirlById(id);
    }

    @PutMapping("/updateGirl/{id}")
    public void updateGirlById(@PathVariable("id") Integer id,@RequestParam("cupSize")String cupSize,@RequestParam("age")Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        iGirlService.updateGirlById(girl);
    }

    @DeleteMapping("/deleteGirlById/{id}")
    public void deleteGirlById(@PathVariable("id")Integer id){
        iGirlService.deleteGirlById(id);
    }

    @GetMapping("/getGirlByAge/{age}")
    public List<Girl> getGirlByAge(@PathVariable("age")Integer age){
        return iGirlService.getGirlByAge(age);
    }

    @RequestMapping("/JudgeGirlByAge")
    public void JudgeGirlByAge(@RequestParam("id")Integer id) throws Exception{
        iGirlService.JudgeGirlByAge(id);
    }


}
