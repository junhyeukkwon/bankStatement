package dev.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

import dev.bank.data.BankStatementParser;
import dev.bank.domain.BankTransaction;
import dev.bank.service.BankStatementProcessor;

public class BankStatementAnalyzer {

	// 입출금내역 파일인 back-data-simple.txt 파일의 경로 지정.
	private static final String RESOURCES = "src/main/resources/";
	
	// 입출금 내역 분석 수행 메서드
	public void analyze(String fileName, BankStatementParser parser) throws IOException {
		// 1. 파일 경로 확인, 읽기
		final Path path = Paths.get(RESOURCES + fileName);
		final List<String> lines = Files.readAllLines(path);
		
		//2.읽어들인 파일 파싱(parsing) CSV -> interface를 만들어서 BankStatementAnalyzer에 BankStatementTSVParser에 의존도(결합도)를 낮췄다.(직접적인 관계를 해제)
		//한번더 추상화 시켰다.인터페이스만 알면 인터페이스 안에 있는 메서드는 인터페이스에서 구현체 클래스를 인스턴스를 생성하고, 안에 메서드를 불러오면 된다.
		List<BankTransaction> bankTransactions = parser.parseLinesFrom(lines);
		// 3. 기능별(총 입출금 내역 or 월 별 입출금 내역 or 카테고리별 등) 연산 처리(Processing)용 객체 생성
		BankStatementProcessor processor = new BankStatementProcessor(bankTransactions);
		
		// 4. 입출금 내역 분석(Analazer) 결과(summary) 출력
		collectSummary(processor);
	}
	
	//입출금 내역 분석 결과 출력 메서드
	private static void collectSummary(BankStatementProcessor processor) {
		System.out.println("총 사용 금액은" + processor.calculateTotalAmount() + "입니다.");
		
		System.out.println("2월의 입출금 내역은 " + processor.calculateListInMonth(Month.FEBRUARY) + "입니다.");
		
		System.out.println("Salary(급여) 카테고리의 총 입출금 내역은 " + processor.calculateTotalForCategory("Salary") + "입니다.");
		// case sensitive, 대소문자 구분 등
	}

}