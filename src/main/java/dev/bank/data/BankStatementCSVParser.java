package dev.bank.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dev.bank.domain.BankTransaction;
//���࿡ �����͸� �ҷ����� �ȴٸ�, �����͸� ��� �ɰ��� ���������� ���� ����� �����ϴ� Ŭ����
//�ϳ��� å��, ���޹��� �����͸� �Ľ� �� 
public class BankStatementCSVParser implements BankStatementParser {
	
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	// �� �ٸ� �Ľ�, �� Ŭ���� �������� ����� ����
	public BankTransaction parseFrom(final String line) {
		
		String[] columns = line.split(",");
		
		final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);// DATE_PATTERN�� ��¥�� ǥ�������� �˷��ִ� ���̰�, ù��° ������ ���¸� LocalDate Ÿ�Կ� "dd-MM-yyyy" ������ ���� ���·� ��ڴ�. 
		final double amount = Double.parseDouble(columns[1]);
		final String description = columns[2];
		
		BankTransaction bankTransaction = new BankTransaction(date, amount, description);
		return bankTransaction;
	}
	
	// �� �پ� �Ľ� ��, ����Ʈ�� �߰�
	// BankTransaction -> model Ŭ����
	public List<BankTransaction> parseLinesFrom(List<String> lines) {
		List<BankTransaction> bankTransactions = new ArrayList<>();
		for (String line : lines) {
			bankTransactions.add(parseFrom(line));
		}
		return bankTransactions;
		}

}