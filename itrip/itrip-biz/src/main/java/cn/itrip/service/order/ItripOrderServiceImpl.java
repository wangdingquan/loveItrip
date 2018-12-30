package cn.itrip.service.order;

import cn.itrip.beans.pojo.ItripHotelOrder;
import cn.itrip.beans.vo.comment.ItripListCommentVO;
import cn.itrip.beans.vo.order.ItripPersonalHotelOrderVO;
import cn.itrip.dao.order.ItripOrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ItripOrderServiceImpl implements ItripOrderService {

    @Resource
    private ItripOrderMapper itripOrderMapper;


    @Override
    public List<ItripHotelOrder> getOrderInfo(Map<String, Object> param) {
        return itripOrderMapper.getOrderInfo(param);
    }
}
