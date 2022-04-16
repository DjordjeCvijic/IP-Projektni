package beans;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import dao.BankAccountDao;
import dao.TransactionDao;
import dto.BankAccountDto;
import dto.TransactionDto;
import dto.TransactionToDisplay;

public class TransactionBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	public List<TransactionToDisplay>getTransactions(){
		List<TransactionToDisplay> result=new LinkedList();
		
		List<TransactionDto> transactionDtoList=TransactionDao.getAllTransactions();
		transactionDtoList.forEach(element->{
			TransactionToDisplay transactionToDisplay=new TransactionToDisplay();
			BankAccountDto bankAccountDto=BankAccountDao.getBankAccountById(element.getBankAccountId());
			transactionToDisplay.setAmount(element.getAmount());
			transactionToDisplay.setCardNumber(bankAccountDto.getCardNumber());
			transactionToDisplay.setFirstName(bankAccountDto.getFirstName());
			transactionToDisplay.setLastName(bankAccountDto.getLastName());
			transactionToDisplay.setTime(element.getTime());
			transactionToDisplay.setTransactionId(element.getTransactionId());
			
			
			result.add(transactionToDisplay);
		});
		
		return result;
	}

}
