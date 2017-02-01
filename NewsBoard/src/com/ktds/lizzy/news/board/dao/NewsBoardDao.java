package com.ktds.lizzy.news.board.dao;

import com.ktds.lizzy.news.board.vo.*;
import java.util.List;

public interface NewsBoardDao {
	
	public List<NewsVo> queryAllNews();
	
	public void addNewNews(NewsVo newNews);
	
}
