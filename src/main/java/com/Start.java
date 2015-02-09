package com;

import com.config.Config;
import com.disp.Disp;
import com.disp.disp.control.DispControl;

import java.io.IOException;
import java.util.Map;

/**
 * Created by disp.chimc on 23.12.14.
 */
public class Start {
        public static void main(String []args) throws IOException {
            Disp disp = new DispControl();
            disp.load_config("config/config.xlsx");
          //  disp.loadReport("Document.xlsx");
           //disp.load_departmetn("config/config.xlsx");

//disp.save_report(disp.getReport(),"file.xlsx",disp.getConfigs());

       //   disp.save_report(disp.getReport(),"test.xlsx",disp.getConfigs());

        }
}
