package cn.itrip.service.comment;

import cn.itrip.beans.pojo.ItripComment;
import cn.itrip.beans.vo.comment.ItripCountCommentVO;
import cn.itrip.beans.vo.comment.ItripListCommentVO;
import cn.itrip.beans.vo.comment.ItripSearchCommentVO;
import cn.itrip.common.Page;
import cn.itrip.dao.comment.ItripCommentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ItripCommentServiceImpl implements ItripCommentService {

    @Resource
    private ItripCommentMapper itripCommentMapper;

    @Override
    public ItripComment getItripCommentByScore(Long hotelId) {
        return itripCommentMapper.getItripCommentByScore(hotelId);
    }

    @Override
    public Page<ItripSearchCommentVO> queryItripCommentPageByMap(Map<String, Object> param, Integer pageNo, Integer pageSize) throws Exception {
        return itripCommentMapper.queryItripCommentPageByMap(param,pageNo,pageSize);
    }

    @Override
    public ItripCountCommentVO getItripCommentByHotelId(Long hotelId) throws Exception {
        return itripCommentMapper.getItripCommentByHotelId(hotelId);
    }

    @Override
    public List<ItripListCommentVO> getItripCommentListInfo(ItripComment itripComment) throws Exception {
        return null;
    }


}
