package com.wk.controller;

import com.wk.service.SalaryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SalaryController {
    @Resource
    private SalaryService salaryService;

    @RequestMapping("toSettleSalary")
    protected String toSettleSalary(HttpServletResponse response) throws Exception{
        response.setHeader("Content-Type", "text/html;charset=UTF-8");

        return "settleSalary";
    }
}
