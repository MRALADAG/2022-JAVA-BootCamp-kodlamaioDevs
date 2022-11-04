package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.SoftwareService;
import kodlama.io.Devs.core.utilities.CheckValidityForSoftware;
import kodlama.io.Devs.core.utilities.exceptions.SoftwareIdNotEmptyException;
import kodlama.io.Devs.core.utilities.exceptions.SoftwareIdNotEqualException;
import kodlama.io.Devs.core.utilities.exceptions.SoftwareNameNotEmptyException;
import kodlama.io.Devs.core.utilities.exceptions.SoftwareNameNotEqualException;
import kodlama.io.Devs.core.utilities.exceptions.SoftwareNotFoundException;
import kodlama.io.Devs.dataAccess.abstracts.SoftwareRepository;
import kodlama.io.Devs.entities.concretes.Software;

@Service
public class SoftwareManager implements SoftwareService {
//@Service
//public class SoftwareManager implements SoftwareService {

	@Autowired
	private SoftwareRepository softwareRepository;

	@Autowired
	private CheckValidityForSoftware checkValidityForSoftware;

	private List<Exception> chekList;

	public SoftwareManager() {

	}

	@Override
	public Software addSoftware(Software software) throws Exception {
//			throws SoftwareIdNotEqualException, SoftwareNameNotEqualException, SoftwareNameNotEmptyException {

//		if (checkSoftwareId(software)) {
//			throw new SoftwareIdNotEqualException(software.toString());
//		} else if (checkSoftwareNameIsEmptyOrNull(software)) {
//			throw new SoftwareNameNotEmptyException(software.toString());
//		} else if (checkSoftwareName(software)) {
//			throw new SoftwareNameNotEqualException(software.toString());
//		}
		chekList = new ArrayList<Exception>();
		chekList.add(checkValidityForSoftware.checkSoftwareId(software));
		chekList.add(checkValidityForSoftware.checkSoftwareName(software));
		chekList.add(checkValidityForSoftware.checkSoftwareNameIsEmptyOrNull(software));
		checkValidityForSoftware.isValid(chekList);

		if (software.getId() == 0)
			software.setId(getAllSoftware().size() + 1);
		return softwareRepository.addSoftware(software);

	}

	@Override
	public Software updateSoftware(Software software) throws Exception {
//			throws SoftwareNotFoundException, SoftwareIdNotEmptyException, SoftwareNameNotEmptyException {
//		if (software.getId() == 0) {
//			throw new SoftwareIdNotEmptyException(software.toString());
//		} else if (checkSoftwareNameIsEmptyOrNull(software)) {
//			throw new SoftwareNameNotEmptyException();
//		}
		chekList = new ArrayList<Exception>();
		chekList.add(checkValidityForSoftware.checkIfId(software.getId()));
		chekList.add(checkValidityForSoftware.checkSoftwareNameIsEmptyOrNull(software));
		checkValidityForSoftware.isValid(chekList);

		return getAllSoftware().stream().map(element -> {
			if (element.getId() == software.getId())
				element.setName(software.getName());
			return element;
		}).filter(item -> item.getId() == software.getId()).findAny().orElseThrow(SoftwareNotFoundException::new);

	}

	@Override
	public Software getSoftwareById(int softwareId) throws Exception {
//			throws SoftwareNotFoundException, SoftwareIdNotEmptyException {
//		if (softwareId == 0) {
//			throw new SoftwareIdNotEmptyException("\nid : " + String.valueOf(softwareId));
//		} else if (!checkSoftwareById(softwareId)) {
//			throw new SoftwareNotFoundException("\nid : " + String.valueOf(softwareId));
//		} else
//			return softwareRepository.getSoftwareById(softwareId);
		chekList = new ArrayList<Exception>();
		chekList.add(checkValidityForSoftware.checkIfId(softwareId));
		chekList.add(checkValidityForSoftware.checkSoftwareById(softwareId));
		checkValidityForSoftware.isValid(chekList);

		return softwareRepository.getSoftwareById(softwareId);

	}

	@Override
	public void deleteSoftwareById(int softwareId) throws Exception {
//			throws SoftwareIdNotEmptyException, SoftwareNotFoundException {
//		if (softwareId == 0) {
//			throw new SoftwareIdNotEmptyException("\nid : " + String.valueOf(softwareId));
//		} else if (!checkSoftwareById(softwareId)) {
//			throw new SoftwareNotFoundException("\nid : " + String.valueOf(softwareId));
//		}
//		
		chekList = new ArrayList<Exception>();
		chekList.add(checkValidityForSoftware.checkIfId(softwareId));
		chekList.add(checkValidityForSoftware.checkSoftwareById(softwareId));
		checkValidityForSoftware.isValid(chekList);

		softwareRepository.deleteSoftwareById(softwareId);

	}

	@Override
	public List<Software> getAllSoftware() {

		return softwareRepository.getAll();
	}

//	private boolean checkSoftwareId(Software software) {
//		List<Software> softwares = getAllSoftware();
//		boolean result = softwares.stream().anyMatch(item -> item.getId() == software.getId());
//		return result;
//	}
//
//	private boolean checkSoftwareById(int softwareId) {
//		List<Software> softwares = getAllSoftware();
//		boolean result = softwares.stream().anyMatch(item -> item.getId() == softwareId);
//		return result;
//	}
//
//	private boolean checkSoftwareName(Software software) {
//		List<Software> softwares = getAllSoftware();
//		boolean result = softwares.stream().anyMatch(item -> item.getName().equalsIgnoreCase(software.getName()));
//		return result;
//	}
//
//	private boolean checkSoftwareNameIsEmptyOrNull(Software software) {
//		return (software.getName() == null || software.getName().isBlank() || software.getName().isEmpty()) ? true
//				: false;
//	}

//	private Exception checkSoftwareId(Software software) {
//		List<Software> softwares = softwareRepository.getAll();
//		boolean result = softwares.stream().anyMatch(item -> item.getId() == software.getId());
//		return result ? new SoftwareIdNotEqualException(software.toString()) : null;
//	}
//
//	private Exception checkSoftwareById(int softwareId) {
//		List<Software> softwares = softwareRepository.getAll();
//		boolean result = softwares.stream().anyMatch(item -> item.getId() == softwareId);
//		return result ? null : new SoftwareNotFoundException("\nid : " + String.valueOf(softwareId));
//	}
//
//	private Exception checkIfId(int softwareId) {
//
//		return softwareId == 0 ? new SoftwareIdNotEmptyException("\nid : " + String.valueOf(softwareId)) : null;
//	}
//
//	private Exception checkSoftwareName(Software software) {
//		List<Software> softwares = softwareRepository.getAll();
//		boolean result = softwares.stream().anyMatch(item -> item.getName().equalsIgnoreCase(software.getName()));
//		return result ? new SoftwareNameNotEqualException(software.toString()) : null;
//	}
//
//	private Exception checkSoftwareNameIsEmptyOrNull(Software software) {
//		boolean result = (software.getName() == null || software.getName().isBlank() || software.getName().isEmpty())
//				? true
//				: false;
//		return result ? new SoftwareNameNotEmptyException(software.toString()) : null;
//	}

}
