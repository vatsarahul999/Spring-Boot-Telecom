package com.telecom.demo.controller.pdt;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/")
public class ProductController {

    @GetMapping
    //@PreAuthorize("hasRole('ADMIN')")
    public String getProduct() {
        return "myProduct";
    }
}
