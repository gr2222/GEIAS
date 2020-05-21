package com.gr.geias.util;

import com.baidu.aip.face.AipFace;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020/5/20 3:35 下午
 */

public class SampleFactory {
    public static final String APP_ID = "你的appId";
    public static final String API_KEY = "你的apiKey";
    public static final String SECRET_KEY = "你的secretKey";


    private volatile static AipFace instance = null;

    private SampleFactory() {
    }

    public static AipFace getInstance() {
        if (instance == null) {
            synchronized (SampleFactory.class) {
                if (instance == null) {
                    instance = new AipFace(APP_ID, API_KEY, SECRET_KEY);
                }
            }
        }
        return instance;
    }

}
