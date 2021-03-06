package com.app.core.include.basic;


import com.app.core.include.page.IBaseWrapper;
import com.app.core.include.page.WhereType;
import com.app.core.include.page.WhereTypeEnum;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.mapper.Wrapper;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础Bean
 *
 * @author Jang
 */
public class IBaseBean extends Model {

    private static final long serialVersionUID = 1L;

    private int id;
    @WhereType(type = WhereTypeEnum.LIKE)
    private String name;
    private Boolean delete;
    private Date date_modified;
    private Date date_entered;
    private int created_by;

    private String table_name;

    @Override
    public  Serializable pkVal(){
        return this.id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public Date getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(Date date_modified) {
        this.date_modified = date_modified;
    }

    public Date getDate_entered() {
        return date_entered;
    }

    public void setDate_entered(Date date_entered) {
        this.date_entered = date_entered;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public Wrapper getPageWrapper(){

        IBaseWrapper iBaseWrapper=new IBaseWrapper<IBaseBean>(this);
        return iBaseWrapper.execute();
    }
}
