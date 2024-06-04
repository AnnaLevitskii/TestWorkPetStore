package com.core.providers;
import com.core.utils.Path;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesProviderXML implements Path {

    public static void main(String[] args) {
        //PropertiesXML.setProperties("new_name", "NewJon","prop.xml", true, "comment new");
        //PropertiesXML.setProperties("name", "Anna","prop.xml", false, "comment ");
        System.out.println("name --> " +PropertiesProviderXML.getPropertyXML("name","prop.xml"));
        System.out.println("phone --> " +PropertiesProviderXML.getPropertyXML("phone","prop.xml"));
    }
    static Properties properties = new Properties();

    public static void setProperties(String key, String value, String fileName,
                                     boolean clearFile, String comment){
        if(!clearFile){
            try (FileInputStream inputStream = new FileInputStream(XML_PROPERTIES_PATH+fileName)){
                properties.loadFromXML(inputStream);
            }catch (IOException e){
                System.out.println("exception was thrown, flag false");
                e.printStackTrace();
            }
        }
        properties.setProperty(key, value);
        try(FileOutputStream outputStream = new FileOutputStream(XML_PROPERTIES_PATH+fileName)){
            properties.storeToXML(outputStream, comment);
        }catch (IOException e){
            System.out.println("exception was thrown, flag true");
            e.printStackTrace();
        }

    }

    public static String getPropertyXML(String key, String fileName){
        try(FileInputStream inputStream = new FileInputStream(XML_PROPERTIES_PATH+fileName)){
            properties.loadFromXML(inputStream);
            return  properties.getProperty(key);
        }catch (IOException e){
            System.out.println("Get exception was thrown ");
            e.printStackTrace();
            return null;
        }
    }
}
