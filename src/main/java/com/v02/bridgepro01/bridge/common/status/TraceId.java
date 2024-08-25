package com.v02.bridgepro01.bridge.common.status;


import java.util.UUID;

public class TraceId {
    //흐름 정리
    // 외부 클래스에서 TraceId값을 불러오면 id값을 만들고


    private String id;
    private int level;

    //traceId 생성자 호출시 내부의 id값 UUID 값으로 , level값 0으로
    //createdNextId 호출시 현재 ID값과 level + 1를 리턴함
    //previousNextId 호출시 현재 ID값과 level -1를 리턴함

    public TraceId(){
        this.id = createId();
        this.level = 0;
    }

    //클래스 내부에서 id값과 level값을 재정의
    private TraceId(String id,int level){
        this.id = id;
        this.level = level;
    }

    //uuid값을 만듬
    private String createId(){
        return UUID.randomUUID().toString().substring(0,8);
    }

    //현재 id값과 level+1 값을 가진 TraceId가 불려감
    public TraceId createNextId(){
        return new TraceId(id,level + 1);
    }

    //현재 id값과 level-1 값을 가진 TraceId가 불려감
    public TraceId createPreviousId(){
        return new TraceId(id,level - 1);
    }
    //level이 0인지 확인
    public boolean isFirstLevel(){
        return level == 0;
    }

    //id를 가져오는 getter
    public String getId(){
        return id;
    }

    //level를 가져오는 getter
    public int getLevel(){
        return level;
    }









}
