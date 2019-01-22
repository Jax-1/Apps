package com.app.core.include.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.util.ObjectUtils;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;

public interface IBaseMapper<T> extends BaseMapper<T> {
    /**
     * <p>
     * 翻页查询
     * </p>
     *
     * @param page         翻页对象
     * @param queryWrapper 实体对象封装操作类
     * {@link com.baomidou.mybatisplus}
     */
    Page<T> page(Page<T> page, Wrapper<T> queryWrapper);

}
