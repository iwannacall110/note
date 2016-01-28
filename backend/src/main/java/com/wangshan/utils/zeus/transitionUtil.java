package com.wangshan.utils.zeus;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

/**
 * Created by shan on 2016/1/18.
 */

public class TransitionUtil {

    public static String blobToStr(Object o){
        if (o == null)
            return null;
        System.out.println(o);
        Blob b = (Blob) o;
        try {
            InputStream in = b.getBinaryStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] data = new byte[4096];
            int count = -1;
            while((count = in.read(data,0,4096)) != -1)
                out.write(data, 0, count);
            data = null;
            String result = new String(out.toByteArray(),"utf-8");
            return result;
        } catch (Exception e) {
            return null;
        }
    }

/*
    public static SerialBlob strToBlob(String str){
		SerialBlob blob = null;
        try {
            blob = new SerialBlob(str.getBytes());
        } catch(SerialException e){
            e.printStackTrace();
        }
        return blob;
    }

    public static void main(String[] args){

        System.out.println("================================");
    }
	*/
}
