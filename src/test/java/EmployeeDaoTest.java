import com.hbxy.bean.EmployeeBean;
import com.hbxy.dao.EmployeeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EmployeeDaoTest
{
	@Resource
	private EmployeeDao employeeDao;
	
	@Test
	public void findEmployeeTest()
	{
		EmployeeBean emp = new EmployeeBean();
//		emp.setName("x");
//		Date date = Date.valueOf("2017-10-8");
//		emp.setStartTime("2018-2-16");
//		emp.setEndTime("2018-2-17");
//		emp.setPaymentTime("2018-2-17");
		emp.setFromIndex(0);
		emp.setPageSize(1);
		employeeDao.findEmployee(emp);
	}
	
	@Test
	public void findCountByConditionTest()
	{
		EmployeeBean emp = new EmployeeBean();
		System.out.println(employeeDao.findCountByCondition(emp));
	}
	
	@Test
	public void insertEmployee()
	{
		EmployeeBean emp = new EmployeeBean();
		emp.setIdNumber("320923199609074231");
		emp.setGender(1);
		emp.setName("��Ҷ��");
		emp.setPhone("15961170795");
		emp.setDeleteFlag(0);
		emp.setProvince("����ʡ");
		emp.setCity("�Ͼ���");
		employeeDao.insertEmployee(emp);
	}
}
