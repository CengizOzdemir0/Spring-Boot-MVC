package com.works.controllers;


import com.works.entities.Product;
import com.works.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class DashboardController {
    final ProductService productService;

    @GetMapping("dashboard")
    public String dashboard(Model model) {
        model.addAttribute("list",productService.list());
        return "dashboard";
    }

    @PostMapping("/productAdd")
    public String productAdd(Product product){
        productService.save(product);
        // redirect demek farklı bir sayfya veya sayfayı yenilemek için kullanılır.
        // örneğin ürün ekledikten sonra tekrar dashboarda göndermek için kullanılır.
        return "redirect:/dashboard";
    }
}
