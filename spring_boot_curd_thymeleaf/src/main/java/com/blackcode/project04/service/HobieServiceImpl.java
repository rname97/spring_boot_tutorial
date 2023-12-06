package com.blackcode.project04.service;

import com.blackcode.project04.entity.Hobie;
import com.blackcode.project04.entity.User;
import com.blackcode.project04.repository.HobieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class HobieServiceImpl implements HobieService{

    @Autowired
    private HobieRepository hobieRepository;

    @Override
    public Hobie getById(Long id) {
        Optional<Hobie> optional = hobieRepository.findById(id);
        Hobie hobie = null;
        if(optional.isPresent()){
            hobie = optional.get();
        }else{
            throw new RuntimeException("User Not Found Id :"+id);
        }
        return hobie;
    }

    @Override
    public Hobie saveHobie(Hobie hobie) {
        return hobieRepository.save(hobie);
    }

    @Override
    public List<Hobie> fetchHobieList() {
        return hobieRepository.findAll();
    }

    @Override
    public Hobie updateHobie(Hobie hobie, Long hobieId) {
        Hobie hobieDB = hobieRepository.findById(hobieId).get();
        if(Objects.nonNull(hobie.getHobieName()) && !"".equalsIgnoreCase(hobie.getHobieName())){
            hobieDB.setHobieName(hobie.getHobieName());
        }

        return hobieRepository.save(hobieDB);
    }

    @Override
    public void deleteHobie(Long hobieId) {
        hobieRepository.deleteById(hobieId);
    }
}
