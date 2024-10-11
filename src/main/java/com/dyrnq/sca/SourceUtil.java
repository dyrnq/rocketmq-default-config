package com.dyrnq.sca;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SourceUtil {

    public static String readSource(String url, String fieldName) {

        String tempDir = System.getProperty("java.io.tmpdir");
        String fileName = StrUtil.replace(url, "https://", "").replaceAll("/", "_");

        File file = new File(StrUtil.join(File.separator, tempDir, fileName));
        if (!file.exists()) {
            while (true) {
                try {
                    HttpUtil.downloadFile(url, file);
                    break;
                } catch (Exception e) {

                }
            }
        }


        String regex = "private\\s+\\w+\\s+" + fieldName + "\\s*=\\s*(.+);";
        Pattern pattern = Pattern.compile(regex);
        String code = "";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    code = matcher.group(1);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return code;
    }
}
