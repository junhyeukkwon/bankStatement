package dev.bank;

import java.io.IOException;

import dev.bank.data.BankStatementParser;
import dev.bank.data.BankStatementTSVParser;

//Ŭ���̾�Ʈ�� ���� ����ȭ��
public class MainApplication {

	public static void main(String[] args) throws IOException {
		//Analyzer ����
		final BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
		
		//parser ����
		BankStatementParser parser = new BankStatementTSVParser();
		
		// �м� ����
		analyzer.analyze("bank-data-simple.txt", parser);
		
	}
	

}