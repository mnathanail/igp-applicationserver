package igp.depo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import igp.depo.model.AdminModel;


public interface AdminDao extends JpaRepository<AdminModel, Integer> {

	AdminModel findByAdminusername(String username);
}
