package dairyproject.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dairyproject.dao.DairyDao;
import dairyproject.dto.Dairy;

@WebServlet("/owner_login")
public class OwnerLogin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String password = req.getParameter("password");
		
		DairyDao dao=new DairyDao();
		int result = (dao.loginDairy(id, password));
		
		if (result == 0) {
			req.setAttribute("msg", "Id not found! Please resister!");

			req.getRequestDispatcher("resistershop.jsp").forward(req, resp);
		} else if (result == 1) {
			Dairy dairy= dao.findDairy(id);
			
			HttpSession httpSession=req.getSession();
			httpSession.setAttribute("session", dairy);
			
			req.setAttribute("msg", "Successfully login");
			
			req.setAttribute("list", dairy.getProductList());
			
			req.getRequestDispatcher("showProductDairy.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "Wrong password! Please try again!");

			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}

	}

}
