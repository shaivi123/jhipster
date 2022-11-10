package com.app.web.rest;

import com.app.domain.College;
import com.app.repository.CollegeRepository;
import com.app.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional; 
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.app.domain.College}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class CollegeResource {

    private final Logger log = LoggerFactory.getLogger(CollegeResource.class);

    private static final String ENTITY_NAME = "college";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CollegeRepository collegeRepository;

    public CollegeResource(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    /**
     * {@code POST  /colleges} : Create a new college.
     *
     * @param college the college to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new college, or with status {@code 400 (Bad Request)} if the college has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/colleges")
    public ResponseEntity<College> createCollege(@RequestBody College college) throws URISyntaxException {
        log.debug("REST request to save College : {}", college);
        if (college.getId() != null) {
            throw new BadRequestAlertException("A new college cannot already have an ID", ENTITY_NAME, "idexists");
        }
        College result = collegeRepository.save(college);
        return ResponseEntity.created(new URI("/api/colleges/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /colleges} : Updates an existing college.
     *
     * @param college the college to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated college,
     * or with status {@code 400 (Bad Request)} if the college is not valid,
     * or with status {@code 500 (Internal Server Error)} if the college couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/colleges")
    public ResponseEntity<College> updateCollege(@RequestBody College college) throws URISyntaxException {
        log.debug("REST request to update College : {}", college);
        if (college.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        College result = collegeRepository.save(college);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, college.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /colleges} : get all the colleges.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of colleges in body.
     */
    @GetMapping("/colleges")
    public List<College> getAllColleges() {
        log.debug("REST request to get all Colleges");
        return collegeRepository.findAll();
    }

    /**
     * {@code GET  /colleges/:id} : get the "id" college.
     *
     * @param id the id of the college to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the college, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/colleges/{id}")
    public ResponseEntity<College> getCollege(@PathVariable Long id) {
        log.debug("REST request to get College : {}", id);
        Optional<College> college = collegeRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(college);
    }

    /**
     * {@code DELETE  /colleges/:id} : delete the "id" college.
     *
     * @param id the id of the college to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/colleges/{id}")
    public ResponseEntity<Void> deleteCollege(@PathVariable Long id) {
        log.debug("REST request to delete College : {}", id);
        collegeRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
