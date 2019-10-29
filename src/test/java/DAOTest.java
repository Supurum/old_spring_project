import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pjt.domain.ys.LoginDTO;
import com.pjt.service.ys.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class DAOTest {
	@Inject
	UserService service;
	@Test
	public void subCategory() throws Exception{
		LoginDTO dto=new LoginDTO("k0su44", "1111");
		service.login(dto);
	}
}
