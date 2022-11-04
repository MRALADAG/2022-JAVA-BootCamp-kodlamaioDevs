package kodlama.io.Devs.core.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import kodlama.io.Devs.core.utilities.exceptions.SoftwareIdNotEmptyException;
import kodlama.io.Devs.core.utilities.exceptions.SoftwareIdNotEqualException;
import kodlama.io.Devs.core.utilities.exceptions.SoftwareNameNotEmptyException;
import kodlama.io.Devs.core.utilities.exceptions.SoftwareNameNotEqualException;
import kodlama.io.Devs.core.utilities.exceptions.SoftwareNotFoundException;
import kodlama.io.Devs.dataAccess.abstracts.SoftwareRepository;
import kodlama.io.Devs.entities.concretes.Software;

@Component
public class CheckValidityForSoftware {

	@Autowired
	private SoftwareRepository softwareRepository;

	public Exception isValid(List<Exception> logics) throws Exception {

		for (Exception error : logics) {
			if (error != null) {
				throw error;
			}

		}

		return null;

	}

	public Exception checkSoftwareId(Software software) {
		List<Software> softwares = softwareRepository.getAll();
		boolean result = softwares.stream().anyMatch(item -> item.getId() == software.getId());
		return result ? new SoftwareIdNotEqualException(software.toString()) : null;
	}

	public Exception checkSoftwareById(int softwareId) {
		List<Software> softwares = softwareRepository.getAll();
		boolean result = softwares.stream().anyMatch(item -> item.getId() == softwareId);
		return result ? null : new SoftwareNotFoundException("\nid : " + String.valueOf(softwareId));
	}

	public Exception checkIfId(int softwareId) {

		return softwareId == 0 ? new SoftwareIdNotEmptyException("\nid : " + String.valueOf(softwareId)) : null;
	}

	public Exception checkSoftwareName(Software software) {
		List<Software> softwares = softwareRepository.getAll();
		boolean result = softwares.stream().anyMatch(item -> item.getName().equalsIgnoreCase(software.getName()));
		return result ? new SoftwareNameNotEqualException(software.toString()) : null;
	}

	public Exception checkSoftwareNameIsEmptyOrNull(Software software) {
		boolean result = (software.getName() == null || software.getName().isBlank() || software.getName().isEmpty())
				? true
				: false;
		return result ? new SoftwareNameNotEmptyException(software.toString()) : null;
	}

}

//public class CheckValidityForSoftware {
//
//	public static Exception isValid(List<Exception> logics) throws Exception {
//		for (Exception error : logics) {
//				if (error!=null) {
//					throw error;
//				}
//			
//		}
//
//		return null;
//	}
//	return new HashMap<Boolean, Exception>() {
///	**
// 	* 
// 	*/
//	private static final long serialVersionUID = -1311692485648063892L;
//
//		{
//			put(true, null);
//		}
//	};
//
//}
