package com.example.bankcards.service;

import com.example.bankcards.dto.CardDTO;
import com.example.bankcards.entity.Card;
import com.example.bankcards.entity.User;
import com.example.bankcards.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public CardDTO createCard(User user, String fullCardNumber, String ownerName, LocalDate expiryDate, BigDecimal initialBalance) {
        String encryptedNumber = "encrypted " + fullCardNumber;
        String last4 = fullCardNumber.substring(fullCardNumber.length() - 4);
        String maskedNumber = "**** **** **** " + last4;

        Card card = new Card(
                encryptedNumber,
                last4,
                ownerName,
                expiryDate,
                "ACTIVE",
                initialBalance,
                user
        );

        Card saved = cardRepository.save(card);

        return new CardDTO(
                saved.getId(),
                maskedNumber,
                saved.getOwnerName(),
                saved.getExpiryDate(),
                saved.getStatus(),
                saved.getBalance()
        );
    }

    public List<CardDTO> getUserCards(Long userId) {
        List<Card> cards = cardRepository.findByUserId(userId);
        return cards.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private CardDTO toDTO(Card card) {
        String maskedNumber = "**** **** **** " + card.getCardNumberLast4();
        return new CardDTO(
                card.getId(),
                maskedNumber,
                card.getOwnerName(),
                card.getExpiryDate(),
                card.getStatus(),
                card.getBalance()
        );
    }
}
