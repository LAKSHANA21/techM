package com.javapractices.app;
import java.util.*;
import java.util.stream.*;
import java.time.LocalDate;
class Transaction{
	public String TransactionId;
	public String AccountNum;
	public String transType;
	public int Amount;
	public LocalDate date;
	public String source;
	
	Transaction(String TransactionId, String AccountNum, String transType, int Amount, LocalDate date, String source){
		this.TransactionId=TransactionId;
		this.AccountNum=AccountNum;
		this.transType=transType;
		this.Amount=Amount;
		this.date=date;
		this.source=source;
	}
	
	@Override
    public String toString() {
        return "Transaction{" +
                "id='" + TransactionId + '\'' +
                ", accountNumber='" + AccountNum + '\'' +
                ", type='" + transType + '\'' +
                ", amount=" + Amount +
                ", date=" + date +
                ", vendor='" +source + '\'' +
                '}';
    }
	
	public String getAccountNum() {
		return AccountNum;
	}
}
public class StreamExample {
	public static void main(String[] args) {
	/*List<String> name = Arrays.asList("Lakshu","Amritha","jaswin","Nikitha");
	name.stream()
	    .filter(names -> names.startsWith("j"))
	    .forEach(System.out::println);
	
	List<Integer> num = Arrays.asList(2,1,6,3,8,4);
	num.stream().sorted().forEach(System.out::println);
	
	/*List<String> name = Arrays.asList("Lakshu","Lakshu","Jaswin","Amritha");
	name.stream().distinct().forEach(System.out::println);*/
		
	List<Transaction> transaction = Arrays.asList(new Transaction("T001", "A123", "Credit", 5000, LocalDate.of(2025, 1, 5), "Amazon"),
    new Transaction("T002", "A123", "Debit", 2000, LocalDate.of(2025, 1, 6), "Walmart"),
    new Transaction("T003", "A123", "Debit", 7000, LocalDate.of(2025, 1, 7), "BestBuy"),
    new Transaction("T004", "B456", "Credit", 10000, LocalDate.of(2025, 1, 5), "PayPal"),
    new Transaction("T005", "A123", "Debit", 15000, LocalDate.of(2025, 1, 8), "Target"),
    new Transaction("T006", "B456", "Debit", 8000, LocalDate.of(2025, 1, 9), "eBay"));

	
	transaction.stream()
    .filter(trans -> trans.Amount > 5000)
    .forEach(System.out::println);
	
	int total=transaction.stream()
	           .filter(trans -> trans.AccountNum.equals("A123") && trans.transType.equals("Debit"))
	           .mapToInt(trans->trans.Amount)
	           .sum();
	System.out.println(total);
	
	long count = transaction.stream().filter(trans->trans.source.equals("Amazon")).count();
	System.out.println(count);
	
	transaction.stream()
	           .filter(trans->trans.Amount>0)
	           .sorted(Comparator.comparingInt(trans -> trans.Amount))
	           .forEach(System.out::println);
	
	 Map<String, List<Transaction>> groupedByAccount = transaction.stream()
             .collect(Collectors.groupingBy(Transaction::getAccountNum));

     groupedByAccount.forEach((accountNum, transactions) -> {
         System.out.println("Account: " + accountNum);
         transactions.forEach(System.out::println);
     });
	      

}
}
