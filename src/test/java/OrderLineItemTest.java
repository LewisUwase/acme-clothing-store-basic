import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderLineItemTest {
    
    @Test
    void getTotalPrice_calculatesCorrectly_withRealItem() {
        // Real Item test: 25.99 * 3 = 77.97
        Item laptop = new Item("Laptop", 25.99);
        OrderLineItem lineItem = new OrderLineItem(laptop, 3);
        
        assertEquals(77.97, lineItem.getTotalPrice(), 1e-9);
        assertEquals(3, lineItem.getQuantity());
        assertEquals(laptop, lineItem.getItem());
    }
    
    @Test
    void getTotalPrice_withSingleQuantity_returnsItemPrice() {
        // Edge case: quantity of 1
        Item mouse = new Item("Mouse", 15.50);
        OrderLineItem lineItem = new OrderLineItem(mouse, 1);
        
        assertEquals(15.50, lineItem.getTotalPrice(), 1e-9);
    }
    
    @Test
    void mockItem_getTotalPrice_usesItemPrice() {
        // Mock the Item to control its price
        Item mockItem = mock(Item.class);
        when(mockItem.getPrice()).thenReturn(100.0);
        when(mockItem.getName()).thenReturn("MockedProduct");
        
        OrderLineItem lineItem = new OrderLineItem(mockItem, 5);
        
        // Should calculate 100.0 * 5 = 500.0
        assertEquals(500.0, lineItem.getTotalPrice(), 1e-9);
        
        // Verify that getPrice() was called during calculation
        verify(mockItem, atLeastOnce()).getPrice();
    }
    
    @Test
    void stubOrderLineItem_overrideTotalPrice_ignoringItemPrice() {
        // Stub by subclassing OrderLineItem to return fixed total
        Item anyItem = new Item("AnyItem", 10.0);
        
        OrderLineItem stubbedLineItem = new OrderLineItem(anyItem, 2) {
            @Override
            public double getTotalPrice() {
                return 250.0; // Fixed total regardless of item price/quantity
            }
        };
        
        // Even though item is 10.0 and quantity is 2, stub returns 250.0
        assertEquals(250.0, stubbedLineItem.getTotalPrice(), 1e-9);
        assertNotEquals(20.0, stubbedLineItem.getTotalPrice()); // Would be 20 without stub
    }
}