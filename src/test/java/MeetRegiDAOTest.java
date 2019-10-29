import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pjt.common.domain.MeetRegiVO;
import com.pjt.common.persistence.MeetRegiDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MeetRegiDAOTest {
	@Inject
	MeetRegiDAO dao;
	@Test
	public void testWaitRegi() throws Exception{
		MeetRegiVO vo = new MeetRegiVO();
		vo.setMeet_addr(1);
		vo.setMeet_category(1);
		vo.setMeet_name("빠른만남");
		vo.setMeet_state("w");
		vo.setMeet_sub_category(3);
		vo.setMeet_writer("id161");
		dao.waitRegi(vo);
	}
	@Test
	public void test() throws Exception{
		dao.waitRegioverRapChk("id55555");
	}
}
