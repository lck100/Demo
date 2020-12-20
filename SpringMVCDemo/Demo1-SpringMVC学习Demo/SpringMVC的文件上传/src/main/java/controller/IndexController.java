package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class IndexController {
    @RequestMapping("/upload")
    @ResponseBody
    public void upload(String username, MultipartFile uploadFile) throws IOException {
        System.out.println(username);
        System.out.println(uploadFile);
        // 活得上传文件的名称
        String originalFilename = uploadFile.getOriginalFilename();
        uploadFile.transferTo(new File("C:\\upload\\" + originalFilename));//保存文件
    }

    @RequestMapping("/upload2")
    @ResponseBody
    public void upload2(String username,MultipartFile[] uploadFile) throws IOException {
        System.out.println(username);
        for (MultipartFile multipartFile : uploadFile) {
            // 获取文件名
            String originalFilename = multipartFile.getOriginalFilename();
            // 保存到磁盘中通过transferTo(File)方法
            multipartFile.transferTo(new File("C:\\upload\\"+originalFilename));
        }
    }
}
