package cn.itrip.service.room;

import cn.itrip.beans.pojo.ItripHotelRoom;
import cn.itrip.beans.vo.comment.ItripListCommentVO;
import cn.itrip.dao.room.ItripHotelRoomMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class HotelRoomServiceImpl implements HotelRoomService {


    @Resource
    private ItripHotelRoomMapper itripHotelRoomMapper;

    @Override
    public ItripHotelRoom getItripHotelRoomById(Long id) throws Exception {
        return itripHotelRoomMapper.getItripHotelRoomById(id);
    }

    @Override
    public List<ItripHotelRoom> getItripqueryHotelRoom() throws Exception {
        return itripHotelRoomMapper.getItripqueryHotelRoom();
    }


}
