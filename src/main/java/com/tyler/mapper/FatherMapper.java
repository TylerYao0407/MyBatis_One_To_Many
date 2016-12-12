package com.tyler.mapper;

import com.tyler.pojo.Father;

/**
 * Created by tyler on 2016/12/12.
 */
public interface FatherMapper {
    public Father selectFather(int id);
    public int addFather(Father father);
    public int deleteFather(int id);
}
