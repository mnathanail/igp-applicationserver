package com.diaulos.igp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diaulos.igp.model.Cert;
import com.diaulos.igp.model.CertResponseModel;
import com.diaulos.igp.service.CompanyCertificationSelfService;

@RestController
@RequestMapping(path = "/pistoi")
public class CertController {

	@Autowired
	private CompanyCertificationSelfService companyCertificationSelfService;

	@GetMapping("/")
	public String index() {

		return "silence is gold";
	}

	@GetMapping("/bulkcreate")
	public String bulkcreate() {
		// save a single Customer

		this.companyCertificationSelfService.save(new Cert(1, "makis", true, true, true, true, true, true, true, true, true, true, true, true, true, true));
		// save a list of Customers
		this.companyCertificationSelfService.saveAll(
				Arrays.asList(
						new Cert(1, "makis", true, true, true, true, true, true, true, true, true, true, true, true, true, true),
						new Cert(1, "takis", true, true, true, true, true, true, true, true, true, true, true, true, true, true),
						new Cert(1, "lakis", true, true, true, true, true, true, true, true, true, true, true, true, true, true),
						new Cert(1, "sakis", true, true, true, true, true, true, true, true, true, true, true, true, true, true)
						));
		return "Certifications are created";
	}

	@PostMapping("/create")
	public CertResponseModel create(@RequestBody Cert cert) {
		this.companyCertificationSelfService.save(
				new Cert(
					cert.getCompanyId(), cert.getRegulatedActivity(), cert.getDocument1(), cert.getDocument2(),cert.getDocument3(),
					cert.getDocument4(),cert.getDocument5(),cert.getDocument6(),cert.getDocument7(),cert.getDocument8(),cert.getDocument9(),
					cert.getDocument10(),cert.getDocument11(),cert.getDocument12(),cert.getDocument13(),cert.getDocument14())
				);
		return new CertResponseModel("Success");
	}

	@GetMapping("/findall")
	public List<Cert> findAll() {
		final List<Cert> certs = this.companyCertificationSelfService.findAll();
		final List<Cert> certRes = new ArrayList<>();
		for (final Cert cert : certs) {
			certRes.add(
					new Cert(
						cert.getCompanyId(), cert.getRegulatedActivity(), cert.getDocument1(), cert.getDocument2(),cert.getDocument3(),
						cert.getDocument4(),cert.getDocument5(),cert.getDocument6(),cert.getDocument7(),cert.getDocument8(),cert.getDocument9(),
						cert.getDocument10(),cert.getDocument11(),cert.getDocument12(),cert.getDocument13(),cert.getDocument14())
					);
		}
		return certRes;
	}

	@RequestMapping("/search/{id}")
	public String search(@PathVariable("id") Integer id) {
		String cert = "";
		cert = this.companyCertificationSelfService.findById(id).toString();
		return cert;
	}

	/*
	 * @RequestMapping("/searchbyName/{name}") public List<Cert>
	 * fetchDataByName(@PathVariable("name") String name){ List<Cert> certs =
	 * certDao.getPistosByName(name); List<Cert> certRes = new ArrayList<>(); for
	 * (Cert cert : certs) { certRes.add(new
	 * Cert(cert.getcId(),cert.getcName(),cert.getcTin(),cert.getcTitle())); }
	 * return certs; }
	 */

}
