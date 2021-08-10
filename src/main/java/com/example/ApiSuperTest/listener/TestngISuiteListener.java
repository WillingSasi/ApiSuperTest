package com.example.ApiSuperTest.listener;

import com.example.ApiSuperTest.core.ResultInit;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.io.*;

@Log4j2
//public class TestngISuiteListener implements ISuiteListener {
public class TestngISuiteListener {
    @Autowired
    ResultInit resultInit;

//    @Override
    public void onStart(ISuite suite) {
        log.info("-------------------------Result path start init!-------------------------");
//        resultInit.initResultFolder();
//        resultInit.addReportEnvironment();
        log.info("-------------------------Result path end init!-------------------------");
    }

    /**
     * Use allure client generate report
     * 2021。04。06 为了本地idea运行后自动创建allure报告， 搭载jenkins-allure后可忽略此步骤
     * @param suite
     */
//    @Override
//    public void onFinish(ISuite suite) {
//        logger.info("-------------------------Copy allure results start!-------------------------");
//        copyAllureResultToTarget(ResultInit.getResultFolder());
//        logger.info("-------------------------Copy allure results end!-------------------------");
//
//        logger.info("-------------------------Generate report start!-------------------------");
//        String allureClientPath = System.getProperty("user.dir") + "/allure-2.13.2/bin/allure";
//        if (System.getProperty("os.name").contains("windows")) {
//            allureClientPath = System.getProperty("user.dir") + "/allure-2.13.2/bin/allure.bat";
//        }
//
//        try {
//            Runtime.getRuntime().exec(allureClientPath + " generate " +
//                    System.getProperty("user.dir") + "/" + ResultInit.getResultFolder() + "/" + " -o " +
//                    System.getProperty("user.dir") + "/" + ResultInit.getResultFolder() + "/report");
//        } catch (IOException e) {
//            logger.info("-------------------------Generate report error!-------------------------");
//            e.printStackTrace();
//        }
//        logger.info("-------------------------Generate report end!-------------------------");
//    }

    /**
     * 递归复制指定日期文件加下文件到target/allure-results，配合jenkins解析并显示allure报告
     * @Author graham
     * @Date 2020.12.30
     */
    private void copyAllureResultToTarget(String sourceFoler){
        String targetFolder = System.getProperty("user.dir") + "/target/allure-results";
        new File(targetFolder).mkdirs();
        File[] sourceFiles = new File(sourceFoler).listFiles();

        for (File sourceFile : sourceFiles) {
            if (sourceFile.isFile()){
                File targetFile = new File(targetFolder + File.separator + sourceFile.getName());
                try {
                    copyFile(sourceFile, targetFile);
                } catch (IOException e) {
                    log.info("-------------------------Copy allure results error!-------------------------");
                    e.printStackTrace();
                }
            }
        }
    }

    private void copyFile(File source, File target) throws IOException {
        FileInputStream inputStream = new FileInputStream(source);
        FileOutputStream outputStream = new FileOutputStream(target);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

        byte[] bytes = new byte[1024];
        int len = 0;

        while ((len = inputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, len);
        }

        bufferedOutputStream.close();
        outputStream.close();
        inputStream.close();
    }
}