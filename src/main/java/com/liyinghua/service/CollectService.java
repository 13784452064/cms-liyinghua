package com.liyinghua.service;

import com.github.pagehelper.PageInfo;
import com.liyinghua.entity.Collect;

public interface CollectService {
	Integer addCollect(Collect col);

	PageInfo<Collect> getUserCollectByUserId(Integer userId, Integer fy);

	Integer del(Integer id);
}
