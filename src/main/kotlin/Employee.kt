package fr.avainfo

import java.sql.ResultSet

data class Employee(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val department: String,
    val hireDate: java.sql.Date,
    val salary: java.math.BigDecimal
)

fun ResultSet.toEmployee(): Employee {
    return Employee(
        id = getInt("id"),
        firstName = getString("first_name"),
        lastName = getString("last_name"),
        department = getString("department"),
        hireDate = getDate("hire_date"),
        salary = getBigDecimal("salary")
    )
}

// fun ResultSet.toEmployee(): Employee = Employee(
//     id = getInt("id"),
//     firstName = getString("first_name"),
//     lastName = getString("last_name"),
//     department = getString("department"),
//     hireDate = getDate("hire_date"),
//     salary = getBigDecimal("salary")
// )