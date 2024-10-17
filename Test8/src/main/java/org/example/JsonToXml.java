package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonToXml {

    public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException {
        // Read JSON from file
        String json = new String(Files.readAllBytes(Paths.get("C:\\Users\\DurgaGuthulaSIDGloba\\Documents\\durga\\file.json")));
        json = json.replace("[", "");
        json = json.replace("]", "");
        json = json.replace("{", "");
        json = json.replace("}", "");
        String[] array = json.split(",");
        System.out.println(array);
        for (String s : array) {
             //  s +="}";
            String s1 = "{"+s+"}";
            JSONObject jsonObject = new JSONObject(s1);

            String xmlString = XML.toString(jsonObject);
            System.out.println(xmlString);
        }
    }
}