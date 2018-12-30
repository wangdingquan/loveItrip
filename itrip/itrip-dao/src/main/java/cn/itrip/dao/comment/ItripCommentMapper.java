package cn.itrip.dao.comment;

import cn.itrip.beans.pojo.ItripComment;
import cn.itrip.beans.vo.comment.ItripCountCommentVO;
import cn.itrip.beans.vo.comment.ItripListCommentVO;
import cn.itrip.beans.vo.comment.ItripSearchCommentVO;
import cn.itrip.common.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItripCommentMapper {

    public ItripComment getItripCommentByScore(@Param("hotelId") Long hotelId);

    public Page<ItripSearchCommentVO> queryItripCommentPageByMap(Map<String, Object> param, Integer pageNo, Integer pageSize)throws Exception;

    public ItripCountCommentVO getItripCommentByHotelId(@Param("hotelId") Long hotelId)throws Exception;

    public List<ItripListCommentVO> getItripCommentListInfo(ItripComment itripComment) throws Exception;
}
