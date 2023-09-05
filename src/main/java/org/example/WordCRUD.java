package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICURD{
    Scanner s = new Scanner(System.in);
    ArrayList<Word> list;
    WordCRUD(Scanner s){
        list = new ArrayList<>();
        this.s=s;
    }


    public void addWord() {
        System.out.print("=> 난이도(1,2,3) & 새 단어 입력 :");
        int level = s.nextInt();
        String word = s.nextLine();
        System.out.print("뜻 입력 : ");
        String meaning = s.nextLine();
        Word newWord = new Word(0,level,word,meaning);
        list.add(newWord);
        System.out.println("새 단어가 단어장에 추가되었습니다 !!! ");
    }
    public void viewWord(){
        System.out.println("--------------------------------");
        for(int i=0; i<list.size(); i++){
            System.out.print((i+1)+"");
            System.out.println(list.get(i).toString());
        }
        System.out.println("--------------------------------");
    }

    @Override
    public int update(Object obj) {
        return 0;
    }

    @Override
    public int delete(Object obj) {
        return 0;
    }

    @Override
    public void selectOne(int id) {

    }
}
