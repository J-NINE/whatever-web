package com.webservice.whatever.web;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AxiosExampleController {

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/api/axiosTest")
    public String axiosHello(@RequestParam("tEst") String test){
        String res = "";
        if(test.equals("1")){
            res= "one!!!!!!!";
        }else if(test.equals("2")){
            res = "!!!!!!!!!!two";
        } else{
            res = "nothing";
        }
        return res;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/api/axiosPostTest")
    public String axiosPost(HttpServletRequest request){
        String dd = request.getParameter("demo");
        String result = "";
        if(dd.equals("3")){
            result = "!!!!!!!!three";
        } else if(dd.equals("4")){
            result = "!!!!!!!!!!!!four";
        }else{
            result = "!!!!!!nope";
        }
        return result;
    }

}
