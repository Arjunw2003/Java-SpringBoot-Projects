package com.atk.dto;

public record MonthlyAttendanceReport(Long studentId, String studentName, int year, int month, int totalSessions,
		int presentCount, int absentCount, int unmarkedCount, double attendancePercentage) {
}
