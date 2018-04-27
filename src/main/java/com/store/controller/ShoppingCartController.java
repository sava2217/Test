package com.store.controller;

import com.store.entity.Clothes;
import com.store.entity.ClothesInCard;
import com.store.entity.ShoppingCart;
import com.store.entity.User;
import com.store.repository.UserRepository;
import com.store.service.ClothesInCardService;
import com.store.service.ClothesService;
import com.store.service.ShoesInCardService;
import com.store.service.ShoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Optional;

@Controller
public class ShoppingCartController {

    private final ClothesInCardService clothesInCardService;
    private final ShoesInCardService shoesInCardService;
    private final ClothesService clothesService;
    private final ShoesService shoesService;
    private final UserRepository userRepository;


    @Autowired
    public ShoppingCartController(ClothesInCardService clothesInCardService,
                                  ShoesInCardService shoesInCardService,
                                  ClothesService clothesService,
                                  ShoesService shoesService,
                                  UserRepository userRepository) {
        this.clothesInCardService = clothesInCardService;
        this.shoesInCardService = shoesInCardService;
        this.clothesService = clothesService;
        this.shoesService = shoesService;
        this.userRepository = userRepository;
    }


    @RequestMapping("/loh")
    public String loh(Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        System.out.println(user.getShoppingCart());
        return "redirect:/";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String show(Model model, @PageableDefault Pageable pageable, Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        ShoppingCart shoppingCart = user.getShoppingCart();
        model.addAttribute("shoppingCart", shoppingCart);
        return "shoppingCart";
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
    public String addProuct(@PathVariable Long id, Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        Optional<Clothes> clothes = clothesService.findOne(id);
        boolean bol = false;
        for (ClothesInCard c : user.getShoppingCart().getClothesInCards()) {
            if (c.getClothes() == clothes.get()) {
                bol = true;
                c.setQuantity(c.getQuantity() + 1);
                c.setTotalPrice(c.getClothes().getPrice().multiply(new BigDecimal(c.getQuantity())));
                c.getShoppingCart().setTotalPrice(c.getShoppingCart().getTotalPrice().add(c.getClothes().getPrice()));
            }
        }

        if (bol) {
        } else {
            ClothesInCard clothesInCard = new ClothesInCard();
            clothesInCard.setClothes(clothes.get());
            clothesInCard.setQuantity(1);
            clothesInCard.setShoppingCart(user.getShoppingCart());
            clothesInCard.setTotalPrice(clothesInCard.getClothes().getPrice());
            clothesInCard.getShoppingCart().setTotalPrice(clothesInCard.getShoppingCart().getTotalPrice().add(clothesInCard.getClothes().getPrice()));
            clothesInCardService.save(clothesInCard);
        }
        userRepository.save(user);
        return "redirect:/";
    }

}