package org.example.app.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DecimalFormat;


class BonusServiceTest {

    private BonusService service;

    @BeforeEach
    void setUp() {
        service = new BonusService();
    }


    @DisplayName("Test Bonus Service calculated.")
    @Test
    void test_Bonus_Service_With_Expected_Bonus() {

        double sales = 1000;
        double expectedBonus = sales * 10 / 100;
        assertEquals(expectedBonus, service.calcBonus(sales));
    }


    @DisplayName("Test Bonus Service expected.")
    @Test
    void test_Bonus_Service_With_Expected_Result() {

        double sales = 1000;
        String expectedResult = new DecimalFormat("0.00").format(sales * 10 / 100);
        assertEquals(expectedResult, service.getRes(sales));
    }


    @DisplayName("Test Bonus Service unexpected.")
    @Test
    void test_Bonus_Service_With_Unexpected_Result() {

        double sales = -1000;
        String unExpectedResult = new DecimalFormat("0.00").format(sales * 10 / 100);
        assertNotEquals(unExpectedResult, service.getRes(sales));
    }

    @AfterEach
    void tearDown() {
        service = null;
    }

}