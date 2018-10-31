package br.edu.fbv.projetolibdowload.Dowload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Download_img implements Runnable  {

    String imageUrl;
    File f;

    public Download_img(String imageUrl , File f){
        this.imageUrl =imageUrl ;
        this.f = f;
    }


    @Override
    public void run() {
        try {
            URL url = new URL(this.imageUrl);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();

            BufferedInputStream in = new BufferedInputStream(http.getInputStream());

            File csvdestino =  new File(String.valueOf(this.f));
            FileOutputStream fos = new FileOutputStream(csvdestino);
            BufferedOutputStream bout = new BufferedOutputStream(fos, 1024);
            byte[] buffer = new byte[1024];
            double dowloaded = 0.00;
            int read =0;
            double percent = 0.00;



            while ((read = in.read(buffer , 0 , 1024)) >= 0) {
                bout.write(buffer, 0, read);
                dowloaded += read ;

                String percentual = String.format("%.4f", percent);


            }

            bout.close();
            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}