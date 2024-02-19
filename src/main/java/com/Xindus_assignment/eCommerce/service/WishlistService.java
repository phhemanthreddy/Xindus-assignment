package com.Xindus_assignment.eCommerce.service;

import com.Xindus_assignment.eCommerce.model.WishlistItem;
import com.Xindus_assignment.eCommerce.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    /**
     * Retrieve a user's wishlist.
     *
     * @return List of wishlist items
     */
    public List<WishlistItem> retrieveWishlist() {
        // Implement logic to retrieve wishlist items, e.g., by user ID
        // You may also perform additional business logic here if needed
        return wishlistRepository.findAll();
    }

    /**
     * Add a new wishlist item.
     *
     * @param itemName Name of the wishlist item
     * @return The added wishlist item
     */
    public WishlistItem addWishlistItem(String itemName) {
        // Implement logic to add a new wishlist item
        WishlistItem wishlistItem = new WishlistItem();
        wishlistItem.setItemName(itemName);
        // Additional logic can be added here, e.g., validation or processing
        return wishlistRepository.save(wishlistItem);
    }

    /**
     * Remove a wishlist item by ID.
     *
     * @param itemId ID of the wishlist item to be removed
     * @return True if the item is successfully removed, false otherwise
     */
    public boolean deleteWishlistItem(Long itemId) {
        // Implement logic to delete a wishlist item by ID
        Optional<WishlistItem> optionalItem = wishlistRepository.findById(itemId);
        if (optionalItem.isPresent()) {
            wishlistRepository.deleteById(itemId);
            return true;
        }
        return false;
    }
}
