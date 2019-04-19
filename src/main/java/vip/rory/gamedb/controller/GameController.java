/**
 * 
 */
package vip.rory.gamedb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vip.rory.gamedb.model.Response;
import vip.rory.gamedb.service.GameService;

/**
 * @fileName: GameController.java
 * @describe:
 * @author: Rory
 * @date: 2018年7月16日
 * @version: 1.0.0
 */
@RestController
@RequestMapping(value = "/game", method = RequestMethod.POST)
public class GameController {

	private static Logger LOGGER = LoggerFactory.getLogger(GameController.class);

	@Autowired
	private GameService gameService;

	@RequestMapping(value = "/selectPage")
	public Response selectPage(Integer page, Integer rows, String keyword) {
		LOGGER.info("请求游戏列表:page:{},rows{},keyword:{}", page, rows, keyword);
		Response response = new Response();
		response.setCode(200);
		response.setMessage("请求成功");
		response.setData(gameService.selectPage(page, rows, keyword));
		return response;
	}

	@RequestMapping(value = "/count")
	public Response count(String keyword) {
		Response response = new Response();
		response.setCode(200);
		response.setMessage("请求成功");
		response.setData(gameService.count(keyword));
		return response;
	}

}
