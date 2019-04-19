/**
 * 
 */
package vip.rory.gamedb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;
import vip.rory.gamedb.mapper.GameMapper;
import vip.rory.gamedb.model.Game;
import vip.rory.gamedb.service.GameService;

/**
 * @fileName: GameServiceImpl.java
 * @describe:
 * @author: Rory
 * @date: 2018年7月16日
 * @version: 1.0.0
 */
@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameMapper gameMapper;

	@Override
	public int insertGame(Game game) {
		return gameMapper.insert(game);
	}

	@Override
	public Game selectOne(Game game) {
		return gameMapper.selectOne(game);
	}

	@Override
	public int delete(Game game) {
		return gameMapper.delete(game);
	}

	@Override
	public List<Game> selectPage(Integer page, Integer rows, String keyword) {
		PageHelper.startPage(page, rows);
		Example example = new Example(Game.class);
		example.setOrderByClause("page_id DESC");
		if (!StringUtils.isEmpty(keyword)) {
			Example.Criteria criteria = example.createCriteria();
			criteria.orLike("nameZh", "%" + keyword + "%");
			criteria.orLike("nameEn", "%" + keyword + "%");
		}
		return gameMapper.selectByExample(example);
	}

	@Override
	public int count(String keyword) {
		Example example = new Example(Game.class);
		if (!StringUtils.isEmpty(keyword)) {
			Example.Criteria criteria = example.createCriteria();
			criteria.orLike("nameZh", "%" + keyword + "%");
			criteria.orLike("nameEn", "%" + keyword + "%");
		}
		return gameMapper.selectCountByExample(example);
	}

}
