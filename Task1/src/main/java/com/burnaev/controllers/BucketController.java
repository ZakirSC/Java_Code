package com.burnaev.controllers;

import com.burnaev.forms.AddToBucketForm;
import com.burnaev.models.User;
import com.burnaev.services.AuthenticationService;
import com.burnaev.services.BucketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class BucketController {

    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private BucketService bucketService;


    @GetMapping("/bucket")
    public String getBucket(@ModelAttribute("model")ModelMap modelMap,
                            Authentication authentication){
        User user = authenticationService.getUserByAuthentication(authentication);
        modelMap.addAttribute("user", user);
        boolean hasBuckets = bucketService.hasUserBuckets(user);
        modelMap.addAttribute("hasBuckets", hasBuckets);
        return "bucket";
    }
    @PostMapping("/addToBucket")
    @ResponseBody
    public ResponseEntity<Object> addToBucket(AddToBucketForm form){
        bucketService.save(form);
        return ResponseEntity.accepted().build();
    }
    @PostMapping("/delete_bucket")
    public String deleteBucket(@RequestParam(value = "id") Long bucketId) {
        bucketService.delete(bucketId);
        return "redirect:bucket";
    }
}
