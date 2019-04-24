import com.hbxy.bean.ChargeStandardBean;
import com.hbxy.dao.ChargeStandardDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ChargeStandardTest
{
	@Resource
	private ChargeStandardDao chargeStandardDao;
	
	@Test
	public void findByIdTest()
	{
		chargeStandardDao.findById(3);
	}

	@Test
	public void findAll()
	{
		chargeStandardDao.findAll();
	}
	
	@Test
	public void updateById()
	{
		ChargeStandardBean chargeStandardBean = new ChargeStandardBean();
		chargeStandardBean.setCsId(6);
		chargeStandardBean.setCsName("abc");
		chargeStandardBean.setCsPrice(1.1);
		
		chargeStandardDao.updateById(chargeStandardBean);
	}
}
