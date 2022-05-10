package de.tekup.payment.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.payment.entites.Payment;

public interface PaymentRepos extends JpaRepository<Payment,Long>{

}
