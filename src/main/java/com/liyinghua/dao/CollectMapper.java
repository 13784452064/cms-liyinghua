package com.liyinghua.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liyinghua.entity.Collect;

public interface CollectMapper {

	public Integer addCollect(Collect col);

	public List<Collect> getUserCollectByUserId(@Param("userId")Integer userId);

	public Integer del(@Param("id")Integer id);

}
