package com.app.core.include.page;
import com.app.core.include.basic.IBaseBean;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class IBaseWrapper<T> extends Wrapper<T> {
    private static Map<WhereTypeEnum, WhereFun> typeFunc;

    static {
        if (typeFunc == null) {
            typeFunc = new HashMap<>();
            typeFunc.put(WhereTypeEnum.EQ, (w, k, v) -> {
                w.eq(k, v);
            });
            typeFunc.put(WhereTypeEnum.NEQ, (w, k, v) -> {
                w.ne(k, v);
            });
            typeFunc.put(WhereTypeEnum.IN, (w, k, v) -> {
                if (v instanceof Collection) {
                    w.in(k, (Collection<?>) v);
                } else if (v instanceof Object[]) {
                    w.in(k, (Object[]) v);
                } else {
                    w.in(k, v.toString());
                }
            });
            typeFunc.put(WhereTypeEnum.LIKE, (w, k, v) -> {
                w.like(k, v.toString());
            });
            typeFunc.put(WhereTypeEnum.LE, (w, k, v) -> {
                w.le(k, v);
            });
            typeFunc.put(WhereTypeEnum.LT, (w, k, v) -> {
                w.lt(k, v);
            });
            typeFunc.put(WhereTypeEnum.GE, (w, k, v) -> {
                w.ge(k, v);
            });
            typeFunc.put(WhereTypeEnum.GT, (w, k, v) -> {
                w.gt(k, v);
            });
        }
    }

    public  EntityWrapper entityWrapper;

    public IBaseWrapper(){
        super();
    }
    public IBaseWrapper(T entity){
        super();
        EntityWrapper ew=new EntityWrapper();
        ew.setEntity(entity);
        this.entityWrapper=ew;
    }

    public  String getSqlSegment(){
        return null;
    }
    public Wrapper<T> execute(){
        T entity =(T)entityWrapper.getEntity();
        Field[] fields=entity.getClass().getDeclaredFields();
        entityWrapper.where("delete = {0}",0);//全局条件，0“未删除
        for (Field field: fields) {//反射获取字段信息

            field.setAccessible(true);
            try {

                Object value=field.get(entity);
                if (value != null && !"".equals(value.toString())) {
                    TableField tableField=field.getAnnotation(TableField.class);
                    WhereType whereType=field.getAnnotation(WhereType.class);
                    if (tableField == null) {
                        if (whereType == null) {
                            typeFunc.get(WhereTypeEnum.EQ).whereFunc(entityWrapper, field.getName(), value);
                        }else{
                            typeFunc.get(whereType).whereFunc(entityWrapper, field.getName(), value);
                        }
                    }else{
                        if (whereType == null) {
                            typeFunc.get(WhereTypeEnum.EQ).whereFunc(entityWrapper,tableField.value(), value);
                        }else{
                            typeFunc.get(whereType).whereFunc(entityWrapper, tableField.value(), value);
                        }

                    }

                    System.out.println();
                }
            }catch (Exception e){

            }


        }
        String name="wang";
        Integer age=16;
        entityWrapper.where("name = {0}",name).andNew("age > {0}",age).orderBy("age");
        return entityWrapper;
    }
    public static void main(String[] args) {
        IBaseBean bean =new IBaseBean();
        bean.setId(1);
        bean.setName("aaaaaaaaaa");
        IBaseWrapper iw=new IBaseWrapper(bean);
        iw.execute();
    }

}
