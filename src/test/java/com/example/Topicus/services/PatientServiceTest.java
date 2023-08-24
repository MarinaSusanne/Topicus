package com.example.Topicus.services;
import com.example.Topicus.model.Medicine;
import com.example.Topicus.repository.MedicineRepository;
import com.example.Topicus.service.MedicineService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;


@ExtendWith(MockitoExtension .class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class PatientServiceTest {

  
    @Mock
    MedicineRepository patientRepository;

    @InjectMocks
    MedicineService patientService;

    @Captor
    ArgumentCaptor<Medicine> captor;

    //niet aantoegenkomen, maar had graag aantal unit testen geschreven
}
