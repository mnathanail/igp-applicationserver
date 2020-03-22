package com.diaulos.igp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diaulos.igp.model.Cert;

public interface CertDao extends JpaRepository<Cert, Integer> {

	 List<Cert> findAll();
	 //List<Cert> getPistosByName(String cName);
	
}
