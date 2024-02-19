package com.Xindus_assignment.eCommerce;

import com.Xindus_assignment.eCommerce.controller.WishlistController;
import com.Xindus_assignment.eCommerce.model.WishlistItem;
import com.Xindus_assignment.eCommerce.service.WishlistService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WishlistControllerTest {

    @InjectMocks
    private WishlistController wishlistController;

    @Mock
    private WishlistService wishlistService;

    private WishlistItem sampleWishlistItem;

    @Before
    public void setUp() {
        // Initialize sample wishlist item for testing
        sampleWishlistItem = new WishlistItem();
        sampleWishlistItem.setId(1L);
        sampleWishlistItem.setItemName("mobile");
    }

    @Test
    public void testGetWishlist() {
        // Mock dependencies
        when(wishlistService.getWishlistItems()).thenReturn(Arrays.asList(sampleWishlistItem));

        // Perform request to controller endpoint
        ResponseEntity<List<WishlistItem>> response = wishlistController.getWishlist();

        // Assert the response status and content
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Arrays.asList(sampleWishlistItem), response.getBody());

        // Verify that wishlistService method is called once
        verify(wishlistService, times(1)).getWishlistItems();
    }

    @Test
    public void testAddWishlistItem() {
        // Mock dependencies
        when(wishlistService.addWishlistItem(any(WishlistItem.class))).thenReturn(sampleWishlistItem);

        // Perform request to controller endpoint
        ResponseEntity<WishlistItem> response = wishlistController.addWishlistItem(sampleWishlistItem);

        // Assert the response status and content
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(sampleWishlistItem, response.getBody());

        // Verify that wishlistService method is called once with the provided wishlist item
        verify(wishlistService, times(1)).addWishlistItem(sampleWishlistItem);
    }

    @Test
    public void testDeleteWishlistItem() {
        // Mock dependencies
        doNothing().when(wishlistService).deleteWishlistItem(1L);

        // Perform request to controller endpoint
        ResponseEntity<Void> response = wishlistController.deleteWishlistItem(1L);

        // Assert the response status
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

        // Verify that wishlistService method is called once with the provided ID
        verify(wishlistService, times(1)).deleteWishlistItem(1L);
    }
}
