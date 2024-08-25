package com.v02.bridgepro01.bridge.announcement;

import com.v02.bridgepro01.bridge.announcement.dto.NotifISaveDTO;
import com.v02.bridgepro01.bridge.announcement.dto.NotifiUpdateDTO;
import com.v02.bridgepro01.bridge.announcement.vo.NotifiInfoVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotifiServiceImpl implements NotifiService
{

    private final NotifiRepository notifiRepository;

    @Override
    public List<NotifiInfoVO> SelectNotifiInfo() {
        return notifiRepository.SelectNotifiInfo();
    }

    @Override
    public NotifiInfoVO SelectByIdNotifiInfo(String id) {
        return notifiRepository.SelectByIdNotifiInfo(id);
    }

    @Override
    public int SaveNotifiInfo(NotifISaveDTO dto) {
        return notifiRepository.SaveNotifiInfo(dto);
    }

    @Override
    public int UpdateNotifiInfo(NotifiUpdateDTO dto) {
       return notifiRepository.UpdateNotifiInfo(dto);
    }

    @Override
    public Page<NotifiInfoVO> SelectWithPaging(Pageable pageable) {
        List<NotifiInfoVO> postByPageNumber =
                notifiRepository.SelectWithPaging(pageable.getPageSize(), pageable.getOffset());
        int totalPost = notifiRepository.CountSelectAll();


        return new PageImpl<>(postByPageNumber,pageable,totalPost);
    }

    @Override
    public int CountSelectAll() {
        return 0;
    }
}
