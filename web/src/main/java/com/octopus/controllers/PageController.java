package com.octopus.controllers;

import com.octopus.entities.Page;
import com.octopus.repositories.PageRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

	@DeleteMapping(value = "/page")
	public void deletePage(@RequestParam("id") int id) {
		Optional<Page> byId = pageRepository.findById(id);
		if (byId.isPresent()) {
			pageRepository.deleteById(id);

		}
	}

}
