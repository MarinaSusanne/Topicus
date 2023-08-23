package com.example.Topicus.service;

import com.example.Topicus.dto.MedicineDto;
import com.example.Topicus.dto.PackagingDto;
import com.example.Topicus.exception.NotFoundException;
import com.example.Topicus.model.Medicine;
import com.example.Topicus.model.Packaging;
import com.example.Topicus.repository.MedicineRepository;
import com.example.Topicus.repository.PrescriptionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MedicineService {

    private final MedicineRepository medicineRepository;

    private final ModelMapper modelMapper;

    public MedicineService(MedicineRepository medicineRepository,  ModelMapper modelMapper) {
        this.medicineRepository = medicineRepository;
        this.modelMapper = modelMapper;
    }

    public MedicineDto getMedicine(Long id) {
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Medicine not found"));
        MedicineDto medicineDto = modelMapper.map(medicine, MedicineDto.class);
        return medicineDto;
    }

    public MedicineDto createMedicine(MedicineDto medicineDto) {
        Medicine medicine = new Medicine();
        medicine.setName(medicineDto.getName());

        PackagingDto packagingDto = medicineDto.getPackaging();
        if (packagingDto != null) {
            Packaging packaging = new Packaging();
            packaging.setType(packagingDto.getType());
            packaging.setUnitsPerPackage(packagingDto.getUnitsPerPackage());
            packaging.setAmountPerUnit(packagingDto.getAmountPerUnit());
            medicine.setPackaging(packaging);
        }

        Medicine createdMedicine = medicineRepository.save(medicine);
        MedicineDto createdMedicineDto = modelMapper.map(createdMedicine, MedicineDto.class);
        return createdMedicineDto;
    }
}



