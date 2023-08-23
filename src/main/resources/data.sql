INSERT INTO medicines (id, name, packaging_type, packaging_units_per_package, packaging_amount_per_unit)
VALUES (1000, 'Paracetamol', 'Tablet 500mg', 5, '20tabletten/strip');
       (1001, 'Broomhexine','Drank 0.8mg/l', 5, '100ml/flesje');

INSERT INTO patients (id, bsn, name)
VALUES (1000, '5555555112', 'Susanne Hagen');

INSERT INTO prescriptions (id, presccription_info, prescription_date, end_date, delivery_method, patient_id)
VALUES (1000,'4 maal per dag een tablet', '2023/08/24', '2023/10/23', 'Afhalen bij apotheek', 1000),
       (1001,'3 maal een eetlepel per dag', '2023/08/23', '2023/12/22', 'Thuisbezorgen bij patient', 1000);




