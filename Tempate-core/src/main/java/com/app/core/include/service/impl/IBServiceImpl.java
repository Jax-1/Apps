package com.app.core.include.service.impl;

import com.app.core.include.basic.IBaseBean;
import com.app.core.include.mapper.IBaseMapper;
import com.app.core.include.service.IBService;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

public abstract class IBServiceImpl<M extends BaseMapper<T>,T> extends ServiceImpl<M,T> {
}
