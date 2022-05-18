package com.example.emailservice.controller;

import com.example.emailservice.DTO.EmailDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;
//import static org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("/gm")
public class EmailController {

    private static final Logger log = LoggerFactory.getLogger(EmailController.class);

//
//    private UserService userService = new UserService();

//    @GetMapping("/profile")
//    public ModelAndView showProfile() {
//        //validation if needed
//        //shall we log a little?
//        ModelAndView mav = new ModelAndView();
//        log.info("Hello grupa 5!!!!!!!");
//        User user = new User("Bubu");
//        mav.addObject("fullUserObj", user);
//        mav.addObject("numeStudent", user.getName());
//        // adaugi x obiecte
//        mav.setViewName("profile");
//        //log the final outcome: Success y?
//        return mav;
//    }
//
//    @GetMapping("/home")
//    public ModelAndView showHome() {
//        //validation if needed
//        //shall we log a little?
//        ModelAndView mav = new ModelAndView();
//        log.info("Hello grupa 5!!!!!!!");
//
//        mav.addObject("grupa", 5);
//        // adaugi x obiecte
//        mav.setViewName("home");
//        //log the final outcome: Success y?
//        return mav;
//    }

    @PostMapping("/sendemail")
    public ResponseEntity<String> sendEmail(@RequestHeader("SecurityKey") String key, @RequestBody EmailDTO email){

        System.out.println("Header key: "+key);

        if(key.compareTo("2233")!=0)
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Wrong security key!");

        try{
            log.info("Am venit din cealalta lume!!!!!\n"+email.toString());
        }catch(Exception e){
            log.info(e.getMessage());
        }
        EmailSender mailer = new EmailSender();
        try {
            mailer.send(email);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.OK).body("The email was sent!");
    }

}
