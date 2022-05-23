package dev.bank.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dev.bank.domain.BankTransaction;
//만약에 데이터를 불러오게 된다면, 데이터를 어떻게 쪼개고 담을건지에 대한 기능을 수행하는 클래스
//하나의 책임, 전달받은 데이터를 파싱 후 
public class BankStatementTSVParser implements BankStatementParser {
	
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	// 한 줄만 파싱, 이 클래스 내에서만 사용할 예정
	public BankTransaction parseFrom(final String line) {
		
		String[] columns = line.split("\t");
		
		final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);// DATE_PATTERN은 날짜의 표기형식을 알려주는 것이고, 첫번째 인자의 형태를 LocalDate 타입에 "dd-MM-yyyy" 패턴을 갖는 형태로 띄겠다. 
		final double amount = Double.parseDouble(columns[1]);
		final String description = columns[2];
		
		BankTransaction bankTransaction = new BankTransaction(date, amount, description);
		return bankTransaction;
	}
	
	// 한 줄씩 파싱 후, 리스트에 추가
	// BankTransaction -> model 클래스
	public List<BankTransaction> parseLinesFrom(List<String> lines) {
		List<BankTransaction> bankTransactions = new ArrayList<>();
		for (String line : lines) {
			bankTransactions.add(parseFrom(line));
		}
		return bankTransactions;
		}
}