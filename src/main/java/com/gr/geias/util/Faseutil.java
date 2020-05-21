package com.gr.geias.util;

import com.baidu.aip.face.AipFace;
import org.json.JSONObject;
import sun.misc.BASE64Decoder;


import java.io.*;
import java.util.HashMap;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020/5/20 6:01 下午
 */
public class Faseutil {
    private static AipFace instance;
    private static String groupId = "2";

    static {
        instance = SampleFactory.getInstance();
    }

    public static JSONObject addUser(String image, String userId) {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("action_type", "REPLACE");
        String imageType = "BASE64";
        // 人脸注册
        JSONObject res = instance.addUser(image, imageType, groupId, userId, options);
        return res;
    }

    public static JSONObject search(String image) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("max_face_num", "1");
        options.put("match_threshold", "50");
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        options.put("max_user_num", "1");

        String imageType = "BASE64";

        JSONObject res = instance.search(image, imageType, groupId, options);
        return res;
    }

    /**
     * 删除
     */
    public static JSONObject faceDelete() {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();

        String userId = "user1";
        String faceToken = "face_token_23123";

        // 人脸删除
        JSONObject res = instance.faceDelete(userId, groupId, faceToken, options);
        return res;
    }

    /**
     * 人脸检测
     *
     */
    public static JSONObject detect(String image) {
        System.out.println(image);
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("face_field", "age");
        options.put("max_face_num", "2");
        options.put("face_type", "LIVE");
        options.put("liveness_control", "LOW");

        String imageType = "BASE64";

        // 人脸检测
        JSONObject res = instance.detect(image, imageType, options);
        System.out.println("sdadwadawd      "+res);
        return res;
    }

}
