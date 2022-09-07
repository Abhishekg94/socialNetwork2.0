package com.example.allinone.controller;

import com.example.allinone.dao.EmployeeDao;
import com.example.allinone.dao.model.Employee;
import com.example.allinone.service.EmployeeService;
import com.example.allinone.service.request.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Response;
import java.net.http.HttpResponse;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmp")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeRequest request){

        employeeService.addEmployee(request);
        return ResponseEntity.ok("dfsgdhfj");
    }

    @GetMapping ("/welcome")
    public String welcome(){

        return  "welcome page";
    }
}
