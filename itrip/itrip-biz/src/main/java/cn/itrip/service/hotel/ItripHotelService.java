package cn.itrip.service.hotel;

import cn.itrip.beans.pojo.ItripHotel;
import cn.itrip.beans.vo.comment.ItripListCommentVO;

import java.util.List;
import java.util.Map;

public interface ItripHotelService {

    public List<ItripHotel> getItripHotelListByMap(Map<String, Object> param)throws Exception;

    public Integer getItripHotelCountByMap(Map<String, Object> param)throws Exception;

    public ItripHotel getItipHotelById(Integer id)throws Exception;

    public ItripHotel getItipHotelBycityId(Integer cityId)throws Exception;

    public ItripHotel getItipHotelPolicyBycityId(Integer cityId)throws Exception;

    public ItripHotel getItripHotelNameById(Long id) throws Exception;


}
