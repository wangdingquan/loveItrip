package cn.itrip.service.video;

import cn.itrip.dao.video.ItripVideoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItripVideoServiceImpl implements ItripVideoService {

    @Resource
    private ItripVideoMapper itripVideoMapper;
    @Override
    public List<String> getFeatureList(Long cityId) {
        return itripVideoMapper.getFeatureList(cityId);
    }

    @Override
    public List<String> TradingAreaName(Long cityId) {
        return itripVideoMapper.TradingAreaName(cityId);
    }
}
