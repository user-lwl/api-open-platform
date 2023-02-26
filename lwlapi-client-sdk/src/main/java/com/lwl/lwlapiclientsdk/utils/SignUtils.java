package com.lwl.lwlapiclientsdk.utils;


import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * 签名工具
 * @author user-lwl
 * @createDate 2023/2/22 19:45
 */
public class SignUtils {

    /**
     * 生成签名
     * @param body body
     * @param secretKey secretKey
     * @return 签名
     */
    public static String getSign(String body, String secretKey) {
        Digester md5 = new Digester(DigestAlgorithm.SHA256);
        String content = body + "." + secretKey;
        return md5.digestHex(content);
    }
}
