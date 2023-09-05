package org.example;

public interface ICURD {
    void addWord();
    int update(Object obj);
    int delete(Object obj);
    void selectOne(int id);
}
