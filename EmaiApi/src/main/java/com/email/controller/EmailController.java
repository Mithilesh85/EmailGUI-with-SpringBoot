package com.email.controller;

import com.email.model.EmailRequest;
import com.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class EmailController {

    @Autowired
    public EmailService emailService;

    @RequestMapping("/welcome")
    public String welcome()
    {
        return "hello this is email api creation";
    }

    @RequestMapping(value = "/sendemail",method = RequestMethod.POST)
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request)
    {
        System.out.println(request);
        boolean b = this.emailService.sendEmail( request.getMessage(),request.getSubject(), request.getTo());
        if(b)
            return ResponseEntity.ok("Done");
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
    }

}
