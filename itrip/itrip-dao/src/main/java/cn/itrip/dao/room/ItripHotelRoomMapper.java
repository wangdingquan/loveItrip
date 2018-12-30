package cn.itrip.dao.room;

import cn.itrip.beans.pojo.ItripHotelRoom;
import cn.itrip.beans.vo.comment.ItripListCommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItripHotelRoomMapper {

    public ItripHotelRoom getItripHotelRoomById(@Param(value = "id") Long id)throws Exception;

    public List<ItripHotelRoom> getItripHotelBedByMap(Map<String, Object> param) throws Exception;

    public List<ItripHotelRoom> getItripqueryHotelRoom() throws Exception;

}
