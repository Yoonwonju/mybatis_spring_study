package mybatis_spring_study.service;

import mybatis_spring_study.dto.Department;
import mybatis_spring_study.dto.Employee;

public interface TransactionAOPService {

	int trRegister(Employee employee, Department department);

	int trUnRegister(Employee employee, Department department);
	
}
