package com.octopus.controllers;

import com.octopus.dto.PageDTO;
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

	@PostMapping(value = "/pages")
	public Page postPages(@RequestBody Page page) {

		logger.info("PageDTO received name " + page.toString());
		Page some_file_url = new Page(page.getName(), page.getFileUrl());
		pageRepository.save(some_file_url);
		return some_file_url;
	}

}
