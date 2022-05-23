package dev.bank;

import java.io.IOException;

import dev.bank.data.BankStatementParser;
import dev.bank.data.BankStatementTSVParser;

//클라이언트가 보는 메인화면
public class MainApplication {

	public static void main(String[] args) throws IOException {
		//Analyzer 생성
		final BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
		
		//parser 지정
		BankStatementParser parser = new BankStatementTSVParser();
		
		// 분석 수행
		analyzer.analyze("bank-data-simple.txt", parser);
		
	}
	

}