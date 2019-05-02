/**
 * 
 */
package com.platzi.ereservation.business.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.platzi.ereservation.model.Reservation;

/**
 * @author Camilo Valenzuela
 *
 */
public interface ReservationRepository extends JpaRepository<Reservation, String>{

	@Query("Select r from Reservation r where r.dateInput =: dateInput and r.dateOutput =: dateOutput")
	public List<Reservation> find(@Param("dateInput") Date dateInput, @Param("dateOutput")Date dateOutput);
}
