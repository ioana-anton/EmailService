package com.example.emailservice.DTO;

public class EmailDTO {
    public String Text;
    public String Email;

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String toString(){
       return new String(Text + " " +Email);
   }
}
