package mybatis_spring_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mybatis_spring_study.dto.Department;
import mybatis_spring_study.dto.Employee;
import mybatis_spring_study.mapper.DepartmentMapper;
import mybatis_spring_study.mapper.EmployeeMapper;
import mybatis_spring_study.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private EmployeeMapper empMapper;
	
	@Autowired
	private DepartmentMapper deptMapper;
	
	@Override
	@Transactional
	public void registerTransaction(Employee employee, Department department) {
		int res = deptMapper.insertDepartment(department);
		res += empMapper.insertEmployee(employee);
		if(res != 2) throw new RuntimeException();
	}

	@Override
	@Transactional
	public void unRegisterTransaction(Employee employee, Department department) {
		int res = empMapper.deleteEmployee(employee);
		res += deptMapper.deleteDepartment(department);
		if(res != 2) throw new RuntimeException();
	}

}
