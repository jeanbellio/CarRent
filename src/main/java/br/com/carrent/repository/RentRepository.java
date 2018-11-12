package br.com.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carrent.model.Rent;

public interface RentRepository extends JpaRepository<Rent, Long>{

}
