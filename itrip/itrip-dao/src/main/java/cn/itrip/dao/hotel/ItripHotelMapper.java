package cn.itrip.dao.hotel;

import cn.itrip.beans.pojo.ItripHotel;
import cn.itrip.beans.vo.comment.ItripListCommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItripHotelMapper {

    public List<ItripHotel> getItripHotelListByMap(Map<String, Object> param);

    public ItripHotel getItipHotelById(@Param("id") Integer id)throws Exception;

    public ItripHotel getItipHotelBycityId(@Param("cityId") Integer cityId)throws Exception;

    public ItripHotel getItipHotelPolicyBycityId(@Param("cityId") Integer cityId)throws Exception;

    public ItripHotel getItripHotelNameById(@Param("id") Long id) throws  Exception;

    public Integer getItripHotelCountByMap(Map<String, Object> param)throws Exception;


}
