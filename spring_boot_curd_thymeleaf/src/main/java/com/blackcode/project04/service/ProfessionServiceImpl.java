package com.blackcode.project04.service;

import com.blackcode.project04.entity.Profession;
import com.blackcode.project04.repository.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProfessionServiceImpl implements ProfessionService{

    @Autowired
    private ProfessionRepository professionRepository;
    @Override
    public Profession getById(long Id) {
        Optional<Profession> optional = professionRepository.findById(Id);
        Profession profession = null;
        if(optional.isPresent()){
            profession = optional.get();
        }else{
            throw new RuntimeException("Data Not Found Id :"+Id);
        }
        return profession;
    }

    @Override
    public List<Profession> fetchProfessionList() {
        return professionRepository.findAll();
    }

    @Override
    public Profession saveProfession(Profession profession) {
        return professionRepository.save(profession);
    }

    @Override
    public Profession updateProfession(Profession profession, Long Id) {
        Profession professionDB = professionRepository.findById(Id).get();
        if(Objects.nonNull(profession.getProfessionName()) && !"".equalsIgnoreCase(profession.getProfessionName())){
            professionDB.setProfessionName(profession.getProfessionName());
        }
        return professionRepository.save(professionDB);
    }

    @Override
    public void deleteProfession(Long Id) {
        professionRepository.deleteById(Id);
    }
}
