package mybatis_spring_study.service;

import mybatis_spring_study.dto.Department;
import mybatis_spring_study.dto.Employee;

public interface TransactionService {
	
	public void trRegister(Employee employee, Department department);

	public void trUnRegister(Employee employee, Department department);
	
}
