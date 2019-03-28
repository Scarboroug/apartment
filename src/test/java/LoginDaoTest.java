import com.hbxy.bean.LoginBean;
import com.hbxy.dao.LoginDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class LoginDaoTest
{
	@Resource
	private LoginDao loginDao;	
	
	@Test
	public void findByLoginNameTest()
	{
		LoginBean login = loginDao.findByLoginName("dxx");
		System.out.println(login);
	}
	
	@Test
	public void insertLoginTest()
	{
		LoginBean login = new LoginBean("123", "123", 0);
		loginDao.insertLogin(login);
	}
	
	@Test
	public void updatePasswordByLoginNameTest()
	{
		loginDao.updatePasswordByLoginName("bxl", "234");
	}
	
	@Test
	public void deleteByLoginNameTest()
	{
		loginDao.deleteByLoginName("123");
	}
}
