package com.example.demo.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 墨殇
 * @description:
 * @Date : 2018/2/26.
 */
@Controller
public class UploadController {

    @RequestMapping(value = "/toPage",method = RequestMethod.GET)
    public String toPage(){
        return "upload";
    }

    /**
     * 上传文件方法
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public  String upload(HttpServletRequest request, MultipartFile file){

        try {
            //上传目录地址
            String uploadDir=request.getSession().getServletContext().getRealPath("/")+"upload/";
            //如果目录不存在，自动创建文件夹
            File file1=new File(uploadDir);
            if (!file1.exists()){
                file1.mkdir();
            }
            //上传文件名
            String fileName=file.getOriginalFilename();
            //服务器端保存的文件对象
            File serverFile=new File(uploadDir+fileName);
            //将上传的文件写入到服务端中
            file.transferTo(serverFile);

        } catch (IOException e) {
            e.printStackTrace();
            //打印错误信息
            return "上传失败";

        }
        return  "上传成功";

        }
    /**
     * 上传多个文件
     * @param request 请求对象
     * @param file 上传文件集合
     * @return
     */
    @RequestMapping(value = "/uploads",method = RequestMethod.POST)
    public @ResponseBody String uploads(HttpServletRequest request,MultipartFile[] file)
    {
        try {
            //上传目录地址
            String uploadDir = request.getSession().getServletContext().getRealPath("/") +"upload/";
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if(!dir.exists())
            {
                dir.mkdir();
            }
            //遍历文件数组执行上传
            for (int i =0;i<file.length;i++) {
                if(file[i] != null) {
                    //调用上传方法
                    executeUpload(uploadDir, file[i]);
                }
            }
        }catch (Exception e)
        {
            //打印错误堆栈信息
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }

    /**
     * 提取上传方法为公共方法
     * @param uploadDir 上传文件目录
     * @param file 上传对象
     * @throws Exception
     */
    private void executeUpload(String uploadDir,MultipartFile file) throws Exception
    {
        //文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件名
        String filename = UUID.randomUUID() + suffix;
        //服务器端保存的文件对象
        File serverFile = new File(uploadDir + filename);
        //将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
    }
}
