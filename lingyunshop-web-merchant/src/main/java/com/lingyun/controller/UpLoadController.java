package com.lingyun.controller;

import com.lingyun.util.FastDFSClient;
import com.lingyun.util.Result;
import com.lingyun.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Star
 * @version 1.0
 * @date 2020/10/30 15:39
 */
@RestController
public class UpLoadController {

    /**
     * 文件服务器地址
     */
    @Value("${FILE_SERVER_URL}")
    private String FILE_SERVER_URL;

    @RequestMapping("/upload")
    public Result imageUpLoad(@RequestParam("picture") MultipartFile picture, HttpServletRequest request) {
        //1、取文件的扩展名
        String originalFilename = picture.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        try {
            //2、创建一个 FastDFS 的客户端
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:client.conf");
            //3、执行上传处理
            String path = fastDFSClient.uploadFile(picture.getBytes(), extName);
            //4、拼接返回的 url 和 ip 地址，拼装成完整的 url
            String url = FILE_SERVER_URL + path;
            return ResultGenerator.genSuccessResult(url);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("上传失败");
        }
    }

}
