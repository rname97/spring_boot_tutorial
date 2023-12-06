package com.blackcode.project04.service;

import com.blackcode.project04.entity.Hobie;

import java.util.List;

public interface HobieService {

    Hobie getById(Long id);
    Hobie saveHobie(Hobie hobie);
    List<Hobie> fetchHobieList();
    Hobie updateHobie(Hobie hobie, Long hobieId);
    void deleteHobie(Long hobieId);
}
