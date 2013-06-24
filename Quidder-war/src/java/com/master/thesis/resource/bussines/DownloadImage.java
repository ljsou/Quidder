/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.master.thesis.resource.bussines;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.coobird.thumbnailator.Thumbnails;
import org.kohsuke.rngom.digested.Main;

/**
 *
 * @author Javier
 */
public class DownloadImage {

    private String urlImage;
    private String downloadedImageAddres;
    private String thumbnailsDownloadedImageAddres;
    private String addressImageEmpty;

    public DownloadImage() {        
        downloadedImageAddres = "C:\\Users\\Javier\\Documents\\NetBeansProjects\\Quidder\\Quidder-war\\web\\Resources\\Images\\OriginalImage\\";
        thumbnailsDownloadedImageAddres = "C:\\Users\\Javier\\Documents\\NetBeansProjects\\Quidder\\Quidder-war\\web\\Resources\\Images\\Thumbnail\\Thumbnail_";
        addressImageEmpty = "G:\\QuidderRepository\\Resources\\Images\\OriginalImage";
    }        

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getDownloadedImageAddres() {
        return downloadedImageAddres;
    }

    public void setDownloadedImageAddres(String downloadedImageAddres) {
        this.downloadedImageAddres = downloadedImageAddres;
    }   

    public String getThumbnailsDownloadedImageAddres() {
        return thumbnailsDownloadedImageAddres;
    }

    public void setThumbnailsDownloadedImageAddres(String thumbnailsDownloadedImageAddres) {
        this.thumbnailsDownloadedImageAddres = thumbnailsDownloadedImageAddres;
    }    
    
    public void run() throws IOException {

        URL u = new URL(urlImage);
        URLConnection uc = u.openConnection();
        String contentType = uc.getContentType();
        int contentLength = uc.getContentLength();
        InputStream raw = uc.getInputStream();
        InputStream in = new BufferedInputStream(raw);
        byte[] data = new byte[contentLength];
        int bytesRead;
        int offset = 0;
        System.out.println("Downloading image, please wait...");
        while (offset < contentLength) {
            bytesRead = in.read(data, offset, data.length - offset);
            if (bytesRead == -1) {
                System.out.println("Unable to download the image.");
                break;
            }
            offset += bytesRead;
        }
        System.out.println("Image downloaded!");
        in.close();
        if (offset != contentLength) {
            throw new IOException("Only read " + offset + " bytes; Expected " + contentLength + " bytes");
        }
        String[] tmp = urlImage.split("/");
        String filename = tmp[tmp.length - 1];
        FileOutputStream out = new FileOutputStream(addressImageEmpty + filename);
        out.write(data);
        out.flush();
        System.out.println("Image saved!");
        out.close();
        
        System.out.println("First Thumbnails started...");
        Thumbnails.of(new File(addressImageEmpty + filename))
        .size(64, 64)
        .toFile(new File(thumbnailsDownloadedImageAddres + filename));
        System.out.println("Image's First Thumbnail done!");
        
        System.out.println("Second Thumbnails started...");
        Thumbnails.of(new File(addressImageEmpty + filename))
        .size(300, 300)
        .toFile(new File(downloadedImageAddres + filename));
        System.out.println("Image's First Thumbnail done!");
        
        System.out.println("Deleting image...");
        File deletedImg = new File(addressImageEmpty + filename);
        deletedImg.delete();
        System.out.println("Deleted image!");
        
        
    }        
    
    public static void main(String[] arg){
        try {
            DownloadImage downloadImage = new DownloadImage();
            downloadImage.setUrlImage("http://upload.wikimedia.org/wikipedia/commons/c/c4/Arc_Triomphe.jpg");
            downloadImage.run();
        } catch (IOException ex) {
            System.out.println("Exception: " + ex.toString());
            Logger.getLogger(DownloadImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }        
}
