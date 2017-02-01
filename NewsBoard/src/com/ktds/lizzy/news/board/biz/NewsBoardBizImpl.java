package com.ktds.lizzy.news.board.biz;

import java.util.List;
import java.util.Scanner;

import com.ktds.lizzy.news.board.dao.*;
import com.ktds.lizzy.news.board.vo.NewsVo;

public class NewsBoardBizImpl implements NewsBoardBiz{
	
	private NewsBoardDao newsBoardDao;
	
	private Scanner input = new Scanner(System.in);
	
	public NewsBoardBizImpl() {
		newsBoardDao = new NewsBoardDaoImpl();
	}

	@Override
	public void queryAllNews() {
		List<NewsVo> newsList = newsBoardDao.queryAllNews();
		
		System.out.println("==========Show All News Title==========");
		for (NewsVo news : newsList) {
			showNewsInfo(news);
			System.out.println();
		}
		System.out.println("=======================================\n");
	}

	private void showNewsInfo(NewsVo news) {
		System.out.printf("Title : %s\nCompany : %s\nWriter : %s\n", news.getNewsTitle(), news.getNewsCompany(), news.getWriter());
	}

	@Override
	public void addNewNews() {
		NewsVo newsVo = new NewsVo();
		
		System.out.println("=============Add New News=============");
		enterNewsInfo(newsVo);
		System.out.println("======================================\n");
		
		newsBoardDao.addNewNews(newsVo);
	}

	private void enterNewsInfo(NewsVo newsVo) {
		System.out.println("Enter your new News Title!");
		String newsTitle = input.next();
		System.out.println("Enter your Company!");
		String newsCompany = input.next();
		System.out.println("Enter your Name!");
		String writer = input.next();
		
		newsVo.setNewsTitle(newsTitle);
		newsVo.setNewsCompany(newsCompany);
		newsVo.setWriter(writer);
	}
	
}
