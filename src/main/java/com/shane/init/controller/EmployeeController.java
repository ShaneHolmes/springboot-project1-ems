package com.shane.init.controller;

import com.shane.init.dao.DepartmentDao;
import com.shane.init.dao.EmployeeDao;
import com.shane.init.entities.Department;
import com.shane.init.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author ShaneHolmes
 * @date 2020/4/28 - 11:36
 * 功能描述：处理员工的请求
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    //查询所有的员工
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        return "emp/list";
    }

    //添加页面添加新员工
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //查出部门的列表，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //员工添加功能
    @PostMapping("/emp")//rest风格，post处理的是添加，put处理的修改
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,
                             Model model){
        //查询出要修改的员工
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);

        //页面要回显所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "/emp/add";
    }

    //员工修改
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除员工
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
