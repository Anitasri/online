package com.anita.onlineFE.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.anita.onlineFE.model.UserModel;
import com.anita.onlineBE.model.dao.UserDAO;
import com.anita.onlineBE.model.dto.Cart;
import com.anita.onlineBE.model.dto.User;

@ControllerAdvice
public class GlobalController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private HttpSession session;

	private UserModel userModel = null;
	private User user = null;

	@ModelAttribute("userModel")
	public UserModel getUserModel() {
		if (session.getAttribute("userModel") == null) {
			// add the user model //get the authentication object
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

			if (!authentication.getPrincipal().equals("anonymousUser")) {
				// get the user from the database
				user = userDAO.getByEmail(authentication.getName());

				if (user != null) {
					// create a new model
					userModel = new UserModel();
					// set the name and the id
					userModel.setId(user.getId());
					userModel.setEmail(user.getEmail());
					userModel.setFullName(user.getFirstName() + " " + user.getLastName());
					userModel.setRole(user.getRole());

					if (userModel.getRole().equals("USER")) {
						// set the cart only if user is buyer
						userModel.setCart(user.getCart());
					}
					// set the userModel in the session
					session.setAttribute("userModel", userModel);
					return userModel;
				}
			}
		}

		return (UserModel) session.getAttribute("userModel");
	}

}
