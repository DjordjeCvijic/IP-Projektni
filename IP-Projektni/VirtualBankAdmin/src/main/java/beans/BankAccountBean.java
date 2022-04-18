package beans;

import java.io.Serializable;
import java.util.List;

import dao.BankAccountDao;
import dto.BankAccountDto;

public class BankAccountBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	
	public List<BankAccountDto> getAllBankAccounts(){
		return BankAccountDao.getAllBankAccounts();
	}


	public void setStatus(String bankAccountId, String selectedValue) {
		BankAccountDao.updateBankAccountStatus(Integer.valueOf(bankAccountId),selectedValue.equals("1"));
	}
}
