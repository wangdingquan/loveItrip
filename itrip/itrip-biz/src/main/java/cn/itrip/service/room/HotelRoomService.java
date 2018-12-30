package cn.itrip.service.room;

import cn.itrip.beans.pojo.ItripHotelRoom;
import cn.itrip.beans.vo.comment.ItripListCommentVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface HotelRoomService {

    public ItripHotelRoom getItripHotelRoomById(Long id)throws Exception;

    public List<ItripHotelRoom> getItripqueryHotelRoom() throws Exception;
}
