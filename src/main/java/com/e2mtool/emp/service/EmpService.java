package com.e2mtool.emp.service;

import com.e2mtool.emp.entity.Dept;
import com.e2mtool.emp.entity.Emp;
import com.e2mtool.emp.vo.EmpQuery;

import java.util.List;

public interface EmpService {
    List<Emp> getEmpList(EmpQuery param);
    Long countEmpList(EmpQuery param);
    void addEmp(Emp emp);

    List<Dept> getAllDept();

    void deleteEmpByIds(String ids);

    Emp getEmpById(Integer id);

    void updateEmp(Emp emp);
}
