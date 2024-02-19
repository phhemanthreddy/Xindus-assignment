package com.Xindus_assignment.eCommerce;

import com.Xindus_assignment.eCommerce.model.WishlistItem;
import com.Xindus_assignment.eCommerce.repository.WishlistRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class WishlistRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private WishlistRepository wishlistRepository;

    @Test
    public void testSaveWishlistItem() {
        // Given
        WishlistItem wishlistItem = new WishlistItem();
        wishlistItem.setItemName("mobile");

        // When
        WishlistItem savedItem = wishlistRepository.save(wishlistItem);
        entityManager.flush();

        // Then
        assertNotNull(savedItem.getId());
        WishlistItem retrievedItem = wishlistRepository.findById(savedItem.getId()).orElse(null);
        assertNotNull(retrievedItem);
        assertEquals("mobile", retrievedItem.getItemName());
    }

    // Add similar tests for other CRUD operations if needed
}
