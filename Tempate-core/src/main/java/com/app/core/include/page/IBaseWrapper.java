package com.app.core.include.page;
import com.baomidou.mybatisplus.mapper.Wrapper;

public class IBaseWrapper<T> extends Wrapper<T> {
    public  String getSqlSegment(){
        return null;
    }

}
