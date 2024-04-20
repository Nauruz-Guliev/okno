package ru.kpfu.itis.gnt.okno.dal.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@Table(name = "attachments")
@Entity
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected String name;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    protected Task task;

    @Column(nullable = false)
    protected String contentType;

    @Column(nullable = false)
    protected byte[] content;



}
