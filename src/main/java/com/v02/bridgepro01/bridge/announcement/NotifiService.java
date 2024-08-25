package com.v02.bridgepro01.bridge.announcement;

import com.v02.bridgepro01.bridge.announcement.dto.NotifISaveDTO;
import com.v02.bridgepro01.bridge.announcement.dto.NotifiUpdateDTO;
import com.v02.bridgepro01.bridge.announcement.vo.NotifiInfoVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NotifiService {

    List<NotifiInfoVO> SelectNotifiInfo();

    NotifiInfoVO SelectByIdNotifiInfo(String id);

    int SaveNotifiInfo(NotifISaveDTO dto);

    int UpdateNotifiInfo(NotifiUpdateDTO dto);

    Page<NotifiInfoVO> SelectWithPaging(Pageable pageable);


    int CountSelectAll();




}
