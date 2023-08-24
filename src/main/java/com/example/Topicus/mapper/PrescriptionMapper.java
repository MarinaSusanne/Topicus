package com.example.Topicus.mapper;
import com.example.Topicus.dto.PrescriptionDto;
import com.example.Topicus.model.Medicine;
import com.example.Topicus.model.Prescription;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class PrescriptionMapper {

   public static PrescriptionDto prescriptionToPrescriptionDto (Prescription prescription){
           PrescriptionDto prescriptionDto = new PrescriptionDto();
           prescriptionDto.setId(prescription.getId());
           prescriptionDto.setPrescriptionInfo(prescription.getPrescriptionInfo());
           prescriptionDto.setPrescriptionDate(prescription.getPrescriptionDate());
           prescriptionDto.setEndDate(prescription.getEndDate());
           prescriptionDto.setDeliveryMethod(prescription.getDeliveryMethod());
           prescriptionDto.setPatientId(prescription.getPatient().getId());

           List<Medicine> medicines = new ArrayList<>();
             medicines.addAll(prescription.getMedicines());
                 List<Long> medicineIds = medicines.stream()
                     .map(Medicine::getId)
                     .collect(Collectors.toList());
                 prescriptionDto.setMedicineIds(medicineIds);
           return prescriptionDto;
       }
   }

