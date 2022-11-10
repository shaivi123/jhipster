package com.app.domain;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A College.
 */
@Entity
@Table(name = "college")
public class College implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "clg_name")
    private String clgName;

    @Column(name = "course")
    private String course;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClgName() {
        return clgName;
    }

    public College clgName(String clgName) {
        this.clgName = clgName;
        return this;
    }

    public void setClgName(String clgName) {
        this.clgName = clgName;
    }

    public String getCourse() {
        return course;
    }

    public College course(String course) {
        this.course = course;
        return this;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof College)) {
            return false;
        }
        return id != null && id.equals(((College) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "College{" +
            "id=" + getId() +
            ", clgName='" + getClgName() + "'" +
            ", course='" + getCourse() + "'" +
            "}";
    }
}
