/**
 * 
 */
package vip.rory.gamedb.service;

import java.util.List;

import vip.rory.gamedb.model.Game;

/**
 * @fileName: GameService.java
 * @describe:
 * @author: Rory
 * @date: 2018年7月16日
 * @version: 1.0.0
 */
public interface GameService {

	/**
	 * @param game
	 * @return
	 */
	int insertGame(Game game);

	/**
	 * @param game
	 * @return
	 */
	Game selectOne(Game game);

	/**
	 * @param selectGame
	 */
	int delete(Game game);

	/**
	 * @param page
	 * @param rows
	 * @param keyword
	 */
	List<Game> selectPage(Integer page, Integer rows, String keyword);

	/**
	 * @return
	 */
	int count(String keyword);

}
