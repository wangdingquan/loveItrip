package cn.itrip.service.hotel;

import cn.itrip.beans.pojo.ItripHotel;
import cn.itrip.beans.vo.comment.ItripListCommentVO;
import cn.itrip.dao.hotel.ItripHotelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ItripHotelServiceImpl implements ItripHotelService {

    @Resource
    private ItripHotelMapper itripHotelMapper;
    @Override
    public List<ItripHotel> getItripHotelListByMap(Map<String, Object> param) throws Exception {
        return itripHotelMapper.getItripHotelListByMap(param);
    }

    @Override
    public Integer getItripHotelCountByMap(Map<String, Object> param) throws Exception {
        return null;
    }

    @Override
    public ItripHotel getItipHotelById(Integer id) throws Exception {
        return itripHotelMapper.getItipHotelById(id);
    }

    @Override
    public ItripHotel getItipHotelBycityId(Integer cityId) throws Exception {
        return itripHotelMapper.getItipHotelBycityId(cityId);
    }

    @Override
    public ItripHotel getItipHotelPolicyBycityId(Integer cityId) throws Exception {
        return itripHotelMapper.getItipHotelPolicyBycityId(cityId);
    }

    @Override
    public ItripHotel getItripHotelNameById(Long id) throws Exception {
        return itripHotelMapper.getItripHotelNameById(id);
    }

}
