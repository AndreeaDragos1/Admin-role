package org.example.lab9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String showProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products"; // Va returna pagina products.html
    }

    @GetMapping("/add-product")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product"; // Formular pentru adăugare produs
    }

    @PostMapping("/add-product")
    public String addProduct(@ModelAttribute Product product) {
        productRepository.save(product); // Salvează produsul în DB
        return "redirect:/products"; // Redirect la lista de produse
    }
}
