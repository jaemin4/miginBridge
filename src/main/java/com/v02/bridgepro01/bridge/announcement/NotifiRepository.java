package com.v02.bridgepro01.bridge.announcement;

import com.v02.bridgepro01.bridge.announcement.dto.NotifISaveDTO;
import com.v02.bridgepro01.bridge.announcement.dto.NotifiUpdateDTO;
import com.v02.bridgepro01.bridge.announcement.vo.NotifiInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface NotifiRepository {

    @Transactional
    List<NotifiInfoVO> SelectNotifiInfo();

    @Transactional
    NotifiInfoVO SelectByIdNotifiInfo(String id);

    @Transactional
    int SaveNotifiInfo(NotifISaveDTO dto);

    @Transactional
    int UpdateNotifiInfo(NotifiUpdateDTO dto);

    @Transactional
    List<NotifiInfoVO> SelectWithPaging(@Param("pageSize") int pageSize,@Param("offset") Long offset );

    int CountSelectAll();




}
