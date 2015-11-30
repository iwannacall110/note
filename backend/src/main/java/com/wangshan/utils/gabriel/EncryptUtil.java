package com.wangshan.utils.gabriel;
import java.security.*;
public class EncryptUtil {

    public EncryptUtil() {}

    public String encrypt(String strSrc, String encName) {
        MessageDigest md = null;
        String strDes = null;

        byte[] bt = strSrc.getBytes();
        try {
            if (encName == null || encName.equals("")) {
                encName="MD5";
            }
            md=MessageDigest.getInstance(encName);
            md.update(bt);
            strDes = bytes2Hex(md.digest());
        }
        catch (NoSuchAlgorithmException e) {
            System.out.println("Invalid algorithm.");
            return null;
        }
        return strDes;
    }

    public String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i=0;i<bts.length;i++) {
            tmp=(Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }

    public static void main(String[] args) {
        EncryptUtil te = new EncryptUtil();
        String strSrc = "测试sha1!!!";
        System.out.println("Source String:"+strSrc);
        System.out.println("Encrypted String:");
        System.out.println("Use Def:"+te.encrypt(strSrc,null));
        System.out.println("Use MD5:"+te.encrypt(strSrc,"MD5"));
        System.out.println("Use SHA1:"+te.encrypt(strSrc,"SHA-1"));
        System.out.println("Use SHA-256:"+te.encrypt(strSrc,"SHA-256"));
    }
}