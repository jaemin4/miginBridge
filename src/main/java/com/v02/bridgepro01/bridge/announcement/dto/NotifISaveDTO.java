package com.v02.bridgepro01.bridge.announcement.dto;


import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotifISaveDTO {

    //NotificationId 약자따서 NF001,NF002,NF003 ... NF051 / ID값 처리
    private String NotifiId;

    //글 유형
    private String NotifiType;

    //글 제목
    private String NotifiTitle;

    //글 상세 내용
    private String NotifiContent;

    //글 작성자
    private String NotifiAuthor;

    //글 업로드 날짜
    private Date NotifiUploadDate;

    //상세 이미지들
    // * 관리자
    //관리자가 png 이미지가 들어있는 압축폴더를 업로드하면
    //압축폴더를 해체한 후 '," 구분자로 이미지 파일 DB에 입력

    //* 요청
    // client에서 png 이미지들을 요청하면
    // ',' 구분자로 subString해서 List형식으로 응답하기
    //사용자가 이미지 요청시
    private String NotifiUploadingImages;

    //파일은 나중에 처리하자
    //private String UploadingFile;



}
