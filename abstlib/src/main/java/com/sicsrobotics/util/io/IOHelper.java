package com.sicsrobotics.util.io;

import com.sicsrobotics.util.exeption.SicsException;

import java.io.FileInputStream;

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
            result = new String(fr.readAllBytes());
        }catch (Throwable e){
            SicsException
                    .Handle("Read flat file reading input stream failed",
                            false,false,true,e);

        }
        return result;
    }
}
