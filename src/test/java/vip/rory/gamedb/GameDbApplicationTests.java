package vip.rory.gamedb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import vip.rory.gamedb.mapper.GameMapper;
import vip.rory.gamedb.service.SpiderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameDbApplicationTests {

	@Autowired
	private GameMapper gameMapper;

	@Autowired
	private SpiderService spiderService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void mapperTest() {
		gameMapper.deleteByPrimaryKey(1);
	}

	@Test
	public void spiderTest() {
		spiderService.collectionGame(2, 5, true);
	}

}
