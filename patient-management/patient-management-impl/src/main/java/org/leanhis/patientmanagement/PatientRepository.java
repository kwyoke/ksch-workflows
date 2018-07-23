package org.leanhis.patientmanagement;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PatientRepository extends CrudRepository<PatientEntity, UUID> {

    @Query("Select p from PatientEntity p where " +
            "lower(p.name) like lower(concat('%',:nameOrMedicalRecordNumber,'%')) or " +
            "lower(p.medicalRecordNumber) like lower(concat('%',:nameOrMedicalRecordNumber,'%'))" )
    List<PatientEntity> findByNameOrMedicalRecordNumber(@Param("nameOrMedicalRecordNumber") String nameOrMedicalRecordNumber);
}
