/**
 * 
 */
package vip.rory.gamedb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vip.rory.gamedb.service.SpiderService;

/**
 * @fileName: SpiderController.java
 * @describe:
 * @author: Rory
 * @date: 2018年7月16日
 * @version: 1.0.0
 */
@RestController
@RequestMapping(value = "/spider", method = RequestMethod.POST)
public class SpiderController {

	@Autowired
	private SpiderService spiderService;

	/**
	 * 调用该方法开始采集游戏
	 * 
	 * @param startPage
	 * @param endPage
	 * @param overwrite
	 */
	@RequestMapping(value = "/collectionGame")
	public void collectionGame(Integer startPage, Integer endPage, Boolean overwrite) {
		spiderService.collectionGame(startPage, endPage, overwrite);
	}

}
