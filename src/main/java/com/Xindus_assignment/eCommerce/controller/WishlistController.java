package com.Xindus_assignment.eCommerce.controller;

import com.Xindus_assignment.eCommerce.model.WishlistItem;
import com.Xindus_assignment.eCommerce.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlists")
public class WishlistController {

    private final WishlistService wishlistService;

    @Autowired
    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    // GET endpoint to retrieve a user's wishlist
    @GetMapping
    public ResponseEntity<List<WishlistItem>> getWishlist(Authentication authentication) {
        // Get the username from the authentication object
        String username = authentication.getName();

        // Retrieve the wishlist for the authenticated user
        List<WishlistItem> wishlist = wishlistService.getWishlistByUsername(username);

        return ResponseEntity.ok(wishlist);
    }

    // POST endpoint to create a new wishlist item
    @PostMapping
    public ResponseEntity<WishlistItem> addWishlistItem(
            @RequestBody WishlistItem wishlistItem,
            Authentication authentication
    ) {
        // Get the username from the authentication object
        String username = authentication.getName();

        // Set the username for the wishlist item
        wishlistItem.setUsername(username);

        // Save the new wishlist item
        WishlistItem savedItem = wishlistService.addWishlistItem(wishlistItem);

        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    // DELETE endpoint to remove a wishlist item by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWishlistItem(@PathVariable Long id, Authentication authentication) {
        // Get the username from the authentication object
        String username = authentication.getName();

        // Delete the wishlist item by ID for the authenticated user
        wishlistService.deleteWishlistItem(id, username);

        return ResponseEntity.noContent().build();
    }
}
