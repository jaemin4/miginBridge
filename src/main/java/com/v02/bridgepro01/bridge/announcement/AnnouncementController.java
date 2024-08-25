package com.v02.bridgepro01.bridge.announcement;

import com.v02.bridgepro01.bridge.announcement.dto.NotifISaveDTO;
import com.v02.bridgepro01.bridge.common.status.PagingCulDTO;
import com.v02.bridgepro01.bridge.announcement.dto.NotifiUpdateDTO;
import com.v02.bridgepro01.bridge.announcement.vo.NotifiInfoVO;
import com.v02.bridgepro01.bridge.common.status.ControllerFunc;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequiredArgsConstructor
@RequestMapping("/announcement")
public class AnnouncementController {

    private final NotifiService notifiService;
    ControllerFunc controllerFunc = new ControllerFunc();

    //공지사항 전체 조회
    @GetMapping("/notifiInfoGet")
    public ResponseEntity<Map<String,Object>> getNotifiInfo(){
        List<NotifiInfoVO> listVO = notifiService.SelectNotifiInfo();
        return controllerFunc.selectAll(listVO,"payload");
    }

    //공지사항 상세 조회
    @GetMapping("/notifi/info/get/{id}")
    public ResponseEntity<Map<String,Object>> getNotifiInfoById(@PathVariable String id){
        NotifiInfoVO vo = notifiService.SelectByIdNotifiInfo(id);
        return controllerFunc.selectById(vo,"payload");
    }

    //공지사항 글 등록
    //파일 등록 처리 x
    @PostMapping("/notifi/info/save")
    public ResponseEntity savaNotifiInfo(@RequestBody NotifISaveDTO dto){
        int result = notifiService.SaveNotifiInfo(dto);
        return controllerFunc.insertByDto(result, dto.getNotifiId());
    }

    //공지사항 글 수정
    @PostMapping("/notifi/info/update")
    public ResponseEntity updateNotifiInfo(@RequestBody NotifiUpdateDTO dto) {
        int result = notifiService.UpdateNotifiInfo(dto);
        return controllerFunc.updateByDto(result, dto.getNotifiId());
    }

    //공지사항 글 페이징
    @GetMapping("/notifi/info/get/paging")
    public ResponseEntity <Map<String,Object>> getPagingNotifiInfo(@PageableDefault(size=10) Pageable pageable){

        Page<NotifiInfoVO> postByPageNumber = notifiService.SelectWithPaging(pageable);

        System.out.println(pageable.previousOrFirst().getPageNumber()+1);
        System.out.println(pageable.next().getPageNumber()+1);
        System.out.println(pageable.hasPrevious());
        System.out.println(postByPageNumber.hasNext());

        Map<String, Object> response = new HashMap<>();
        response.put("posts", postByPageNumber.getContent());
        response.put("prev", pageable.previousOrFirst().getPageNumber() + 1);
        response.put("next", pageable.next().getPageNumber() + 1);
        response.put("hasPrev", pageable.hasPrevious());
        response.put("hasNext", postByPageNumber.hasNext());
        response.put("totalPageCount", IntStream.rangeClosed(1, postByPageNumber.getTotalPages())
                .boxed()
                .collect(Collectors.toList()));

        return ResponseEntity.ok(response);
    }




}
