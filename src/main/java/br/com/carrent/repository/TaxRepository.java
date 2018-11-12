package br.com.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carrent.model.Tax;

public interface TaxRepository extends JpaRepository<Tax, Long>{

	double findByNomeTaxa(String string);

}
