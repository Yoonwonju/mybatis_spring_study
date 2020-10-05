package mybatis_spring_study.service;

import static org.junit.Assert.*;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mybatis_spring_study.dto.Department;
import mybatis_spring_study.dto.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/context-root.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeServiceTest {

	private static final Log log = LogFactory.getLog(EmployeeServiceTest.class);
	
	@After
	public void tearDown() throws Exception{
		System.out.println();
	}
	
	@Autowired
	private EmployeeService service;
	
	@Test
	public void test01InsertEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee employee = new Employee(7777, "±Ë¿Œ≈œ", "¿Œ≈œ", new Employee(4377), 1000000, new Department(1));
		int res = service.insertEmployee(employee);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test02DeleteEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee employee = new Employee(7777);
		int res = service.deleteEmployee(employee);
		Assert.assertEquals(1, res);
	}

}
