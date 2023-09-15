package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICURD{
    private static final String vocaFile = "vocabulary.txt";
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
            System.out.print((i+1)+" ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("--------------------------------");
    }

    public ArrayList<Integer> viewWord(String key){
        ArrayList<Integer> idList = new ArrayList<>();
        int j=0;
        System.out.println("--------------------------------");
        for(int i=0; i<list.size(); i++){
            String word = list.get(i).getWord();
            if(!word.contains(key))
                continue;
            System.out.print((j+1)+" ");
            System.out.println(list.get(i).toString());
            idList.add(i);
            j++;
        }
        System.out.println("--------------------------------");
        return idList;
    }
    public ArrayList<Integer> viewWord(int key){
        ArrayList<Integer> idList = new ArrayList<>();
        int j=0;
        System.out.println("--------------------------------");
        for(int i=0; i<list.size(); i++){
            int level = list.get(i).getLevel();
            if(level != key)
                continue;
            System.out.print((j+1)+" ");
            System.out.println(list.get(i).toString());
            idList.add(i);
            j++;
        }
        System.out.println("--------------------------------");
        return idList;
    }

    @Override
    public void updateWord() {
        System.out.print("==> 수정할 단어 검색 : ");
        String update = s.next();
        ArrayList<Integer> updateList = viewWord(update);
        System.out.print("==> 수정할 번호 선택 : ");
        int updateNum = s.nextInt();
        s.nextLine();
        System.out.print("==> 뜻 입력 : ");
        String updateStr = s.nextLine();
        int realNum = updateList.get(updateNum-1);
        Word word = list.get(realNum);
        word.setMeaning(updateStr);
        System.out.println("단어 수정이 성공적으로 되었습니다!!");
    }

    public void deleteWord(){
        System.out.print("==> 삭제할 단어 검색 : ");
        String delete = s.next();
        ArrayList<Integer> deleteList = viewWord(delete);
        System.out.print("==> 삭제할 번호 선택 : ");
        int deleteNum = s.nextInt();
        s.nextLine();
        System.out.print("==> 정말로 삭제하실래요?(Y/n) : ");
        String yn = s.next();
        if(yn.equalsIgnoreCase("y")){
            int realNum = deleteList.get(deleteNum-1);
            Word word = list.remove(realNum);
        }
        System.out.println("선택한 단어 삭제 완료 !!!");
    }
    public void loadWord(){
        try(BufferedReader br = new BufferedReader(new FileReader(vocaFile))){
            String line;
            int count = 0;
            while((line = br.readLine())!=null){
                String[] parts = line.split("\\|");
                if(parts.length == 3){
                    Word word = new Word(0,Integer.parseInt(parts[0]),parts[1],parts[2]);
                    list.add(word);
                    count++;
                }
            }
            System.out.println("=>"+count+" 개의 단어 로딩완료!");
        } catch (IOException e) {
            System.out.println("단어를 로딩하는 중 오류가 발생했습니다.");
        }
    }
    public void saveWord(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(vocaFile))) {
            for (Word word : list) {
                writer.write(word.getLevel()+"|" + word.getWord() + "|" + word.getMeaning());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("데이터 파일에 쓰는 중 오류가 발생했습니다.");
        }
    }

    public void levelView(){
        System.out.print("=> 레벨(1:초급, 2:중급, 3:고급)선택 : ");
        int lv = s.nextInt();

        ArrayList<Integer> levelList= viewWord(lv);
    }
    public void searchWord(){
        System.out.print("=> 검색할 단어 입력: ");
        String search = s.next();
        int j=0;
        System.out.println("--------------------------------");
        for(int i=0; i<list.size(); i++){
            String word = list.get(i).getWord();
            if(!word.contains(search))
                continue;
            System.out.print((j+1)+" ");
            System.out.println(list.get(i).stringTo());
            j++;
        }
        System.out.println("--------------------------------");
    }
}
