package com.e2mtool.emp.mapper;

import com.e2mtool.emp.entity.Emp;
import com.e2mtool.emp.vo.EmpQuery;

import java.util.List;

public interface EmpMapper {
    List<Emp> getEmpList(EmpQuery param);
    Long countEmpList(EmpQuery param);
    void addEmp(Emp emp);
    void deleteEmpByIds(String ids);
    Emp getEmpById(Integer id);
    void updateEmp(Emp emp);
}
