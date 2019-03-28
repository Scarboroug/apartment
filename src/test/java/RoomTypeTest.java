import com.hbxy.bean.RoomTypeBean;
import com.hbxy.dao.RoomTypeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class RoomTypeTest
{
	@Resource
	private RoomTypeDao roomTypeDao;
	
	@Test
	public void insertRoomTypeTest()
	{
		double a = 220;
		roomTypeDao.insertRoomType(new RoomTypeBean("四人间", 220.0));
	}
	
	@Test
	public void findByIdTest()
	{
		RoomTypeBean roomTypeBean = roomTypeDao.findById(1);
		System.out.println(roomTypeBean);
	}
	
	@Test
	public void deleteByIdTest()
	{
		roomTypeDao.deleteById(2);
	}
	
	@Test
	public void updateRoomTypeTest()
	{
		RoomTypeBean roomTypeBean = new RoomTypeBean();
		roomTypeBean.setRoomTypeId(3);
		roomTypeBean.setRental(170.0);
		roomTypeDao.updateRoomType(roomTypeBean);
	}
}
