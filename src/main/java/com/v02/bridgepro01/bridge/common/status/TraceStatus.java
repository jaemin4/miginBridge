package com.v02.bridgepro01.bridge.common.status;

public class TraceStatus {

    //TraceId 클래스의 TraceId의 생성자를 가져옴
    //startTimeMs,message + TraceId의 생성자를 TraceStatus로 같이 반환
    private TraceId traceId;
    private Long startTimeMs;
    private String message;

    public TraceStatus(TraceId traceId, Long startTimeMs,String message){
        this.traceId = traceId;
        this.startTimeMs = startTimeMs;
        this.message = message;
    }

    public Long getStartTimeMs(){
        return startTimeMs;
    }

    public String getMessage(){
        return message;
    }

    public TraceId getTraceId(){
        return traceId;
    }
}
