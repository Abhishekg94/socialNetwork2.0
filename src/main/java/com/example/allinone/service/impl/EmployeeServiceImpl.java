package com.example.allinone.service.impl;

import com.example.allinone.dao.EmployeeDao;
import com.example.allinone.dao.model.Employee;
import com.example.allinone.service.EmployeeService;
import com.example.allinone.service.request.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;
    @Override
    public void addEmployee(EmployeeRequest employee) {
        Employee employee1 = new Employee();
        employee1.setName(employee.getName());
        employee1.setMobileNumber(employee.getMobileNumber());
        employee1.setAge(employee.getAge());
        employee1.setAddress(employee.getAddress());
//        employee1.setId(employee.getId());
        employeeDao.save(employee1);
        System.out.println("add employee called..................");
    }
}
