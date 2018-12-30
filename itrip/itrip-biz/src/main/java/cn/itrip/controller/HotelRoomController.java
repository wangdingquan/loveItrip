package cn.itrip.controller;

import cn.itrip.beans.dtos.Dto;
import cn.itrip.beans.pojo.ItripAreaDic;
import cn.itrip.beans.pojo.ItripHotelRoom;
import cn.itrip.beans.pojo.ItripImage;
import cn.itrip.beans.pojo.ItripLabelDic;
import cn.itrip.beans.vo.ItripAreaDicVO;
import cn.itrip.beans.vo.ItripImageVO;
import cn.itrip.beans.vo.ItripLabelDicVO;
import cn.itrip.beans.vo.hotelroom.ItripHotelRoomVO;
import cn.itrip.common.DtoUtil;
import cn.itrip.common.EmptyUtils;
import cn.itrip.service.image.ItripImageService;
import cn.itrip.service.labeldic.ItripLabelDicService;
import cn.itrip.service.room.HotelRoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(value = "API", basePath = "/http://api.itrap.com/api")
@RequestMapping(value = "/api/hotelroom")
public class HotelRoomController {

    private Logger logger = Logger.getLogger(HotelRoomController.class);

    @Resource
    private HotelRoomService hotelRoomService;


    @Resource
    private ItripImageService itripImageService;


    @Resource
    private ItripLabelDicService itripLabelDicService;

    /****
     * 查询酒店房型的图片
     *
     * @param roomId
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询酒店房型的图片", httpMethod = "GET",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "查询国内、国外的热门城市(1:国内 2:国外)" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>10201 : hotelId不能为空 </p>" +
            "<p>10202 : 系统异常,获取失败</p>")
    @RequestMapping(value = "/getimg/{roomId}", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public Dto<ItripImageVO> getimg(@PathVariable Long roomId) {
        List<ItripImage> itripImages = null;
        List<ItripImageVO> itripImageVOS = null;
        if (EmptyUtils.isNotEmpty(roomId)) {
            try {
                itripImages = itripImageService.getItripImageURLById(roomId);
                if (EmptyUtils.isNotEmpty(itripImages)) {
                    itripImageVOS = new ArrayList();
                    for (ItripImage dic : itripImages) {
                        ItripImageVO vo = new ItripImageVO();
                        BeanUtils.copyProperties(dic, vo);
                        itripImageVOS.add(vo);
                    }
                }

            } catch (Exception e1) {
                DtoUtil.returnFail("系统异常", "10202");
                e1.printStackTrace();
            }

        }
        return DtoUtil.returnSuccess("获取酒店图片房型成功", itripImageVOS);
    }


    /***
     * 查询酒店特色列表
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询酒店特色列表", httpMethod = "GET",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "获取酒店特色(用于查询页列表)" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码: </p>" +
            "<p>10205: 系统异常,获取失败</p>")
    @RequestMapping(value = "/queryhotelroombed", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public Dto<ItripLabelDicVO> queryhotelroombed() {
        List<ItripLabelDic> itripLabelDics = null;
        List<ItripLabelDicVO> itripAreaDicVOs = null;
        try {
            Map param = new HashMap();
            param.put("parentId", 1);
            itripLabelDics = itripLabelDicService.getItripLabelDicListByMap(param);
            if (EmptyUtils.isNotEmpty(itripLabelDics)) {
                itripAreaDicVOs = new ArrayList();
                for (ItripLabelDic dic : itripLabelDics) {
                    ItripLabelDicVO vo = new ItripLabelDicVO();
                    BeanUtils.copyProperties(dic, vo);
                    itripAreaDicVOs.add(vo);
                }
            }

        } catch (Exception e) {
            DtoUtil.returnFail("系统异常", "10205");
            e.printStackTrace();
        }
        return DtoUtil.returnSuccess("获取成功",itripAreaDicVOs);
    }



    /***
     * 查询酒店房型列表
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询酒店房型列表", httpMethod = "GET",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "获取酒店特色(用于查询页列表)" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码: </p>" +
            "<p>10205: 系统异常,获取失败</p>")
    @RequestMapping(value = "/queryhotelroombyhotel", produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public Dto<ItripHotelRoomVO> queryhotelroombyhotel() {
        List<ItripHotelRoom> itripHotelRooms = null;
        List<ItripHotelRoomVO> itripHotelRoomVOS = null;
        try {
            itripHotelRooms = hotelRoomService.getItripqueryHotelRoom();
            if (EmptyUtils.isNotEmpty(itripHotelRooms)) {
                itripHotelRoomVOS = new ArrayList();
                for (ItripHotelRoom dic : itripHotelRooms) {
                    ItripHotelRoomVO vo = new ItripHotelRoomVO();
                    BeanUtils.copyProperties(dic, vo);
                    itripHotelRoomVOS.add(vo);
                }
            }

        } catch (Exception e) {
            DtoUtil.returnFail("系统异常", "10205");
            e.printStackTrace();
        }
        return DtoUtil.returnSuccess("获取成功",itripHotelRoomVOS);
    }


}


