package com.ktds.lizzy.board.controller;

import com.ktds.lizzy.board.biz.BoardBiz;
import com.ktds.lizzy.board.biz.BoardBizImpl;
import com.ktds.lizzy.board.vo.BoardVO;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Admin on 2017-02-17.
 */
public class BoardController {

    private BoardBiz boardBiz;

    public BoardController() {
        boardBiz = new BoardBizImpl();
    }

    public void wirteArticle() {
        BoardVO boardVO = new BoardVO();
        boardVO.setWriter("Lizzy");
        boardVO.setSubject("Homework");
        boardVO.setContents("asdfasdfasdfasdfasdfasdfasdfasdf");

        if (boardBiz.writeArticle(boardVO)) {
            System.out.println("Success!");
        }
        else {
            System.out.println("Fail...");
        }
    }

    public void printAllArticles() {
        List<BoardVO> articles = boardBiz.getAllArticles();

        for (BoardVO article : articles) {
            System.out.printf("\nBoard Id : %d\n", article.getBoardId());
            System.out.printf("Title : %s\n", article.getSubject());
            System.out.printf("Writer : %s\n", article.getWriter());
            System.out.printf("Write Date : %s\n", article.getWriteDate());
            System.out.printf("==========================================\n");
        }
    }

    public void printOneArticle(int boardId) {
        BoardVO article = boardBiz.getOneArticle(boardId);

        System.out.printf("\nBoard Id : %d\n", article.getBoardId());
        System.out.printf("Title : %s\n", article.getSubject());
        System.out.printf("Writer : %s\n", article.getWriter());
        System.out.printf("Write Date : %s\n", article.getWriteDate());
        System.out.printf("Like Count : %s\n", article.getLikeCount());
        System.out.printf("Content : %s\n", article.getContents());
        System.out.println();
    }

    public void deleteOneArticle(int boardId) {
        if (boardBiz.deleteArticle(boardId)) {
            System.out.println("Success!");
        }
        else {
            System.out.println("Fail...");
        }
    }

    public void start() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        int boardId = -1;
        while (true) {
            System.out.println("===============================");
            System.out.println("   Ktds University Articles");
            System.out.println("===============================");
            System.out.println("Select...");
            System.out.println("1. Write Article");
            System.out.println("2. Show Articlle List");
            System.out.println("3. Find One Article");
            System.out.println("4. Delete One Article");
            System.out.println("0. Exit Program");
            System.out.print("Your choice : ");

            choice = input.nextInt();
            if (choice == 1) {
                wirteArticle();
            }
            else if (choice == 2) {
                printAllArticles();
            }
            else if (choice == 3) {
                System.out.print("Board Id : ");
                boardId = input.nextInt();
                printOneArticle(boardId);
            }
            else if (choice == 4) {
                System.out.print("Board Id : ");
                boardId = input.nextInt();
                deleteOneArticle(boardId);
            }
            else if (choice == 0) {
                System.out.println("Bye...");
                break;
            }
            else {
                System.out.println("Wrong Input...");
            }

        }
    }

    public static void main(String[] args) {

        new BoardController().start();

    }

}
