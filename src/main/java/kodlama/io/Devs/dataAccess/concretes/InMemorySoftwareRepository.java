package kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import kodlama.io.Devs.dataAccess.abstracts.SoftwareRepository;
import kodlama.io.Devs.entities.concretes.Software;

@Repository
public class InMemorySoftwareRepository implements SoftwareRepository {

	List<Software> softwares;

	public InMemorySoftwareRepository() {
		softwares = new ArrayList<Software>();

		softwares.add(new Software(1, "C"));
		softwares.add(new Software(2, "C#"));
		softwares.add(new Software(3, "C++"));
		softwares.add(new Software(4, "JAVA"));
		softwares.add(new Software(5, "JavaScript"));
		softwares.add(new Software(6, "React"));
		softwares.add(new Software(7, "VUE"));
		softwares.add(new Software(8, "ANGULAR"));
		softwares.add(new Software(9, "PYTHON"));
	}

	@Override
	public Software addSoftware(Software software) {
		softwares.add(software);
		return software;
	}

	@Override
	public Software updateSoftware(Software software) {

		return softwares.stream().filter(item -> item.getId() == software.getId()).findAny().get();
	}

	@Override
	public Software getSoftwareById(int softwareId) {
		return softwares.stream().filter(item -> item.getId() == softwareId).findAny().get();
	}

	@Override
	public void deleteSoftwareById(int softwareId) {
		this.softwares = softwares.stream().filter(desiredList -> desiredList.getId() != softwareId)
				.collect(Collectors.toList());
	}

	@Override
	public List<Software> getAll() {
		return softwares;
	}

}
