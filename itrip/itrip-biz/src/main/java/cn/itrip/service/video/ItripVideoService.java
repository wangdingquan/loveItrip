package cn.itrip.service.video;

import java.util.List;

public interface ItripVideoService {

    public List<String> getFeatureList(Long cityId);

    public  List<String> TradingAreaName(Long cityId);
}
