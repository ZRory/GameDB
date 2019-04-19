/**
 * 
 */
package vip.rory.gamedb.service;

/**
 * @fileName: SpiderService.java
 * @describe:
 * @author: Rory
 * @date: 2018年7月16日
 * @version: 1.0.0
 */
public interface SpiderService {

	int collectionGame(Integer startPage, Integer endPage, Boolean overwrite);

}
