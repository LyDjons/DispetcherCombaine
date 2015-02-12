package com.config;

import com.disp.Disp;
import com.disp.disp.control.DispControl;
import com.disp.disp.control.loadExcell.Report;
import com.disp.disp.control.loadExcell.TransportAction;
import com.disp.disp.control.saveExcell.TransportExcell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by disp.chimc on 26.11.14.
 */
public class Test {


    public static void main(String []s) throws IOException {
        Disp disp = new DispControl();
        ArrayList<Report> reports = disp.load_report("Document.xlsx");
        disp.load_departmetn("config/config.xlsx");
        ArrayList<Config> config =disp.load_config("config/config.xlsx");
for(Config c : config){
    System.out.println(c);
}
        ArrayList<TransportExcell> transportExcell = new ArrayList<TransportExcell>();
        for(Report re: reports){
           System.out.println(re.getTracker() + "  "+get_list_departments_of_work(re, disp.getConfigs(), disp.getDepartMap()));
        }
        for(Report re: reports){
            transportExcell.add(new TransportExcell(re,disp.getConfigs(),disp.getDepartMap())); 
        }

        for(Map.Entry<String,String> m :disp.getDepartMap().entrySet())
             System.out.println(m);



      /*  try {
            File file = new File("D:/11111.xlsx");
            file.createNewFile();
            FileOutputStream fis = new FileOutputStream("D:/11111.xlsx");
            Workbook workbook = new XSSFWorkbook();
            workbook.createSheet("Лист1");
            workbook.write(fis);
        } catch (Exception e1) {
            System.out.println("Не удалось создать файл");
        }
       disp.save_report(disp.getReport(),"D:/11111.xlsx",disp.getConfigs());
       */
    }
    private static String get_list_departments_of_work(Report report,ArrayList<Config>configs,Map<String,String> departMap){
        String place ="";
        if(configs==null){ return "-";}
        for(Config c : configs){
            if (Integer.parseInt(c.getTracker())==report.getTracker()){
                if(c.getType_work().contains("збирання")) {
                    place+="Комбайни ";
                }else
                if(c.getType_work().contains("бункер")) {
                    place+="Бункера  ";
                }


            }

        }/*

        Set<String> places = new HashSet<String>();


   /*     for(TransportAction ta: report.getTransportActions()){
            for(Map.Entry<String,String> m: departMap.entrySet()){
                if(ta.getPlace().contains(m.getKey())){

                    try {
                        int i = Integer.parseInt(ta.getPlace().substring(0,1));
                    }catch (Exception e){
                        continue;
                    }

                    places.add(m.getValue());
                    System.out.println(ta.getPlace() + "  key= " + m.getKey() + "   value= " + m.getValue());
                }
            }
        }


        for(String s : places){
            place = place+" "+s;
        }
//place =place.substring(0,place.length()-1);

*/
        return place;

    }
}
