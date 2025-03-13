package com.devsuperior.dsmeta.repositories;
import com.devsuperior.dsmeta.projections.SaleMinProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;


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

    @Query(value = "SELECT TB_SELLER.NAME , ROUND(SUM(TB_SALES.AMOUNT),2) AS amount " +
            "FROM TB_SALES " +
            "INNER JOIN TB_SELLER ON TB_SELLER.ID = TB_SALES.SELLER_ID " +
            "WHERE TB_SALES.DATE BETWEEN :minDate AND :maxDate "+
            "GROUP BY TB_SELLER.NAME "
            , nativeQuery = true)
    List<SaleMinProjection> searchSalesSummary(LocalDate minDate, LocalDate maxDate);

}