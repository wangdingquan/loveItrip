package cn.itrip.dao.video;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItripVideoMapper {

    public List<String> getFeatureList(@Param(value = "id")Long cityId);

    public  List<String> TradingAreaName(@Param(value = "id")Long cityId);
}
