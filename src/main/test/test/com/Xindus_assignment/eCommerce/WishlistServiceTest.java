package com.Xindus_assignment.eCommerce;

import com.Xindus_assignment.eCommerce.model.WishlistItem;
import com.Xindus_assignment.eCommerce.repository.WishlistRepository;
import com.Xindus_assignment.eCommerce.service.WishlistService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class WishlistServiceTest {

    @InjectMocks
    private WishlistService wishlistService;

    @Mock
    private WishlistRepository wishlistRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveWishlist() {
        // Given
        List<WishlistItem> sampleWishlist = new ArrayList<>();
        sampleWishlist.add(new WishlistItem(1L, "mobile"));
        sampleWishlist.add(new WishlistItem(2L, "tablet"));

        when(wishlistRepository.findAll()).thenReturn(sampleWishlist);

        // When
        List<WishlistItem> retrievedWishlist = wishlistService.retrieveWishlist();

        // Then
        assertEquals(2, retrievedWishlist.size());
        // Add more assertions as needed based on your business logic
    }

    @Test
    public void testAddWishlistItem() {
        // Given
        WishlistItem newItem = new WishlistItem(3L, "laptop");

        // When
        wishlistService.addWishlistItem(newItem);

        // Then
        verify(wishlistRepository, times(1)).save(newItem);
        // Add more assertions as needed based on your business logic
    }

    @Test
    public void testDeleteWishlistItem() {
        // Given
        Long itemId = 1L;

        // When
        wishlistService.deleteWishlistItem(itemId);

        // Then
        verify(wishlistRepository, times(1)).deleteById(itemId);
        // Add more assertions as needed based on your business logic
    }
}
