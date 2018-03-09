package com.template.data.common;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResponseStubs {

    private static final String BASE_PATH = "/src/test/resources/raw/";

    private static String getResponseJson(String nameFile) {
        try {
            return readFile(nameFile);
        } catch (Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }

    public static String getResponseLoginOk() {
        return getResponseJson("responseTestFilmsWS200.json");
    }

    public static String getResponseLoginWithError() {
        return getResponseJson("responseTestFilmsDataErrorsWereFound.json");
    }

    private static String readFile(final String path) throws IOException {
        final StringBuilder sb = new StringBuilder();
        String strLine;
        BufferedReader reader = null;
        try {
            String userDirPath = formatPath(System.getProperty("user.dir"));
            String fullPath = userDirPath.concat(BASE_PATH).concat(path);
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fullPath), "UTF-8"));
            while ((strLine = reader.readLine()) != null) {
                sb.append(strLine);
            }

        } catch (final IOException ignore) {
            //ignore
        } finally {
            if (reader != null)
                reader.close();
        }
        return sb.toString();
    }

    private static String formatPath(String path){
        String[] paths = path.split("/");
        List<String> listPaths = new ArrayList<>(Arrays.asList(paths));
        if (listPaths.contains("app")){
            return path;
        }
        else{
            return path + "/app";
        }
    }

}