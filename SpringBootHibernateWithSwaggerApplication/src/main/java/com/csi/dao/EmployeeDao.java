package com.csi.dao;

import com.csi.model.Employee;

import java.util.List;

public interface EmployeeDao {

    public void signUp(Employee employee);
    public boolean signIn(String empEmailId, String empPassword);
    public void saveBulOfData(List<Employee> employees);
    public Employee getDataById(int empId);
    public Employee getDataByEmail(String empEmailId);
    public Employee getDataByContactNumber(long empContactNumber);
    public List<Employee> getAllData();
    public List<Employee> filterData(double empSalary);
    public void updateData(int empId, Employee employee);
    public void deleteDataById(int empId);
    public void deleteAllData();

}
