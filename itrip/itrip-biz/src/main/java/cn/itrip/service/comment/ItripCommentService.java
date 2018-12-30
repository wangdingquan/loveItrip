package cn.itrip.service.comment;

import cn.itrip.beans.pojo.ItripComment;
import cn.itrip.beans.vo.comment.ItripCountCommentVO;
import cn.itrip.beans.vo.comment.ItripListCommentVO;
import cn.itrip.beans.vo.comment.ItripSearchCommentVO;
import cn.itrip.common.Page;

import java.util.List;
import java.util.Map;

public interface ItripCommentService {

    public ItripComment getItripCommentByScore(Long hotelId) throws  Exception;


    public Page<ItripSearchCommentVO> queryItripCommentPageByMap(Map<String, Object> param, Integer pageNo, Integer pageSize)throws Exception;

    public ItripCountCommentVO getItripCommentByHotelId(Long hotelId)throws Exception;

    public List<ItripListCommentVO> getItripCommentListInfo(ItripComment itripComment) throws Exception;


}
