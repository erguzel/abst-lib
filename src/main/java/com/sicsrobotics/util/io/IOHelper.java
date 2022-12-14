package com.sicsrobotics.util.io;

import com.sicsrobotics.util.exeption.SicsException;

import java.io.File;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.util.Base64;
/**
 * Hosts io read write methods
 */
public class IOHelper {
    /**
     * Reads flat file from path
     * @param path
     * @return
     */
    public static String readFlatFile(String path) throws SicsException {
        FileInputStream fr = null;
        String result = null;
        try {

            
            
            
            fr = new FileInputStream(path);
            byte[] bytes = new byte[(int) new File(path).length()];
            DataInputStream dataInputStream = new DataInputStream(fr);
           // result = new String(fr.readAllBytes());
            dataInputStream .readFully(bytes);
            result = Base64.getEncoder().encodeToString(bytes);
            dataInputStream.close();
        }catch (Throwable e){
            SicsException
                    .Handle("Read flat file reading input stream failed",
                            false,false,true,e);

        }
        return result;
    }
}
