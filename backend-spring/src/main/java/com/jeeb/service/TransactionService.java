package com.jeeb.service;

import com.jeeb.dto.request.CreateTransactionRequest;
import com.jeeb.dto.response.TransactionResponse;
import com.jeeb.entity.Transaction;
import com.jeeb.repository.TransactionRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<TransactionResponse> listByUser(Long userId) {
        return transactionRepository.findByUserId(userId).stream()
            .map(this::toResponse)
            .toList();
    }

    public TransactionResponse create(CreateTransactionRequest request) {
        Transaction transaction = new Transaction(
            request.userId(),
            request.amount(),
            request.description(),
            request.date()
        );
        return toResponse(transactionRepository.save(transaction));
    }

    private TransactionResponse toResponse(Transaction transaction) {
        return new TransactionResponse(
            transaction.getId(),
            transaction.getUserId(),
            transaction.getAmount(),
            transaction.getDescription(),
            transaction.getDate()
        );
    }
}
