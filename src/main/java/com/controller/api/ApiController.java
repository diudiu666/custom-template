package com.controller.api;

import com.entity.api.DeleteParam;
import com.entity.api.SaveOrUpdateParam;
import com.entity.api.SelectParam;
import com.entity.base.AjaxResult;
import com.entity.base.PagedQueryResult;
import com.service.api.ApiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static com.google.common.io.Files.createParentDirs;
import static com.google.common.io.Files.write;

/**
 * 自定义拼接sql控制层
 * */
@RestController
public class ApiController {

    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    /**
     * 自定义查询接口
     * @param selectParam
     * @return PagedQueryResult<Map<String,Object>>
     * */
    @PostMapping("select")
    public AjaxResult<PagedQueryResult<Map<String,Object>>> select(@RequestBody SelectParam selectParam){
        if(null != selectParam.getPage() &&null!=selectParam.getLimit()){
            selectParam.setStart((selectParam.getPage()-1)*selectParam.getLimit());
        }
        return new AjaxResult<PagedQueryResult<Map<String,Object>>>().setData(apiService.select(selectParam));
    }

    /**
     * 自定义新增和修改接口(提供data和mapData两种传参)
     * @param saveOrUpdateParam
     * @return Boolean
     * @author muggle.wang
     * Create in 2022/2/10 13:16
     **/
    @PostMapping("saveOrUpdate")
    public AjaxResult<Boolean> saveOrUpdate(@RequestBody SaveOrUpdateParam saveOrUpdateParam) {
        return new AjaxResult<Boolean>().setData(apiService.saveOrUpdate(saveOrUpdateParam));
    }

    /**
     * 自定义删除接口
     * @param deleteParam
     * @return Boolean
     * @author muggle.wang
     * Create in 2022/2/10 13:16
     **/
    @PostMapping("delete")
    public AjaxResult<Boolean> delete(@RequestBody DeleteParam deleteParam) {
        return new AjaxResult<Boolean>().setData(apiService.delete(deleteParam));
    }

    /**
     * 上传路径前缀(后续有需要可以把这个参数开放给前端)
     * */
    @Value("${sys.file.upload.path}")
    public String uploadPath;

    /**
     * 预览下载路径前缀
     * */
    @Value("${sys.file.upload.relative}")
    public String relative;

    /**
     * 单文件上传(使用此功能需在yml中配置sys.file.upload.path和sys.file.upload.relative)
     * 如果上传成功,data中会返回请求路径
     * @param file 上传文件
     * @param path 服务器存储路径,最后以/结尾,相当于在服务器上创建文件夹
     * @return AjaxResult<String>
     * @throws IOException
     */
    @PostMapping("upload")
    public AjaxResult<String> upload(@RequestParam("file") MultipartFile file,
                                     @RequestParam("path") String path)  {
        if (file.isEmpty()) {
            return new AjaxResult<String>().setMessage("文件为空!").setData("文件为空");
        }
        // 获取文件名
        final String fileName = file.getOriginalFilename();
        final String fileFullPath =  uploadPath + path + fileName ;
        final File saveFile = new File(fileFullPath);
        try {
            createParentDirs(saveFile);
            //保存附件
            write(file.getBytes(), saveFile);
        }catch (IOException e){
            return new AjaxResult<String>().setMessage("文件上传异常");
        }
        return new AjaxResult<String>().setMessage("上传成功").setData(relative + path + fileName);
    }

    @GetMapping("export")
    public void export(){
        //easyExcel

    }

}
