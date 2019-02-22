package com.springbootmybatisplus.mht.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.app.core.include.controller.IController;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.springbootmybatisplus.mht.service.SysUserInfoService;
import com.springbootmybatisplus.mht.entity.SysUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.annotations.*;
import java.util.Date;

import com.app.core.include.result.ProcessResult;

/**
 *　　
 *   @description : SysUserInfo 控制器
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-02-22
 */
@RestController
@Api(value="/sysUserInfo", description="SysUserInfo 控制器")
@RequestMapping("/sysUserInfo")
public class SysUserInfoController extends IController {
    private final Logger logger = LoggerFactory.getLogger(SysUserInfoController.class);

    @Autowired
    public SysUserInfoService sysUserInfoService;

    /**
     * @description : 获取分页列表
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-02-22
     */
    @GetMapping("/getSysUserInfoList")
    @ApiOperation(value="/getSysUserInfoList", notes="获取分页列表")
    public ProcessResult<SysUserInfo> getSysUserInfoList(@ApiParam(name="SysUserInfo",value="SysUserInfo 实体类")SysUserInfo param ,
                                @ApiParam(name="length",value="页大小",required=true,defaultValue = "10")Integer length,
                                @ApiParam(name="pageNo",value="页数",required=true,defaultValue = "1")Integer pageNo) {
            ProcessResult<SysUserInfo> resJson=new ProcessResult<>();

            try {
                Page<SysUserInfo> page=new Page<SysUserInfo>(pageNo,length);
                sysUserInfoService.selectPage(page, param.getPageWrapper());
                resJson.setRecordsTotal(page.getTotal());
                resJson.setDatas(page.getRecords());
                resJson.setRes(true);
            }catch (Exception e){
                resJson.setRes(false);
                resJson.setResult("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }

    /**
     * @description : 通过id获取SysUserInfo
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-02-22
     */
    @GetMapping("/getSysUserInfoById")
    @ApiOperation(value="/getSysUserInfoById", notes="通过id获取SysUserInfo")
    public ProcessResult<SysUserInfo> getSysUserInfoById(@ApiParam(name="id",value="SysUserInfoID",required=true)Long id) {
            ProcessResult<SysUserInfo> resJson = new ProcessResult<>();
            try {
                SysUserInfo param= sysUserInfoService.selectById(id);
                resJson.setData(param);
                resJson.setRes(true);
            }catch (Exception e) {
                resJson.setRes(false);
                resJson.setResult("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }

    /**
     * @description : 通过id删除SysUserInfo
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-02-22
     */
    @DeleteMapping("/deleteSysUserInfoById")
    @ApiOperation(value="/deleteSysUserInfoById", notes="通过id删除SysUserInfo")
    public ProcessResult<SysUserInfo> deleteSysUserInfoById(@ApiParam(name="id",value="SysUserInfoID",required=true)Long id) {
            ProcessResult<SysUserInfo> resJson = new ProcessResult<>();
            try{
                resJson.setRes(sysUserInfoService.deleteById(id));
            }catch (Exception e) {
                resJson.setRes(false);
                resJson.setResult("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }

    /**
     * @description : 通过id更新SysUserInfo
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-02-22
     */
    @PutMapping("/updateSysUserInfoById")
    @ApiOperation(value="/updateSysUserInfoById", notes="通过id更新SysUserInfo")
    public ProcessResult<SysUserInfo> updateSysUserInfoById(@ApiParam(name="SysUserInfo",value="SysUserInfo 实体类")SysUserInfo param) {
            ProcessResult<SysUserInfo> resJson = new ProcessResult<>();
            try{
                resJson.setRes(sysUserInfoService.updateById(param));
            }catch (Exception e) {
                resJson.setRes(false);
                resJson.setResult("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }

    /**
     * @description : 添加SysUserInfo
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-02-22
     */
	@PutMapping("/addSysUserInfo")
    @ApiOperation(value="/addSysUserInfo", notes="添加SysUserInfo")
    public ProcessResult<SysUserInfo> addSysUserInfo(@ApiParam(name="SysUserInfo",value="SysUserInfo 实体类")SysUserInfo param) {
            ProcessResult<SysUserInfo> resJson = new ProcessResult<>();
            try{
                resJson.setRes(sysUserInfoService.insert(param));
            }catch (Exception e) {
                resJson.setRes(false);
                resJson.setResult("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }
}
