package com.csi.dao;

import com.csi.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeDaoImpl implements  EmployeeDao{
    private static SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();

    @Override
    public void signUp(Employee employee) {
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();

        session.save(employee);
        transaction.commit();
    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {
        Session session= factory.openSession();
        Transaction transaction=session.beginTransaction();
        boolean flag=false;
        List<Employee> employees=session.createQuery("from Employee").list();

        for (Employee emp: employees) {
            if (emp.getEmpEmailId().equals(empEmailId) && emp.getEmpPassword().equals(empPassword)){
                flag=true;
            }
        }
        return flag;
    }

    @Override
    public void saveBulOfData(List<Employee> employees) {
        Session session= factory.openSession();

        for(Employee emp: employees){
            Transaction transaction=session.beginTransaction();

            session.save(emp);
            transaction.commit();
        }

    }

    @Override
    public Employee getDataById(int empId) {
        Session session= factory.openSession();

        Employee employee= (Employee) session.get(Employee.class,empId);

        return employee;
    }

    @Override
    public Employee getDataByEmail(String empEmailId) {

        Session session= factory.openSession();
        Employee employee=new Employee();

        List<Employee> employees=session.createQuery("from Employee").list();

        for (Employee emp:employees){

            if (emp.getEmpEmailId().equals(empEmailId)){ // Why we dont take same code as empId
                employee.setEmpId(emp.getEmpId());
                employee.setEmpEmailId(emp.getEmpEmailId());
                employee.setEmpAddress(emp.getEmpAddress());
                employee.setEmpDOB(emp.getEmpDOB());
                employee.setEmpContactNumber(emp.getEmpContactNumber());
                employee.setEmpSalary(emp.getEmpSalary());
                employee.setEmpName(emp.getEmpName());
                employee.setEmpPassword(emp.getEmpPassword());

            }
        }
        return employee;
    }

    @Override
    public Employee getDataByContactNumber(long empContactNumber) {

        Session session= factory.openSession();
        Employee employee=new Employee();

        List<Employee> employees=session.createQuery("from Employee").list();

        for (Employee emp:employees){

            if (emp.getEmpContactNumber()==empContactNumber){
                employee.setEmpId(emp.getEmpId());
                employee.setEmpEmailId(emp.getEmpEmailId());
                employee.setEmpAddress(emp.getEmpAddress());
                employee.setEmpDOB(emp.getEmpDOB());
                employee.setEmpContactNumber(emp.getEmpContactNumber());
                employee.setEmpSalary(emp.getEmpSalary());
                employee.setEmpName(emp.getEmpName());
                employee.setEmpPassword(emp.getEmpPassword());

            }
        }
        return employee;
    }

    @Override
    public List<Employee> getAllData() {
        Session session= factory.openSession();

        List<Employee> employees=session.createQuery("from Employee").list();
        return employees;
    }

    @Override
    public List<Employee> filterData(double empSalary) {
        Session session= factory.openSession();

        List<Employee> employees=session.createQuery("from Employee").list();

        return employees.stream().filter(emp-> emp.getEmpSalary()>=empSalary).collect(Collectors.toList());

    }

    @Override
    public void updateData(int empId, Employee employee) {
        Session session= factory.openSession();
        Transaction transaction=session.beginTransaction();

        List<Employee> employees= session.createQuery("from Employee").list();

        for(Employee emp:employees){
            if(emp.getEmpId()==empId){
                employee.setEmpId(emp.getEmpId()); // I want to delete 2nd parameter of method
                employee.setEmpEmailId(emp.getEmpEmailId());
                employee.setEmpAddress(emp.getEmpAddress());
                employee.setEmpDOB(emp.getEmpDOB());
                employee.setEmpContactNumber(emp.getEmpContactNumber());
                employee.setEmpSalary(emp.getEmpSalary());
                employee.setEmpName(emp.getEmpName());
                employee.setEmpPassword(emp.getEmpPassword());

                session.update(employee);
                transaction.commit();
            }
        }


    }

    @Override
    public void deleteDataById(int empId) {
        Session session= factory.openSession();
        Transaction transaction=session.beginTransaction();

        Employee employee= (Employee) session.get(Employee.class,empId);

        session.delete(employee);
        transaction.commit();
    }

    @Override
    public void deleteAllData() {

        Session session= factory.openSession();

        List<Employee> employee=session.createQuery("from Employee").list();

        for(Employee emp: employee){

            Transaction transaction=session.beginTransaction();
            session.delete(emp);
            transaction.commit();
        }

    }
}
