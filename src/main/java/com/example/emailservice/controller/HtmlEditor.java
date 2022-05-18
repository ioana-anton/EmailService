package com.example.emailservice.controller;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlEditor {

    public String readHtml(String receiverName) {

        StringBuilder builder = new StringBuilder();

        try {
            InputStream emailHtml = new ClassPathResource("templates/email.html").getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(emailHtml));

            String text;

            Pattern pattern = Pattern.compile("#####");

            while((text=reader.readLine())!=null){

                Matcher matcher = pattern.matcher(text);
                while (matcher.find()) {
                    //String group = matcher.group();
                    int start = matcher.start();
                    int end = matcher.end();

                    String nameSymbol = text.substring(start,end);
                    //System.out.println(group + " " + start + " " + end);

                    text=text.replaceAll(nameSymbol,receiverName);
                }

                builder.append(text);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return builder.toString();
    }
}
