package cn.itrip.dao.image;

import cn.itrip.beans.pojo.ItripImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItripImageMapper {

    public List<ItripImage> getItripImageURLById(@Param("id") Long id) throws Exception;
}
