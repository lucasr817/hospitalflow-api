package com.lucas.hospitalflow_api.attendance.controller;

import com.lucas.hospitalflow_api.attendance.service.AttendanceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lucas.hospitalflow_api.attendance.entity.Attendance;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/attendances")

public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }
    @PostMapping
    public Attendance criarFicha(@RequestBody Attendance attendance) {
        return attendanceService.criarFicha(attendance);
    }
}
