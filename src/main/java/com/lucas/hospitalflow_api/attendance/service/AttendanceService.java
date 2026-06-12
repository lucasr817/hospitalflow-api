package com.lucas.hospitalflow_api.attendance.service;

import com.lucas.hospitalflow_api.attendance.entity.Attendance;
import com.lucas.hospitalflow_api.attendance.repository.AttendanceRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public Attendance criarFicha(Attendance attendance) {

        attendance.setDataCadastro(LocalDateTime.now());

        attendance.setAltaRealizada(false);

        return attendanceRepository.save(attendance);

    }
}
