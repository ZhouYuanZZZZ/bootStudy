package com.zy.study.bootstudy.controller;

import com.zy.study.bootstudy.services.ITestTransactinService;
import com.zy.study.bootstudy.services.TestTransactinService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TransactionController {

    @Resource
    private ITestTransactinService transactinService;

    @RequestMapping("/testTransaction1")
    public String testTransaction1() {
        transactinService.test0();
        return "true";
    }
}
