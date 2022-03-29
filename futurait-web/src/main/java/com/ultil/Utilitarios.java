/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ultil;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import javax.imageio.ImageIO;
import org.primefaces.shaded.commons.io.IOUtils;

/**
 *
 * @author Ricardo
 */
public final class Utilitarios {

    public static String convertirImagenBase64(InputStream in) {
        try {
            return Base64.getEncoder().encodeToString(IOUtils.toByteArray(in));
        } catch (IOException ex) {
            return null;
        }
    }

    public static byte[] extractBytes() throws IOException {
        File fnew = new File("C:\\Users\\Ricardo\\Pictures\\imagen.jpg");
        BufferedImage originalImage = ImageIO.read(fnew);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(originalImage, "jpg", baos);
        byte[] imageInByte = baos.toByteArray();

        return imageInByte;
    }
    

}
