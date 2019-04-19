/**
 * 
 */
package vip.rory.gamedb.service.impl;

import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;

import vip.rory.gamedb.config.AppConfig;
import vip.rory.gamedb.model.Game;
import vip.rory.gamedb.service.GameService;
import vip.rory.gamedb.service.SpiderService;
import vip.rory.gamedb.util.HttpClientUtil;
import vip.rory.gamedb.util.ResolveUtil;

/**
 * @fileName: SpiderServiceImpl.java
 * @describe:
 * @author: Rory
 * @date: 2018年7月16日
 * @version: 1.0.0
 */
@Service
public class SpiderServiceImpl implements SpiderService {

	private static Logger LOGGER = LoggerFactory.getLogger(SpiderServiceImpl.class);

	@Autowired
	private AppConfig appConfig;
	@Autowired
	private HttpClientUtil httpClientUtil;
	@Autowired
	private ResolveUtil resolveUtil;
	@Autowired
	private GameService gameService;

	@Override
	public int collectionGame(Integer startPage, Integer endPage, Boolean overwrite) {
		if (startPage == null || endPage == null) {
			return -1;
		}
		// 避免死循环 将大值交换为endPage
		if (startPage > endPage) {
			startPage = startPage ^ endPage;
			endPage = startPage ^ endPage;
			startPage = startPage ^ endPage;
		}
		for (int nowPage = startPage; nowPage <= endPage; nowPage++) {
			String pageId = String.valueOf(nowPage);
			String sourceUrl = appConfig.getSourceUrl().replaceAll("\\{page\\}", pageId);
			// 开始处理数据
			try {
				String resultHtml = httpClientUtil.sendGetRequestForHtml(sourceUrl);
				String cover = null;
				String nameZh = null;
				String nameEn = null;
				Element coverEle = resolveUtil.getElement(resultHtml, "p.gamePic img");
				if (coverEle != null) {
					cover = coverEle.attr("src");
				}
				Element nameZhEle = resolveUtil.getElement(resultHtml, "li.gameID_cn");
				if (nameZhEle != null) {
					nameZh = nameZhEle.html();
				}
				Element nameEnEle = resolveUtil.getElement(resultHtml, "li.gameID_zn");
				if (nameEnEle != null) {
					nameEn = nameEnEle.html();
				}
				if (StringUtils.isEmpty(cover) && StringUtils.isEmpty(nameZh) && StringUtils.isEmpty(nameEn)) {
					continue;
				}
				String size = null;
				String thunderLink = null;
				String torrentLink = null;
				Element sizeEle = resolveUtil.getElement(resultHtml, "li.gameSize span");
				if (sizeEle != null) {
					size = sizeEle.html();
				}
				Element thunderLinkEle = resolveUtil.getElement(resultHtml, "a.down_xl");
				Element torrentLinkEle = resolveUtil.getElement(resultHtml, "a.down_bt");
				if (thunderLinkEle == null && torrentLinkEle == null) {
					continue;
				}
				if (thunderLinkEle != null) {
					thunderLink = thunderLinkEle.attr("href");
				}
				if (torrentLinkEle != null) {
					torrentLink = torrentLinkEle.attr("href");
				}
				Game game = new Game();
				game.setCover(cover);
				game.setNameEn(nameEn);
				game.setNameZh(nameZh);
				game.setPageId(pageId);
				game.setSize(size);
				game.setThunderLink(thunderLink);
				game.setTorrentLink(torrentLink);
				Game selectGame = gameService.selectOne(game);
				if (selectGame != null) {
					if (overwrite) {
						gameService.delete(selectGame);
					} else {
						continue;
					}
				}
				LOGGER.info("成功抓取Page:{}", pageId);
				gameService.insertGame(game);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOGGER.info("抓取结束-startPage:{},endPage:{}", startPage, endPage);
		return 0;
	}

}
