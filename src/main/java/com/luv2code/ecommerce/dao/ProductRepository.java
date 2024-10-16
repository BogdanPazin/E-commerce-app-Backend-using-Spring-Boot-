package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

// OVIM SE OMOGUCAVA IZVRSAVANJE JAVASCRIPT FAJLOVA
// SADA CE SE PRIHVATATI POZIVI SCRIPT-OVA SA PRETRAZIVACA SA OVOG ORIGIN-A
@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Integer> {
//    OVO JE QUERY METODA JER KRECE SA findBy|readBy|queryBy, NA OSNOVU OVOGA SPRING PRAVI QUERY
//    GDE NALAZI PROIZVODE ZA ODGOVARAJUCU KATEGORIJU
//    TAKODJE SPRING DATA REST AUTOMATSKI OMOGUCAVA ENDPOINT: /api/products/search/findByCategoryId?id=xxx
    Page<Product> findByCategoryId(@Param("id") Integer id, Pageable pageable);

//    ******* OVO STO JE STAVLJENO KAO ANOTACIJA @Param("") CE SE DODATI NA KRAJ LINKA KOJI SE OSPOSOBLJAVA KAO STO JE OVDE ?id= ILI ?name=

    Page<Product> findByNameContaining(@Param("name") String name, Pageable pageable);

//    PAGE I PAGEABLE OMOGUCAVAJU PAGINATION

//    PAGE IMA INFORMACIJE ZA UKUPNO ELEMENATA, UKUPNO STRANICA, TRENUTNA POZICIJA, ...
//    PAGEABLE IMA INFORMACIJE ZA BROJ STRANICE, VELICINA STRANICE, PRETHODNA/SLEDECA STRANICA, ...

//    SPRING DATA REST AUTOMATSKI OMOGUCAVA PAGINATION, PRI CEMU SU STRANICE OZNACENE OD 0-...
}
