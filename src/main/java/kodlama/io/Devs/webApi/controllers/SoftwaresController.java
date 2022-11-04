package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.SoftwareService;
import kodlama.io.Devs.core.utilities.exceptions.SoftwareIdNotEmptyException;
import kodlama.io.Devs.core.utilities.exceptions.SoftwareIdNotEqualException;
import kodlama.io.Devs.core.utilities.exceptions.SoftwareNameNotEmptyException;
import kodlama.io.Devs.core.utilities.exceptions.SoftwareNameNotEqualException;
import kodlama.io.Devs.core.utilities.exceptions.SoftwareNotFoundException;
import kodlama.io.Devs.entities.concretes.Software;

@RestController
@RequestMapping("/api/softwares")
public class SoftwaresController {

	@Autowired
	private SoftwareService softwareService;

	@PostMapping("/addsoftware")
	public Software addSoftware(@RequestBody Software software) throws Exception {
//			throws SoftwareIdNotEqualException,
//			SoftwareNameNotEqualException, SoftwareNameNotEmptyException, SoftwareIdNotEmptyException {
		return softwareService.addSoftware(software);
	}

	@PostMapping("/updatesoftware")
	public Software updateSoftware(@RequestBody Software software) throws Exception {
//			throws SoftwareNotFoundException, SoftwareIdNotEmptyException, SoftwareNameNotEmptyException {
		return softwareService.updateSoftware(software);
	}

	@GetMapping("/getsoftwarebyid")
	public Software getSoftwareById(@RequestParam int softwareId) throws Exception {
//			throws SoftwareNotFoundException, SoftwareIdNotEmptyException {
		return softwareService.getSoftwareById(softwareId);
	}

	@PostMapping("/deletesoftwarebyid")
	public void deleteSoftwareById(@RequestBody int softwareId) throws Exception {
//			throws SoftwareIdNotEmptyException, SoftwareNotFoundException {
		softwareService.deleteSoftwareById(softwareId);
	}

	@GetMapping("/getallsoftware")
	public List<Software> getAllSoftware() {

		return softwareService.getAllSoftware();
	}
}
