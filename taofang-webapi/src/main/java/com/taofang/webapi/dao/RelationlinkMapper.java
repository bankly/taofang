package com.taofang.webapi.dao;

import com.taofang.webapi.model.Relationlink;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RelationlinkMapper {

    @Select({
            "select id, LinkTitle, LinkUrl",
            "from RelationLink",
            "where SourceType = 1"
    })
    @ResultMap("BaseResultMap")
    List<Relationlink> selectHealthInfoLink();

}