import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product p1, p2, p3, p4, p5, p6;

    @BeforeEach
    void setUp()
    {
        p1 = new Product("Shirt", "A T-Shirt", "000001", 10.0);
        p2 = new Product("Pants", "Pair of Pants", "000002", 25.0);
        p3 = new Product("Socks", "Pack of Socks", "000003", 5.0);
        p4 = new Product("Shoes", "Nice Shoes", "000004", 75.0);
    }

    @Test
    void getName() {
        assertEquals("Shoes", p4.getName());
    }

    @Test
    void getDescription() {
        assertEquals("Pack of Socks", p3.getDescription());
    }

    @Test
    void getID() {
        assertEquals("000003", p3.getID());
    }

    @Test
    void getCost() {
        assertEquals(75.0, p4.getCost());
    }

    @Test
    void setName() {
        p4.setName("Boots");
        assertEquals("Boots", p4.getName());
    }

    @Test
    void setDescription() {
        p4.setDescription("Long Sleeve Shirt");
        assertEquals("Long Sleeve Shirt", p4.getDescription());
    }

    @Test
    void setCost() {
        p3.setCost(12.5);
        assertEquals(12.5, p3.getCost());
    }

    @Test
    void toCSVDataRecord() {
        assertEquals("000003, Socks, Pack of Socks, 5.0", p3.toCSVDataRecord());
    }
}