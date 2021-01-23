package com.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
    @Value("${basePath}")
    String basePath;

    @RequestMapping("/uploadFile")
    @ResponseBody()
    public String upload(MultipartFile uploadFile) throws IOException {
        // 获取上传文件的名称
        String originalFilename = uploadFile.getOriginalFilename();
        // 保存文件到本地
        File file = new File(basePath + "\\" + originalFilename);
        uploadFile.transferTo(file);
        return "上传文件成功！<br/>文件在硬盘中的地址：" + file.getAbsolutePath() + "<br/>网络可访问地址：http://localhost:8585/upload/" + originalFilename;
    }
}
