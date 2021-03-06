package dev.bank.domain;

import java.time.LocalDate;

// 입출금 내역에 대한 개별 타입(컬럼)들을 보관할 클래스
public class BankTransaction {
	private LocalDate date;
	private double amount;
	private String description;
	
	//AllArgsConstructor
	public BankTransaction(LocalDate date, double amount, String description) {
		super();
		this.date = date;
		this.amount = amount;
		this.description = description;
	}

	//Getter,Setter
	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	//toString
	@Override
	public String toString() {
		return "BankTransaction [date=" + date + ", amount=" + amount + ", description=" + description + "]";
	}
	
	
	
}
