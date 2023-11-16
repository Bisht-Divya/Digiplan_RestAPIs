package com.digiplan.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@Data
@Entity
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "FieldHandler"})
@NoArgsConstructor
@Table(name = "case_connection_with_patient")
public class PatientDoctorMapping {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "case_id")
    private String caseId;
    @Column(name = "patient_name")
    private String patientName;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "email")
    private String email;
}
