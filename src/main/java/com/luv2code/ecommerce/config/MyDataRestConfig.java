package com.luv2code.ecommerce.config;

import com.luv2code.ecommerce.entity.Country;
import com.luv2code.ecommerce.entity.Product;
import com.luv2code.ecommerce.entity.ProductCategory;
import com.luv2code.ecommerce.entity.State;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // PODESAVAM DA API-EVI BUDE READ-ONLY
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        // OVIM ONEMOGUCAVAM HTTP METODE ZA Product: POST, PUT, DELETE
        // SA OVIM NECE ONDA SPRING DATA REST DA PRAVI ENDPOINT-OVE POST, PUT, DELETE
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

        // OVIM ONEMOGUCAVAM HTTP METODE ZA ProductCategory: POST, PUT, DELETE
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

        config.getExposureConfiguration()
                .forDomainType(Country.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

        config.getExposureConfiguration()
                .forDomainType(State.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

//        OVO JE DEO KOJI OMOGUCAVA DA SE DOBIJE LISTA PROIZVODA NA OSNOVU ID KATEGORIJE
//        I DA SE DOBIJE PROIZVOD NA OSNOVU NJEGOVOG ID-A
        exposeIds(config);
    }

    //        OTKRIVAM ID ZA ENTITETE, SADA CE PRILIKOM ODLASKA NA LINK
    //        api/product-category, U _embedded DELU PRIKAZATI id KAO VREDNOST, GDE JE PRE MOGLA DA SE VIDI SAMO U HREF LINKU
    private void exposeIds(RepositoryRestConfiguration config) {

//        DOBIJAM LISTU SVIH KLASA ENTITETA
        Set<EntityType<?>> entityClasses = entityManager.getMetamodel().getEntities();

//        PRAVIM NIZ TIPOVA ENTITETA
        List<Class> entityTypes = new ArrayList<>();

        for(EntityType entityClass : entityClasses){
            entityTypes.add(entityClass.getJavaType());
        }

//        OTKRIVAM ID ZA NIZ TIPOVA ENTITETA
        Class[] domainTypes = entityTypes.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }
}
