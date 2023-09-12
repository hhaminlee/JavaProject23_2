package org.example;

import java.util.Scanner;

public class WordManager {
    Scanner s = new Scanner(System.in);
    WordCRUD wordCRUD;
    WordManager(){
        wordCRUD = new WordCRUD(s);
    }
    public void start(){
        boolean running = true;
        while (running){
            viewMenu();
            int menu = s.nextInt();
            switch (menu){
                case 0:
                    running = false;
                    System.out.println("프로그램 종료! 다음에 만나요~ ");
                    break;
                case 1:
                    wordCRUD.viewWord();
                    break;
                case 4:
                    wordCRUD.addWord();
                    break;
                case 5:
                    wordCRUD.updateWord();
                    break;
                case 6:
                    wordCRUD.deleteWord();
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택하세요.");
                    break;
            }
        }
    }
    public void viewMenu(){
            System.out.print("*** 영단어 마스터 *** \n" +
                    "******************** \n" +
                    "1. 모든 단어 보기\n" +
                    "2. 수준별 단어 보기\n" +
                    "3. 단어 검색\n" +
                    "4. 단어 추가\n" +
                    "5. 단어 수정\n" +
                    "6. 단어 삭제\n" +
                    "7. 파일 저장\n" +
                    "0. 나가기\n" +
                    "******************** \n" +
                    "=> 원하는 메뉴는?");
    }
}
