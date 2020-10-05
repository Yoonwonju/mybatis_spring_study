package mybatis_spring_study.mapper;

import java.util.List;

import mybatis_spring_study.dto.Employee;

public interface EmployeeMapper {
	List<Employee> selectEmployeeByAll();
	Employee selectEmployeeByNo(Employee employee);
	int insertEmployee(Employee employee);
	int updateEmployee(Employee employee);
	int deleteEmployee(Employee employee);
}
