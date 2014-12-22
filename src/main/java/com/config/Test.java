package com.config;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by disp.chimc on 26.11.14.
 */
public class Test {


    public static void main(String []s) throws IOException {




File f = new File("config/config.xlsx");
        Desktop desktop = null;

        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
        }
        try {
            desktop.open(f);


        } catch (Exception e) {
            System.out.println("&&");
        }
    }


}
