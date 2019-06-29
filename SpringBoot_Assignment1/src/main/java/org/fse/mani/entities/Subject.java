package org.fse.mani.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "subject")
public class Subject implements Serializable {
    private long subjectId;
    private String subtitle;
    private int durationInHours;

    private Set<Book> references;

    public Subject() {
    }

    public Subject(long subjectId) {
        this.subjectId = subjectId;
    }

    public Subject(long subjectId, String subtitle, int durationInHours, Set<Book> references) {
        this.subjectId = subjectId;
        this.subtitle = subtitle;
        this.durationInHours = durationInHours;
        this.references = references;
    }

    public Subject(String subtitle, int durationInHours) {
        this.subtitle = subtitle;
        this.durationInHours = durationInHours;
    }

    @Id
    @Column(name = "subjectid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    @Column(name = "subtitle")
    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    @Column(name = "durationinhours")
    public int getDurationInHours() {
        return durationInHours;
    }

    public void setDurationInHours(int durationInHours) {
        this.durationInHours = durationInHours;
    }

    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    public Set<Book> getReferences() {
        return references;
    }

    public void setReferences(Set<Book> references) {
        this.references = references;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return subjectId == subject.subjectId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(subjectId);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subtitle='" + subtitle + '\'' +
                ", durationInHours=" + durationInHours +
                '}';
    }
}
