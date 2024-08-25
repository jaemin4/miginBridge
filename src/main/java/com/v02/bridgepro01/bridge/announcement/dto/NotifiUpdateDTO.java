package com.v02.bridgepro01.bridge.announcement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotifiUpdateDTO {

    //글 ID
    private String NotifiId;

    //글 유형
    private String NotifiType;

    //글 제목
    private String NotifiTitle;

    //글 상세 내용
    private String NotifiContent;

    //
    private String NotifiUploadingImages;

    //파일은 나중에 처리하자
    //private String UploadingFile;

}
