/**
 *
 * @author Armando Montoya
 * @email armando.montoya@digitalonus.com
 * @Date Apr 24, 2020
 *
 */

package com.digitalonus.securedrestfulservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SampleController {
	@GetMapping("/messageFromBackend")
	public String getMessageFromBackend() {
		return "Message from backend! Token in valid!";
	}
}
