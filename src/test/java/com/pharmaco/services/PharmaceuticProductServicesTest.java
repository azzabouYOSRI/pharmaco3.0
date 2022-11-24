package com.pharmaco.services;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.pharmaco.entities.PharmaceuticProduct;
import com.pharmaco.repository.PharmaceuticProductRepository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PharmaceuticProductServices.class})
@ExtendWith(SpringExtension.class)
class PharmaceuticProductServicesTest {
    @MockBean
    private PharmaceuticProductRepository pharmaceuticProductRepository;

    @Autowired
    private PharmaceuticProductServices pharmaceuticProductServices;

    /**
     * Method under test: {@link PharmaceuticProductServices#findAllProduit()}
     */
    @Test
    void testFindAllProduit() {
        ArrayList<PharmaceuticProduct> pharmaceuticProductList = new ArrayList<>();
        when(pharmaceuticProductRepository.findAll()).thenReturn(pharmaceuticProductList);
        List<PharmaceuticProduct> actualFindAllProduitResult = pharmaceuticProductServices.findAllProduit();
        assertSame(pharmaceuticProductList, actualFindAllProduitResult);
        assertTrue(actualFindAllProduitResult.isEmpty());
        verify(pharmaceuticProductRepository).findAll();
    }
}
