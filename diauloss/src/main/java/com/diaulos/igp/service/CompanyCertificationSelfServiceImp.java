package com.diaulos.igp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diaulos.igp.model.Cert;
import com.diaulos.igp.repo.CertDao;

@Service
public class CompanyCertificationSelfServiceImp implements CompanyCertificationSelfService {


	@Autowired
	private CertDao certDao;

	@Override
	@Transactional
	public List<Cert> findAll() {
		return this.certDao.findAll();
	}

	@Override
	public void save(Cert cert) {
		this.certDao.save(cert);
	}

	@Override
	public Cert findById(Integer id) {
		return this.certDao.findById(id).get();
	}

	@Override
	public void saveAll(List<Cert> certs) {
		this.certDao.saveAll(certs);

	}

}
