//package com.yingge.qa;
//
//import java.security.Key;
//import java.security.MessageDigest;
//import java.util.Base64;
//import java.util.Map;
//import java.util.TreeMap;
//
//import javax.crypto.Cipher;
//import javax.crypto.spec.IvParameterSpec;
//import javax.crypto.spec.SecretKeySpec;
//
//import net.minidev.json.JSONObject;
//
//public class SessionSignGenerator {
//
//    public static String encrypt(String content, String aesKey, String aesIv) {
//        try {
//            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//            Key key = new SecretKeySpec(aesKey.getBytes(), "AES");
//            cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(aesIv.getBytes()));
//            byte[] encrypted = cipher.doFinal(content.getBytes());
//            return new String(Base64.getEncoder().encode(encrypted));
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    public static String generateSign(Map<String, Object> request) throws Exception {
//        String aesKey = "b195693210474fdb";
//        String aesIv = "9f426f038f001c69";
//
//        // 生成sign值
//        MessageDigest md = MessageDigest.getInstance("MD5");
//
//        String ciphertext = encrypt(JSONObject.toJSONString(request), aesKey, aesIv);
//
//        TreeMap<String, String> newDataMap = new TreeMap<>();
//        newDataMap.put("service", "Planet.Auth.SyncSession");
//        newDataMap.put("version", "1.0");
//        newDataMap.put("encrypt", "AES");
//        newDataMap.put("bizContent", ciphertext);
//
//        String sign = bytesToHexString(md.digest(JSONObject.toJSONString(request).getBytes()));
//
//        String content = newDataMap.get("bizContent");
//        byte[] decryptBaseData = Base64.getDecoder().decode(content.getBytes("utf-8"));
//        SecretKeySpec key = new SecretKeySpec(aesKey.getBytes(), "AES");
//        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//        cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(aesIv.getBytes()));
//        byte[] result = cipher.doFinal(decryptBaseData);
//        String bizParam = new String(result);
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("service", request.get("service"));
//        map.put("version", request.get("version"));
//        map.put("encrypt", request.get("encrypt"));
//        map.put("sign", sign);
//        map.put("bizContent", ciphertext);
//
//        return JSONObject.toJSONString(map);
//    }
//
//    public static void main(String[] args) throws Exception {
//        Map<String, Object> dataMap = new HashMap<>();
//        dataMap.put("service", "Planet.Auth.SyncSession");
//        dataMap.put("version", "1.0");
//        dataMap.put("encrypt", "AES");
//        Map<String, String> bizContentMap = new HashMap<>();
//        bizContentMap.put("userId", "34244643246533");
//        bizContentMap.put("realName", "雄鹰3");
//        bizContentMap.put("logonId", "43246773533");
//        bizContentMap.put("userType", "CORPORATE_ACCOUNT");
//        bizContentMap.put("userCode", "usr-210120GyutMwrrSbvY5htM6gD4Ye");
//
//        dataMap.put("bizContent", bizContentMap);
//        System.out.println(generateSign(dataMap));
//
//        //        Map<String, Object> dataMap1 = new HashMap<>();
//        //        dataMap1.put("service", "Planet.Auth.ClearSession");
//        //        dataMap1.put("version", "1.0");
//        //        dataMap1.put("encrypt", "AES");
//        //        Map<String, String> bizContentMap1 = new HashMap<>();
//        //        bizContentMap1.put("bpToken", "c9b8d62a290d4288a00247fbf4dd4261");
//        //        dataMap1.put("bizContent", bizContentMap1);
//        //        System.out.println(generateSign(dataMap1));
//    }
//
//    public static final String bytesToHexString(byte[] bArray) {
//        StringBuffer sb = new StringBuffer(bArray.length);
//        String sTemp;
//        for (int i = 0; i < bArray.length; i++) {
//            sTemp = Integer.toHexString(0xFF & bArray[i]);
//            if (sTemp.length() < 2) {
//                sb.append(0);
//            }
//            sb.append(sTemp.toUpperCase());
//        }
//        return sb.toString();
//    }
//}