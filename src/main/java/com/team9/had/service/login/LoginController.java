package com.team9.had.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/common")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @GetMapping("/login")
    public ResponseEntity<String> loggingIn(@RequestBody LoginModel loginModel){
        if(loginService.loggingIn(loginModel)){
            return new ResponseEntity<>("Logged in Successfully!", HttpStatusCode.valueOf(200));
        }
        else{
            return new ResponseEntity<>("Something Went Wrong!", HttpStatusCode.valueOf(412));
        }
    }

}
