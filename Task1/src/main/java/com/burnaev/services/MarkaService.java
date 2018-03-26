package com.burnaev.services;


import com.burnaev.models.Marka;

import java.util.List;

public interface MarkaService {
    Marka getMarka(long id);
    List<Marka> getMarks();
}
