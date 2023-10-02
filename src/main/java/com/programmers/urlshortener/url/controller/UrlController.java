package com.programmers.urlshortener.url.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.programmers.urlshortener.url.dto.UrlShortenRequest;
import com.programmers.urlshortener.url.dto.UrlShortenResponse;
import com.programmers.urlshortener.url.service.UrlService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UrlController {

	private final UrlService urlService;

	@GetMapping
	public String home() {
		return "home";
	}

	@PostMapping
	public String shortenUrl(@ModelAttribute UrlShortenRequest request, Model model) {
		log.info("{}", request);
		UrlShortenResponse response = urlService.shortenUrl(request);
		model.addAttribute("response", response);

		return "shortenedUrl";
	}
}
