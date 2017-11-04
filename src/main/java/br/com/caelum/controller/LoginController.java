package br.com.caelum.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String email, String senha, RedirectAttributes attrs, HttpSession sessao) {
		if(
			!"admin@gmail.com".equals(email) ||
			!"1234".equals(senha)
		) attrs.addFlashAttribute("erroDeLogin", true);
		else {
			sessao.setAttribute("logado", true);
		}
		
		return "redirect:/";		
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession sessao) {
		sessao.invalidate();
		
		return "redirect:/";
	}

}
