import com.hbxy.bean.RoomBean;
import com.hbxy.dao.RoomDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class RoomDaoTest
{
	@Resource
	private RoomDao roomDao;
	
	@Test
	public void findByIdTest()
	{
		roomDao.findById(1);		
	}
	
	@Test
	public void insertRoomTest()
	{
		RoomBean room = new RoomBean();
		room.setRoomTypeId(1);
		room.setRoomNumber("111");
		room.setGender(0);
		room.setTotal(0);
		roomDao.insertRoom(room);
	}
}
