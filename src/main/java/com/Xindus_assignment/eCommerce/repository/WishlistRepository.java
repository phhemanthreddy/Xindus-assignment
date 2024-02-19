package com.Xindus_assignment.eCommerce.repository;

import com.Xindus_assignment.eCommerce.model.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for CRUD operations on WishlistItem entities.
 */
public interface WishlistRepository extends JpaRepository<WishlistItem, Long> {

    /**
     * Custom query method to find a wishlist item by its name.
     *
     * @param itemName The name of the wishlist item.
     * @return The WishlistItem entity if found, null otherwise.
     */
    WishlistItem findByItemName(String itemName);

    // Additional methods for CRUD operations if needed
}
