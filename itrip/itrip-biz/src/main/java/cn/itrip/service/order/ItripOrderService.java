package cn.itrip.service.order;

import cn.itrip.beans.pojo.ItripHotelOrder;
import cn.itrip.beans.vo.comment.ItripListCommentVO;
import cn.itrip.beans.vo.order.ItripPersonalHotelOrderVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItripOrderService {

     public List<ItripHotelOrder> getOrderInfo(Map<String, Object> param);
}
