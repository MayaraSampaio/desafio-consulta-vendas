package com.devsuperior.dsmeta.repositories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;


public interface SaleRepository extends JpaRepository<Sale, Long> {


    @Query(value = "SELECT s FROM Sale s " +
            "JOIN FETCH s.seller seller " +
            "WHERE s.date BETWEEN :minDate AND :maxDate " +
            "AND UPPER(seller.name) LIKE UPPER(CONCAT('%', :nameSeller, '%'))",
            countQuery = "SELECT COUNT(s) FROM Sale s " +
                    "JOIN s.seller seller " +
                    "WHERE s.date BETWEEN :minDate AND :maxDate " +
                    "AND UPPER(seller.name) LIKE UPPER(CONCAT('%', :nameSeller, '%'))")
    Page<Sale> searchAll(LocalDate minDate, LocalDate maxDate, String nameSeller, Pageable pageable);

}