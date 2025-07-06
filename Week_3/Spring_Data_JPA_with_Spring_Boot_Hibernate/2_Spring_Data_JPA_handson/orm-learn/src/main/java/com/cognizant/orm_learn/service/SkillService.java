package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Skill;
import com.cognizant.orm_learn.repository.SkillRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SkillService.class);

    @Autowired
    private SkillRepository skillRepository;

    @Transactional
    public Skill get(int id) {
        LOGGER.info("Start - get skill by id");
        return skillRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Skill skill) {
        LOGGER.info("Start - save skill");
        skillRepository.save(skill);
        LOGGER.info("End - save skill");
    }
}
