package com.example.Topicus.service;
import com.example.Topicus.dto.PrescriptionDto;
import com.example.Topicus.exception.NotFoundException;
import com.example.Topicus.mapper.PrescriptionMapper;
import com.example.Topicus.model.Medicine;
import com.example.Topicus.model.Prescription;
import com.example.Topicus.repository.MedicineRepository;
import com.example.Topicus.repository.PrescriptionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;

    private final MedicineRepository medicineRepository;
    private final ModelMapper modelMapper;

    public PrescriptionService(PrescriptionRepository prescriptionRepository, MedicineRepository medicineRepository, ModelMapper modelMapper) {
        this.prescriptionRepository = prescriptionRepository;
        this.modelMapper = modelMapper;
        this.medicineRepository = medicineRepository;
    }

    //no use of modelmapper since there is a set within the dto which can go wrong in a modelmapper
    public PrescriptionDto getPrescription(Long id) {
        Prescription prescription = prescriptionRepository.findById(id).orElseThrow(() -> new NotFoundException("Prescription not found"));
        PrescriptionDto prescriptionDto = PrescriptionMapper.prescriptionToPrescriptionDto(prescription);
        return prescriptionDto;}


    public List<PrescriptionDto> getAllPrescriptionByPatientId(Long patientId) {
        List<Prescription> prescriptions = prescriptionRepository.findAllByPatientId(patientId);
        return prescriptions.stream()
                .map(PrescriptionMapper::prescriptionToPrescriptionDto)
                .collect(Collectors.toList());
    }


    public PrescriptionDto createPrescription(PrescriptionDto prescriptionDto) {
        Prescription prescription = modelMapper.map(prescriptionDto, Prescription.class);
        prescription.setPrescriptionDate(LocalDate.now());
        List<Long> medicineIds = prescriptionDto.getMedicineIds();
        List<Medicine> medicines = medicineRepository.findAllById(medicineIds);
//      below another solution:
//      List<Medicine> medicineList = new ArrayList<>();
//        for (Long m : medicineIds) {
//            Optional<Medicine> medicineOptional = medicineRepository.findById(m);
//            if (medicineOptional.isPresent()) {
//                Medicine medicine = medicineOptional.get();
//                medicineList.add(medicine);
//            }
//        }
//      prescription.setMedicines(medicineList);
        prescription.setMedicines(medicines);
        Prescription createdPrescription = prescriptionRepository.save(prescription);
        return modelMapper.map(createdPrescription, PrescriptionDto.class);
    }
}