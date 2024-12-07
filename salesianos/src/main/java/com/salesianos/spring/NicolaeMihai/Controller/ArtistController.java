/*
 * 
 * 
 * 
 */
package com.salesianos.spring.NicolaeMihai.Controller;

import org.springframework.stereotype.Controller;

/**
 *
 * @author Baljeet
 */
@Controller
public class ArtistController {
    
    private Long id;
    private String name;

    public ArtistController(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
