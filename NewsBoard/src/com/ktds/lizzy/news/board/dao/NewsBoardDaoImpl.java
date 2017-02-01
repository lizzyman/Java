package com.ktds.lizzy.news.board.dao;

import java.util.ArrayList;
import java.util.List;

import com.ktds.lizzy.news.board.vo.NewsVo;

public class NewsBoardDaoImpl implements NewsBoardDao{

	private List<NewsVo> newsList;
	
	public NewsBoardDaoImpl() {
		newsList = new ArrayList<NewsVo>();
	}
	
	@Override
	public List<NewsVo> queryAllNews() {
		return newsList;
	}

	@Override
	public void addNewNews(NewsVo newNews) {
		newsList.add(newNews);
	}
	
}
