package dev.bank.service;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import dev.bank.domain.BankTransaction;

// 입출금 관련 도메인(비즈니스) 로직을 처리하는 클래스
public class BankStatementProcessor {

	// 필드 생성
	// 추후 모든 연산에서 입출금 내역 목록(List<BankTransaction>)을 사용할 것이기 때문에 Processor 클래스의 필드로 설정
	private final List<BankTransaction> bankTransactions; // 초기화를 하지 않은 상태

	public BankStatementProcessor(List<BankTransaction> bankTransactions) {
		this.bankTransactions = bankTransactions; // 생성자를 통한 필드 초기화
	}

	// 1. 총 입출금 내역 계산 로직
	public double calculateTotalAmount() {
		double total = 0d;

		for (BankTransaction bankTransaction : bankTransactions) {
			total += bankTransaction.getAmount();
		}

		return total;
	}

	// 2. 월 별 입출금 내역 계산 로직
	public List<BankTransaction> calculateListInMonth(Month month) {
		final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();

		for (BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDate().getMonth() == month) {
				bankTransactionsInMonth.add(bankTransaction);
			}
		}

		return bankTransactionsInMonth;
	}

	// 3. 카테고리 별 총 입출금 내역 조회 계산 로직
	public double calculateTotalForCategory(String category) {
		double total = 0d;
		
		for (BankTransaction bankTransaction : bankTransactions) {
//			if(bankTransaction.getDescription().equals(category)) total += bankTransaction.getAmount();
			
			if(bankTransaction.getDescription().equals(category)) {
				total += bankTransaction.getAmount();
			}
		}
		
		return total;
	}
}