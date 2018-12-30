package cn.itrip.service.image;

import cn.itrip.beans.pojo.ItripImage;
import cn.itrip.dao.image.ItripImageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItripImageServiceImpl implements ItripImageService {

    @Resource
    private ItripImageMapper itripImageMapper;

    @Override
    public List<ItripImage> getItripImageURLById(Long  id) throws Exception {
        return itripImageMapper.getItripImageURLById(id);
    }
}
