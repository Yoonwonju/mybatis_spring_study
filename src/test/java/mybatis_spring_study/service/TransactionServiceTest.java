package mybatis_spring_study.service;

import static org.junit.Assert.fail;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mybatis_spring_study.config.ContextRoot;
import mybatis_spring_study.dto.Department;
import mybatis_spring_study.dto.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class} )
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TransactionServiceTest {

	protected static final Log log = LogFactory.getLog(TransactionServiceTest.class);
	
	@After
	public void tearDown() {
		System.out.println();
	}
	
	@Autowired
	private TransactionService service;
	
	@Test(expected = DuplicateKeyException.class)
	public void testARegisterTransaction_Fail_Department() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department department = new Department(1, "태스크포스", 10);
		Employee employee = new Employee(1004, "박신혜", "과장", new Employee(4377), 4100000, department);
		service.trRegister(employee, department);
	}
	
	@Test(expected = DuplicateKeyException.class)
	public void testBRegisterTransaction_Fail_Employee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department department = new Department(6, "태스크포스", 10);
		Employee employee = new Employee(4377, "박신혜", "과장", new Employee(4377), 4100000, department);
		service.trRegister(employee, department);
	}
	
	@Test
	public void testCRegisterTransaction_Success() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department department = new Department(6, "태스크포스", 10);
		Employee employee = new Employee(1005, "박신혜", "과장", new Employee(4377), 4100000, department);
		service.trRegister(employee, department);
	}

	@Test(expected = RuntimeException.class)
	public void testDUnRegisterTransaction_Fail_Department() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department department = new Department(321);
		Employee employee = new Employee(1005);
		service.trUnRegister(employee, department);
	}
	
	@Test(expected = RuntimeException.class)
	public void testEUnRegisterTransaction_Fail_Employee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department department = new Department(6);
		Employee employee = new Employee(5432);
		service.trUnRegister(employee, department);
	}
	
	@Test
	public void testFUnRegisterTransaction_Success() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department department = new Department(6);
		Employee employee = new Employee(1005);
		service.trUnRegister(employee, department);
	}

}
