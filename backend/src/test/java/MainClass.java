import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2015/11/15.
 */
public class MainClass {
    public String Encrypt(String strSrc) {
        MessageDigest md=null;
        String strDes=null;

        byte[] bt=strSrc.getBytes();
        try {

            md= MessageDigest.getInstance("SHA-1");
            md.update(bt);
            strDes=bytes2Hex(md.digest());  //to HexString
        }catch (NoSuchAlgorithmException e) {
            System.out.println("Invalid algorithm.");
            return null;
        }
        return strDes;
    }

    public String bytes2Hex(byte[]bts) {
        String des="";
        String tmp=null;
        for (int i=0;i<bts.length;i++) {
            tmp=(Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length()==1) {
                des+="0";
            }
            des+=tmp;
        }
        return des;
    }

    public static void main(String[] args) {
        MainClass te=new MainClass();
        String strSrc="¿ÉÒÔ¼ÓÃÜºº×Ö.Oh,and english";
        System.out.println("Source String:"+strSrc);
        System.out.println("Encrypted String:");
        System.out.println("Use SHA:"+te.Encrypt(strSrc).toUpperCase());
    }
}
