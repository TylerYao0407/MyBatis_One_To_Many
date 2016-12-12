package com.tyler.mapper;

import com.tyler.pojo.Son;

import java.util.List;

/**
 * Created by tyler on 2016/12/12.
 */
public interface SonMapper {
    public Son selectSon(int id);
    public int addSon(List<Son> sons);
    public int deleteSon(int id);
    public int updateSon(Son son);
}
