package mybatis_spring_study.service;

import mybatis_spring_study.dto.Department;
import mybatis_spring_study.dto.Employee;

public interface TransactionService {
	
	public void registerTransaction(Employee employee, Department department);

	public void unRegisterTransaction(Employee employee, Department department);
	
}
