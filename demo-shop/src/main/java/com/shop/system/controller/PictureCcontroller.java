package com.shop.system.controller;

import com.shop.system.common.utils.FileUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 类作用：
 *
 * @author
 * @date
 */
@RestController
@RequestMapping("${process.apiPath}/system/")
public class PictureCcontroller {

    @Resource
    HttpServletRequest request;

    @GetMapping("testuploadimg")
    public String uploadImg(@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        //设置文件上传路径
        String filePath = "F:\\uploadpic\\imgupload/";
        String filePath1 = request.getSession().getServletContext().getRealPath("imgupload/");
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
            return "上传成功";
        } catch (Exception e) {
            return "上传失败";
        }
    }

    @GetMapping("getimg")
    public String uploadImg() {
        return "F:\\uploadpic\\imgupload\\www.jpg";
    }

}
