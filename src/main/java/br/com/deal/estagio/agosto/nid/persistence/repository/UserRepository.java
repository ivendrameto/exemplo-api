package br.com.deal.estagio.agosto.nid.persistence.repository;

import br.com.deal.estagio.agosto.nid.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>,
        JpaSpecificationExecutor<User>,
        PagingAndSortingRepository<User, Long> {

}
