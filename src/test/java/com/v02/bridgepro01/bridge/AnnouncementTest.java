package com.v02.bridgepro01.bridge;


import com.v02.bridgepro01.bridge.announcement.dto.NotifISaveDTO;
import com.v02.bridgepro01.bridge.common.status.PagingCulDTO;
import com.v02.bridgepro01.bridge.announcement.dto.NotifiUpdateDTO;
import com.v02.bridgepro01.bridge.announcement.vo.NotifiInfoVO;
import com.v02.bridgepro01.bridge.announcement.NotifiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest(classes = BridgePro01Application.class)
public class AnnouncementTest {

    @Autowired
    NotifiService notifiService;


    @Test
    void contextLoad(){}

    //공지사항 전체 조회
    @Test
    void NotifiServiceSelectAll(){
        List<NotifiInfoVO> listVO = notifiService.SelectNotifiInfo();
    }

    // 공지사항 상세 조회
    @Test
    void NotifiServiceSelectById(){
        String id = "N001";
        NotifiInfoVO vo = notifiService.SelectByIdNotifiInfo(id);
    }

    //공지사항 글 등록
    @Test
    void notifiServiceSave() {
        LocalDate dateNow = LocalDate.now();
        Date date = Date.valueOf(dateNow);
        NotifISaveDTO dto = new NotifISaveDTO("N015", "admin001", "content", "title", "입출금",date,"1.png,2.png,3.png");
        notifiService.SaveNotifiInfo(dto);
    }

    //공지사항 글 업데이트
    @Test
    void NotifiServiceUpdate(){
        String UpdateImages = "6.png,5.png,4.png";
        NotifiUpdateDTO dto = new NotifiUpdateDTO("N003","UpdateContent","UpdateTitle","UpdateType",UpdateImages);
    }

    //게시글 전체 개수
    @Test
    void NotifiServiceCountSelectAll(){
       int result = notifiService.CountSelectAll();
    }

    //공지사항 글 페이징
    @Test
    void NotifiServicePaging(){
        int result = notifiService.CountSelectAll();
        PagingCulDTO dto = new PagingCulDTO(3,5);

        int maxPage = dto.getMaxPage(result);
        int offset = dto.getOffset();
        int pageSize = dto.getPazeSize();

        List<NotifiInfoVO> listVo = notifiService.SelectWithPaging(pageSize,offset);
        System.out.println(listVo.size() + "listVo의 개수");
    }






}
