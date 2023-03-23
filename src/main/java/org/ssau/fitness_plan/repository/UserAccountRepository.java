package org.ssau.fitness_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ssau.fitness_plan.model.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

}
