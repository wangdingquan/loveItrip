package cn.itrip.controller;

import cn.itrip.beans.dtos.Dto;
import cn.itrip.beans.pojo.*;
import cn.itrip.beans.vo.comment.ItripCountCommentVO;
import cn.itrip.beans.vo.comment.ItripListCommentVO;
import cn.itrip.beans.vo.comment.ItripScoreCommentVO;
import cn.itrip.beans.vo.comment.ItripSearchCommentVO;
import cn.itrip.common.Constants;
import cn.itrip.common.DtoUtil;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import cn.itrip.service.comment.ItripCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;


@Controller
@Api(value = "API", basePath = "/http://api.itrap.com/api")
@RequestMapping(value = "/api/comment")
public class HotelCommentController {

    private Logger logger = Logger.getLogger(HotelCommentController.class);

    @Resource
    private ItripCommentService itripCommentService;


    /****
     * 查询酒店评分
     *
     * @param
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询酒店评分", httpMethod = "GET",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "查询国内、国外的热门城市(1:国内 2:国外)" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>10201 : hotelId不能为空 </p>" +
            "<p>10202 : 系统异常,获取失败</p>")
    @RequestMapping(value = "/gethotelscore/{cityId}", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public Dto<ItripScoreCommentVO> gethotelscore(@PathVariable Long cityId) {
        ItripComment itripComment=null;
        ItripScoreCommentVO itripScoreCommentVOS = new ItripScoreCommentVO();
        if (EmptyUtils.isNotEmpty(cityId)) {
            try {
                itripComment = itripCommentService.getItripCommentByScore(cityId);
                itripScoreCommentVOS.setAvgFacilitiesScore(itripComment.getFacilitiesScore());
                itripScoreCommentVOS.setAvgHygieneScore(itripComment.getHygieneScore());
                itripScoreCommentVOS.setAvgPositionScore(itripComment.getPositionScore());
                itripScoreCommentVOS.setAvgServiceScore(itripComment.getServiceScore());
                itripScoreCommentVOS.setAvgScore(itripComment.getScore());

            } catch (Exception e1) {
                DtoUtil.returnFail("系统异常", "10202");
                e1.printStackTrace();
            }

        }
        return DtoUtil.returnSuccess("获取评分成功",itripScoreCommentVOS);
    }


    /****
     * 查询酒店评分
     *
     * @param
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询评论数量", httpMethod = "GET",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "查询国内、国外的热门城市(1:国内 2:国外)" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>10201 : hotelId不能为空 </p>" +
            "<p>10202 : 系统异常,获取失败</p>")
    @RequestMapping(value = "/getcount/{cityId}", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public Dto<ItripCountCommentVO> getcount(@PathVariable Long cityId)throws Exception {
        ItripCountCommentVO itripCountCommentVOS = null;
        itripCountCommentVOS = itripCommentService.getItripCommentByHotelId(cityId);
        return DtoUtil.returnSuccess("获取酒店各类评论数成功",itripCountCommentVOS);
    }


    /****
     * 查询评论内容列表
     *
     * @param
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询评论内容列表", httpMethod = "GET",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "查询国内、国外的热门城市(1:国内 2:国外)" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>10201 : hotelId不能为空 </p>" +
            "<p>10202 : 系统异常,获取失败</p>")
    @RequestMapping(value = "/getcommentlist", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public Dto<Page<ItripListCommentVO>>  getcommentlist(@RequestBody ItripSearchCommentVO itripSearchCommentVO)throws Exception {
        List<ItripListCommentVO> itripListCommentVOS = null;
        Page<ItripListCommentVO> itripListCommentVOPage = new Page<ItripListCommentVO>();
        List<ItripComment> itripComments=null;
        try {
                   ItripComment itripComment=new ItripComment();


        } catch (Exception e) {
            DtoUtil.returnFail("系统异常", "10202");
            e.printStackTrace();
        }

        //itripCountCommentVOS = itripCommentService.getItripCommentByHotelId(cityId);
        return DtoUtil.returnSuccess("获取酒店评论内容列表成功",null);
    }



/*
    //设置起始页
    Integer rows = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
    Integer currPage = (EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO - 1 : pageNo);
    Integer start = currPage*rows;
        query.setStart(start);//设置查询结果的起始位置
        query.setRows(rows);//一页显示多少
    //solr客户端对象请求solr服务,得到一个响应对象
    QueryResponse queryResponse = httpSolrClient.query(query);
    //封装了多条数据的document集合
    SolrDocumentList docs = queryResponse.getResults();
    //把结果封装成一个page对象
    Page<T> page = new Page(currPage + 1, query.getRows(),
            new Long(docs.getNumFound()).intValue());
    //从响应中取出数据
    List<T> list = queryResponse.getBeans(clazz);
        page.setRows(list);
        return page;
*/


/*    @ApiOperation(value = "查询酒店视频信息", httpMethod = "GET",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "查询国内、国外的热门城市(1:国内 2:国外)" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>10201 : hotelId不能为空 </p>" +
            "<p>10202 : 系统异常,获取失败</p>")
    @RequestMapping(value = "/getvideodesc/{cityId}", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public Dto<HotelVideoDescVO> getvideodesc(@PathVariable Long cityId) {
        HotelVideoDescVO hotelVideoDescVOS=new HotelVideoDescVO();
        List<String> getFeatureList=null;
        List<String> TradingNameList=null;
        ItripHotel itripHotel=null;

        try {
            if (EmptyUtils.isNotEmpty(cityId)) {
                getFeatureList=itripVideoService.getFeatureList(cityId);
                TradingNameList=itripVideoService.TradingAreaName(cityId);
                itripHotel=itripHotelService.getItripHotelNameById(cityId);

                hotelVideoDescVOS.setHotelFeatureList(getFeatureList);
                hotelVideoDescVOS.setTradingAreaNameList(TradingNameList);
                hotelVideoDescVOS.setHotelName(itripHotel.getHotelName());

            } else {
                DtoUtil.returnFail("cityId不能为空", "10201");
            }
        } catch (Exception e) {
            DtoUtil.returnFail("系统异常", "10202");
            e.printStackTrace();
        }
        return DtoUtil.returnDataSuccess(hotelVideoDescVOS);

    }*/
}


