package com.diaulos.igp.service;

import java.util.List;

import com.diaulos.igp.model.Cert;

public interface CompanyCertificationSelfService {
	List<Cert> findAll();
	void save(Cert cert);
	void saveAll(List<Cert> certs);
	Cert findById(Integer id);
}
