package mybatis_spring_study.service;

import mybatis_spring_study.dto.Employee;

public interface EmployeeService {
	int insertEmployee(Employee employee);
	int deleteEmployee(Employee employee);
}
