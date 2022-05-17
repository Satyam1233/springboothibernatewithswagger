package com.csi.service;

import com.csi.dao.EmployeeDao;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired
    EmployeeDao employeeDaoImpl;

    @Override
    public void signUp(Employee employee) {
        employeeDaoImpl.signUp(employee);

    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {
        return employeeDaoImpl.signIn(empEmailId,empPassword);
    }

    @Override
    public void saveBulOfData(List<Employee> employees) {
        employeeDaoImpl.saveBulOfData(employees);

    }

    @Override
    public Employee getDataById(int empId) {
        return employeeDaoImpl.getDataById(empId);
    }

    @Override
    public Employee getDataByEmail(String empEmailId) {
        return employeeDaoImpl.getDataByEmail(empEmailId);
    }

    @Override
    public Employee getDataByContactNumber(long empContactNumber) {
        return employeeDaoImpl.getDataByContactNumber(empContactNumber);
    }

    @Override
    public List<Employee> getAllData() {
        return employeeDaoImpl.getAllData();
    }

    @Override
    public List<Employee> filterData(double empSalary) {
        return employeeDaoImpl.filterData(empSalary);
    }

    @Override
    public void updateData(int empId, Employee employee) {
        employeeDaoImpl.updateData(empId, employee);
    }

    @Override
    public void deleteDataById(int empId) {
        employeeDaoImpl.deleteDataById(empId);

    }

    @Override
    public void deleteAllData() {
        employeeDaoImpl.deleteAllData();

    }
}
