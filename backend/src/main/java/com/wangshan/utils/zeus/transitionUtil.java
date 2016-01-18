package com.wangshan.utils.zeus;

/**
 * Created by shan on 2016/1/18.
 */

public class TransitionUtil {

    public static String blobToStr(Blob blob){
        String result =""
        try{
            return new String(blob.getBytes((long)1, (int)blob.length()));
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static  Blob strToBlob(String str){
        BufferedReader BlobStream = new BufferedReader(Blob.getCharacterStream());
        StringBuffer stringBuffer = new StringBuffer();
        int nchars = 0;
        char[] buffer = new char[10];
        while((nchars = BlobStream.read(buffer)) != -1 )
            stringBuffer.append(buffer, 0, nchars);
        BlobStream.close();
        return Util.strTrim(stringBuffer.toString());
    }

    public static void main(args[] String){
        System.out.println("================================")
    }
}
