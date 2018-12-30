package cn.itrip.service.image;

import cn.itrip.beans.pojo.ItripImage;

import java.util.List;


public interface ItripImageService {

    public List<ItripImage> getItripImageURLById(Long  id) throws Exception;

}
