package com.example.bankcards.controller;

import com.example.bankcards.dto.CardDTO;
import com.example.bankcards.dto.UserDTO;
import com.example.bankcards.entity.User;
import com.example.bankcards.service.CardService;
import com.example.bankcards.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/test")
public class TestController {

    private final UserService userService;
    private final CardService cardService;

    public TestController(UserService userService, CardService cardService) {
        this.userService = userService;
        this.cardService = cardService;
    }

    @GetMapping("/register")
    public UserDTO register(@RequestParam String email,
                            @RequestParam String pass,
                            @RequestParam String role) {
        return userService.register(email, pass, role);
    }

    @GetMapping("/create-card")
    public CardDTO createCard(@RequestParam Long userId,
                              @RequestParam String number,
                              @RequestParam String owner,
                              @RequestParam BigDecimal balance) {
        User user = userService.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        LocalDate expiryDate = LocalDate.now().plusYears(5);
        return cardService.createCard(user, number, owner, expiryDate, balance);
    }
}
