package com.javalec.jsp_homepage.frontcontroller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.jsp_homepage.command.BContentCommand;
import com.javalec.jsp_homepage.command.BDeleteCommand;
import com.javalec.jsp_homepage.command.BListCommand;
import com.javalec.jsp_homepage.command.BModifyCommand;
import com.javalec.jsp_homepage.command.BReplyCommand;
import com.javalec.jsp_homepage.command.BReplyViewCommand;
import com.javalec.jsp_homepage.command.BWriteCommand;
import com.javalec.jsp_homepage.command.Command;
import com.javalec.jsp_homepage.command.JoinCommand;
import com.javalec.jsp_homepage.command.LoginCommand;
import com.javalec.jsp_homepage.command.LogoutCommand;
import com.javalec.jsp_homepage.command.ModifyCommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		Command command = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.equals("/login.do")) {
			viewPage = "login.jsp";
		} else if(com.equals("/loginOK.do")) {
			command = new LoginCommand();
			command.execute(request, response);
			viewPage = "login.do";
		} else if(com.equals("/join.do")) {
			viewPage = "join.jsp";
		} else if(com.equals("/joinOK.do")) {
			command = new JoinCommand();
			command.execute(request, response);
			viewPage = "login.do";
		} else if(com.equals("/main.do")) {
			viewPage = "main.jsp";
		} else if(com.equals("/logout.do")) {
			command = new LogoutCommand();
			command.execute(request, response);
			viewPage = "login.do";
		} else if(com.equals("/modify.do")) {
			viewPage = "modify.jsp";
		} else if(com.equals("/modifyOK.do")) {
			command = new ModifyCommand();
			command.execute(request, response);
			viewPage = "login.do";
		} else if(com.equals("/write_view.do")) {
			viewPage = "write_view.jsp";
		} else if(com.equals("/write.do")) {
			command = new BWriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/list.do")) {
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		} else if(com.equals("/content_view.do")){
			command = new BContentCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";
		} else if(com.equals("/Bmodify.do")) {
			viewPage = "Bmodify.jsp";
		} else if(com.equals("/BmodifyOK.do")) {
			command = new BModifyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/delete.do")) {
			command = new BDeleteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/reply_view.do")) {
			command = new BReplyViewCommand();
			command.execute(request, response);
			viewPage = "reply_view.jsp";
		} else if(com.equals("/reply.do")) {
			command = new BReplyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}
