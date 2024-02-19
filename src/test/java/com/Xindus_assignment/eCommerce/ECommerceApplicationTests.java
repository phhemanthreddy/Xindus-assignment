package com.Xindus_assignment.eCommerce;

import com.Xindus_assignment.eCommerce.model.User;
import com.Xindus_assignment.eCommerce.model.WishlistItem;
import com.Xindus_assignment.eCommerce.repository.UserRepository;
import com.Xindus_assignment.eCommerce.repository.WishlistRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class ECommerceApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
        // Initialize sample data when the application context loads

        // Create a sample user
        User user = new User();
        user.setUsername("Phillips");
        user.setPassword(passwordEncoder.encode("123"));
        userRepository.save(user);

        // Create sample wishlist items
        WishlistItem mobile = new WishlistItem();
        mobile.setItemName("mobile");
        wishlistRepository.save(mobile);

        WishlistItem tablet = new WishlistItem();
        tablet.setItemName("tablet");
        wishlistRepository.save(tablet);

        WishlistItem laptop = new WishlistItem();
        laptop.setItemName("laptop");
        wishlistRepository.save(laptop);

        WishlistItem desktop = new WishlistItem();
        desktop.setItemName("desktop");
        wishlistRepository.save(desktop);
    }
}
