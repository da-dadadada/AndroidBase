package com.lht.chuangyiyun.util.file;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * <p><b>Package</b> com.lht.chuangyiyun.util.file
 * <p><b>Project</b> Chuangyiyun
 * <p><b>Classname</b> FileUtils
 * <p><b>Description</b>: TODO
 * Created by leobert on 2016/5/12.
 */
public class FileUtils {
    public static void copyFile(File origin, File dest) throws  IOException {
        File parentfolder = new File(dest.getParent());
        if (!parentfolder.exists()) {
            parentfolder.mkdirs();
        }
        if (!dest.exists()) {
            Log.d("lmsg","check dest:"+dest.getAbsolutePath());
            dest.createNewFile();
            dest.setWritable(true);
        }

        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            // 新建文件输入流并对它进行缓冲
            inBuff = new BufferedInputStream(new FileInputStream(origin));

            // 新建文件输出流并对它进行缓冲
            outBuff = new BufferedOutputStream(new FileOutputStream(dest));

            // 缓冲数组
            byte[] b = new byte[1024 * 5];
            int len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            // 刷新此缓冲的输出流
            outBuff.flush();
        } finally {
            // 关闭流
            if (inBuff != null)
                inBuff.close();
            if (outBuff != null)
                outBuff.close();
        }

    }
}
