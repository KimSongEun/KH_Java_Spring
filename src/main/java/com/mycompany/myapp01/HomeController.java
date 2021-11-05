package com.mycompany.myapp01;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "hello2", method = RequestMethod.GET)
	public String hello2() {
		return "hello";
	} // 페이지만 전달
	
	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public ModelAndView hello(ModelAndView mv) {
		mv.setViewName("hello");
		mv.addObject("k1", "aaaa");
		return mv;
	} // 페이지 + 데이터 전달
	
	@RequestMapping(value = "hello3", method = RequestMethod.GET)
	public String hello3(Model m) {
		m.addAttribute("k1", "2번째 값전달");
		return "hello";
	} // 페이지 + 데이터 전달
	
	@RequestMapping(value = "hello4", method = RequestMethod.GET)
	public ModelAndView hello() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		mv.addObject("k1", "3번째 방법");
		return mv;
	} // 페이지 + 데이터 전달
	
	@RequestMapping(value = "/aaa", method = RequestMethod.GET)
	public String adlfjwoasdf(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = "aaaaa";
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
}
