package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BankAccountBean;
import beans.TransactionBean;
import beans.UserBean;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/App")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String address = "/WEB-INF/pages/login.jsp";
		String action=request.getParameter("action");
		session.setAttribute("notification", " ");
		if (action == null || action.equals("")) {
			address = "/WEB-INF/pages/login.jsp";
		}else if( action.equals("login")){
			
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			if(username!=null && password!=null) {
				UserBean userBean=new UserBean();
				if(userBean.login(username, password)) {
					session.setAttribute("userBean", userBean);
					session.setAttribute("bankAccountBean", new BankAccountBean());
					address = "/WEB-INF/pages/bank-accounts.jsp";
				}else {
					session.setAttribute("notification", "Bad credentials");
				}
			}
		}else if( action.equals("logout")) {
			session.invalidate();
			address = "/WEB-INF/pages/login.jsp";
			
		}else {
			UserBean userBean = (UserBean) session.getAttribute("userBean");
			if(userBean==null || !userBean.isLoggedIn()) {
				address = "/WEB-INF/pages/login.jsp";
			}else {
				if( action.equals("transactions")) {
					session.setAttribute("transactionBean", new TransactionBean());
					System.out.println("usao");
					address = "/WEB-INF/pages/transactions.jsp";
				}else if( action.equals("bank-accounts")) {
					session.setAttribute("bankAccountBean", new BankAccountBean());
					address = "/WEB-INF/pages/bank-accounts.jsp";
				}else if( action.equals("saveStatus")) {
					System.out.println("dosao zahtjev");
					String bankAccountId= request.getParameter("bankAccountId");
					String selectedValue= request.getParameter("selectedValue");
					if(bankAccountId!=null && selectedValue!=null) {
						BankAccountBean bankAccountBean=new BankAccountBean();
						bankAccountBean.setStatus(request.getParameter("bankAccountId"),request.getParameter("selectedValue"));
					}
					
					address = "/WEB-INF/pages/bank-accounts.jsp";
				}
				
			}
		}
			
			
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
