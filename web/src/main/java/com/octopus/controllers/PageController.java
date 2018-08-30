package com.octopus.controllers;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.octopus.entities.Page;
import com.octopus.repositories.PageRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PageController {

	private static final Log logger = LogFactory.getLog(PageController.class);

	@Autowired
	private PageRepository pageRepository;

	@GetMapping("/pages")
	public List<Page> getPages() {
		return pageRepository.findAll();
	}

	@PostMapping("/pages")
	public List<Page> postPages(@RequestBody PageDTO page) {
		if (page != null) {

		}
		logger.info("PageDTO received name " + page.getName());
		return pageRepository.findAll();
	}

	@Data
	public class PageDTO {
		private String name;

		@JsonCreator
		public PageDTO(String name) {
			this.name = name;
		}
	}
}
