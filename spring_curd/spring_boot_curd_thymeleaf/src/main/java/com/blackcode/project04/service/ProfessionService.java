package com.blackcode.project04.service;

import com.blackcode.project04.entity.Profession;

import java.util.List;

public interface ProfessionService {
    Profession getById(long Id);
    List<Profession> fetchProfessionList();
    Profession saveProfession(Profession profession);
    Profession updateProfession(Profession profession, Long Id);
    void deleteProfession(Long Id);
}
