package org.dawin.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.dawin.domain.DonateVO;
import org.dawin.service.DonateService;
import org.dawin.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/donate")
@Controller
public class DonateController {
	
	@Autowired
	DonateService service;
	
	@Autowired
	ExchangeService exservice;
	
	@GetMapping("/totaldonate")
	public void totaldonate(Model model) {
		
		log.info("=== totaldonate page GetMapping 접속 중 ===");
		
		model.addAttribute("donateTotalMoney", service.getDonateTotalMoney());
		model.addAttribute("donateTotalPeople", service.getDonateTotalPeople());
		model.addAttribute("donateOptionTotalList", service.getDonateOptionTotalList());
	}
	
	@PostMapping("/totaldonate")
	public String totaldonate(@Valid Errors errors) throws IOException {
		
		log.info("=== totaldonate page PostMapping 접속 중 ===");
		return "/donate";
	}
	
	@GetMapping("/finddonate")
	public void finddonate(Model model) {
		
		log.info("=== finddonate page GetMapping 접속 중 ===");
		/* model.addAttribute("donateMyList", service.getDonateMyList()); */
	}
	
	@PostMapping("/finddonate")
    public String finddonateSubmit(@ModelAttribute("donate") @Valid DonateVO donate, Errors errors, Model model) throws IOException {
		
        if (errors.hasErrors()) {
            log.info("=== finddonate 페이지 PostMapping 접속 중 (에러 발생) ===");
            return "donate/finddonate";
        }

        log.info("=== finddonate page PostMapping 접속 중 ===");

        service.getDonateMyList(donate);

        return "/donate/finddonate";
    }
	
	@GetMapping("/donate")
	public void donate(Model model) {
		
		log.info("=== donate page GetMapping 접속 중 ===");
		model.addAttribute("donateAmountList", service.getDonateAmountList());
		model.addAttribute("donateSelectList", service.getDonateSelectList());
	}
	
	@PostMapping("/donate")
	public String donate(@Valid Errors errors) throws IOException {
		
		log.info("=== donate page PostMapping 접속 중 ===");
		return "/donate";
	}

	@GetMapping("/payment1")
	public void payment1() {
		
		log.info("=== payment page GetMapping 접속 중 ===");
	}

	@PostMapping("/payment1")
	public String payment1(@Valid @ModelAttribute("donate") DonateVO donate, Errors errors, Model model) throws IOException {
		
		log.info("=== payment1 page PostMapping 접속 중 ===");
		if (errors.hasFieldErrors()) {
			return "donate/donate";
		}
		
		service.donateRegister(donate);
		return "/donate/payment1"; // 성공적인 경우의 뷰 페이지
	}
	
	@GetMapping("/payment2")
	public void payment2() {
		
		log.info("=== payment2 page GetMapping 접속 중 ===");
	}

	@PostMapping("/payment2")
	public String payment2(@Valid @ModelAttribute("donate") DonateVO donate, Errors errors, Model model) throws IOException {
		
		log.info("=== payment2 page PostMapping 접속 중 ===");
		if (errors.hasFieldErrors()) {
			return "donate/donate";
		}
		
		service.donateRegister(donate);
		return "/donate/payment2"; // 성공적인 경우의 뷰 페이지
	}
	
	@GetMapping("/paysuccess")
	public void paysuccess() {
		
		log.info("=== paysuccess page GetMapping 접속 중 ===");
	}

}