package com.atk.dto;

public record AbsentStudentResponse(
    Long sessionId,
    Long studentId,
    String studentName,
    String email
) {
}
