package dairyproject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dairyproject.dao.DairyDao;
import dairyproject.dto.Dairy;
import dairyproject.dto.Products;

@WebServlet("/product_add")
public class AddProduct extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		double price = Double.parseDouble(req.getParameter("price"));
		String category = req.getParameter("category");
		String brand = req.getParameter("brand");
		String imageLink= req.getParameter("imageLink");

		Products products = new Products();
		products.setName(name);
		products.setPrice(price);
		products.setCategory(category);
		products.setBrand(brand);
		products.setImageLink(imageLink);
		
		HttpSession httpSession = req.getSession();
		Dairy dairy = (Dairy) httpSession.getAttribute("session");

		DairyDao dao = new DairyDao();

		int result = dao.saveProductToDairy(dairy, products);

		if (result==1) {
			req.setAttribute("list", dao.getAllProduct(dairy));

			req.getRequestDispatcher("showProductDairy.jsp").forward(req, resp);
		} else {
			req.setAttribute("list", dairy.getProductList());
			req.setAttribute("msg", "Wrong password! Please try again!");

			req.getRequestDispatcher("showProductDairy.jsp").forward(req, resp);			
		}
	}

}
