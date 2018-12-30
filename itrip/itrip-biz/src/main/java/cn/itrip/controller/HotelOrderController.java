package cn.itrip.controller;

import cn.itrip.beans.dtos.Dto;
import cn.itrip.beans.pojo.ItripHotelOrder;
import cn.itrip.beans.vo.order.ItripPersonalHotelOrderVO;
import cn.itrip.common.DtoUtil;
import cn.itrip.common.EmptyUtils;
import cn.itrip.service.order.ItripOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(value = "API", basePath = "/http://api.itrap.com/api")
@RequestMapping(value = "/api/hotelorder")
public class HotelOrderController {

    private Logger logger = Logger.getLogger(HotelOrderController.class);

    @Resource
    private ItripOrderService itripOrderService;



    /****
     * 查询个人订单信息
     *
     * @param orderId
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询个人订单信息", httpMethod = "GET",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "查询国内、国外的热门城市(1:国内 2:国外)" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>10201 : hotelId不能为空 </p>" +
            "<p>10202 : 系统异常,获取失败</p>")
    @RequestMapping(value = "/getpersonalorderinfo/{orderId}", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public Dto<ItripPersonalHotelOrderVO> getpersonalorderinfo(@PathVariable Integer orderId) {
        List<ItripHotelOrder> itripHotelOrders = null;
        ItripPersonalHotelOrderVO itripPersonalHotelOrderVO1=new ItripPersonalHotelOrderVO();
        try {
            if (EmptyUtils.isNotEmpty(orderId)) {
                Map param=new HashMap<>();
                param.put("id",orderId);
                itripHotelOrders = itripOrderService.getOrderInfo(param);
                if (EmptyUtils.isNotEmpty(itripHotelOrders)) {
                    for (ItripHotelOrder itripHotelOrder : itripHotelOrders) {
                        itripPersonalHotelOrderVO1.setId(itripHotelOrder.getId());
                        itripPersonalHotelOrderVO1.setBookType(itripHotelOrder.getBookType());
                        itripPersonalHotelOrderVO1.setCreationDate(itripHotelOrder.getCreationDate());
                        itripPersonalHotelOrderVO1.setOrderNo(itripHotelOrder.getOrderNo());
                        itripPersonalHotelOrderVO1.setPayAmount(itripHotelOrder.getPayAmount());
                        itripPersonalHotelOrderVO1.setRoomPayType(1);
                        itripPersonalHotelOrderVO1.setPayType(itripHotelOrder.getPayType());
                        itripPersonalHotelOrderVO1.setNoticePhone(itripHotelOrder.getNoticePhone());
                        itripPersonalHotelOrderVO1.setOrderStatus(itripHotelOrder.getOrderStatus());
                    }




                }


                /**
                 * 订单流程:
                 * 1、待付款、待评价（已消费）、未出行（支付成功）
                 * 流程: 已提交-->待支付-->支付成功-->已入住-->已点评
                 * 2、已取消
                 * 流程: 已提交-->待支付-->已取消
                 */
                if(itripPersonalHotelOrderVO1.getOrderStatus()==0)
                {
                    itripPersonalHotelOrderVO1.setProcessNode("2");
                    itripPersonalHotelOrderVO1.setOrderProcess("已提交-->待支付");
                }
                else if(itripPersonalHotelOrderVO1.getOrderStatus()==1)
                {
                    itripPersonalHotelOrderVO1.setProcessNode("3");
                    itripPersonalHotelOrderVO1.setOrderProcess("已提交-->待支付-->已取消");
                }
                else if(itripPersonalHotelOrderVO1.getOrderStatus()==2)
                {
                    itripPersonalHotelOrderVO1.setProcessNode("3");
                    itripPersonalHotelOrderVO1.setOrderProcess(" 已提交-->待支付-->支付成功");
                }
                else
                {
                    itripPersonalHotelOrderVO1.setProcessNode("4");
                    itripPersonalHotelOrderVO1.setOrderProcess(" 已提交-->待支付-->支付成功-->已入住-->已点评");
                }



            } else {
                DtoUtil.returnFail("orderId不能为空", "10201");
            }
        } catch (Exception e) {
            DtoUtil.returnFail("系统异常", "10202");
            e.printStackTrace();
        }
        return DtoUtil.returnSuccess("获取个人订单信息成功", itripPersonalHotelOrderVO1);
    }

}


