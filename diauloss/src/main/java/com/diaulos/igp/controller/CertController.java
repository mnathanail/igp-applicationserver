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
		this.companyCertificationSelfService.save(new Cert(1, "Ougk", "5001485", "kati"));
		// save a list of Customers
		this.companyCertificationSelfService.saveAll(Arrays.asList(new Cert(2, "Ougks", "5001485", "kati"), new Cert(3, "Ougkss", "5001485", "kati"),
				new Cert(4, "Ougksss", "5001485", "kati"), new Cert(5, "Ougkssss", "5001485", "kati")));
		return "Certifications are created";
	}

	@PostMapping("/create")
	public String create(@RequestBody Cert cert) {
		this.companyCertificationSelfService.save(new Cert(cert.getcId(), cert.getcName(), cert.getcTin(), cert.getcTitle()));
		return "Certification is created";
	}

	@GetMapping("/findall")
	public List<Cert> findAll() {
		final List<Cert> certs = this.companyCertificationSelfService.findAll();
		final List<Cert> certRes = new ArrayList<>();
		for (final Cert cert : certs) {
			certRes.add(new Cert(cert.getcId(), cert.getcName(), cert.getcTin(), cert.getcTitle()));
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
