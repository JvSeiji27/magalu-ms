package joaovitorseiji.com.magalu_microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import joaovitorseiji.com.magalu_microservices.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {

}
