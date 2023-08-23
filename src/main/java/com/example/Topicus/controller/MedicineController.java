package com.example.Topicus.controller;
import com.example.Topicus.dto.MedicineDto;
import com.example.Topicus.service.MedicineService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/medicines")
public class MedicineController {

    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService){
        this.medicineService=medicineService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicineDto> getMedicine(@PathVariable Long Id) {
        MedicineDto medicineDto = medicineService.getMedicine(Id);
        return ResponseEntity.ok(medicineDto);
    }

    @PostMapping()
    public ResponseEntity<MedicineDto> createMedicine(@Valid @RequestBody MedicineDto medicineDto) {
        MedicineDto createdMedicine = medicineService.createMedicine(medicineDto);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + createdMedicine.getId()).toUriString());
        return ResponseEntity.created(uri).body(createdMedicine);
    }

}
