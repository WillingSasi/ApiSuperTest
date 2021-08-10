package com.example.ApiSuperTest.core;

import io.qameta.allure.util.PropertiesUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Properties;

/**
 * 初始化result文件夹及按时间命名文件，存放log，allure-result，allure-report
 * @Author graham
 * @Date 2020.8.13
 */
@Log4j2
@Component
public class ResultInit {
    private final String resultDir = "Result";
    private static String resultFolder;

    @Value("${project-config.gitUrl}")
    private String gitUrl;

    @Value("${project-config.environment}")
    private String environment;

    @Value("${project-config.model}")
    private String model;

    public void initResultDir(){
        File dir = new File(resultDir);

        if (!dir.isDirectory()) {
            log.info("Result文件夹不存在!");
            dir.mkdir();
            log.info("Result文件夹新建成功!");
        }
    }

//    public String initResultFolder(){
////        File folderDir = new File(System.getProperty("user.dir") + File.separator + resultDir + File.separator + folderName + File.separator + time);
//        File folderDir = new File(PropertiesUtils.getAllureResultPath());
//
//        if (!folderDir.isDirectory()) {
//            log.info("Result文件夹不存在!");
//            folderDir.mkdirs();
//            log.info(folderDir.toString()+"文件夹新建成功!");
//        }
//        resultFolder = folderDir.toString();
//        return folderDir.toString();
//    }

    public static String getResultFolder() {
        return resultFolder;
    }

    /**
     * 新建复制添加allure报告首页的新建复制添加allure报告首页的environment系列参数系列参数
     * 参考： https://docs.qameta.io/allure/#_environment
     * 2021.04.06
     */
    public void addReportEnvironment() {
        if (new File(resultFolder+ "/environment.properties").exists()) {
            new File(resultFolder+ "/environment.properties").delete();
        }
        try {
            new File(resultFolder+ "/environment.properties").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Properties properties = new Properties();

        //创建一个输出流对象,选择正确的目标文件路径
        FileOutputStream envFileStream = null;
        try {
            envFileStream = new FileOutputStream(resultFolder+ "/environment.properties", true);
            OutputStreamWriter opw = new OutputStreamWriter(envFileStream, "utf-8");

            //将需要写入的属性内容通过set方法,存入properties对象中
            //调用properties的存储方法
            properties.setProperty("Run Environment", environment);
            properties.setProperty("Run Model", model);
            properties.setProperty("Gitlab", gitUrl);
            properties.store(opw, "Allure Report Environment");

            //关闭资源
            envFileStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
