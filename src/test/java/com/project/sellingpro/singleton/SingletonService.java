package com.project.sellingpro.singleton;

public class SingletonService {
    //static 으로 생성해주었기 때문에, class생성 전에 클래스 레벨로 한개만 생성된다.
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;  //클래스 생성시 한개 생겨난 인스턴스를 가져다 쓸 수 있도록 한다.
    }

    private SingletonService(){
        //private 를 이용해  생성자 못쓰게 막아버린다.
    }
    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
