package dev.bank.data;

import java.util.List;

import dev.bank.domain.BankTransaction;

// Parser ���赵
public interface BankStatementParser {
	BankTransaction parseFrom(String line);
	List<BankTransaction> parseLinesFrom(List<String> lines);
}
