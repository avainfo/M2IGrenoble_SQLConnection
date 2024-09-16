package fr.avainfo

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

fun main() {
    val url = "jdbc:mysql://localhost:3306/test_database"
    val user = "root"
    val password = "root"

    var connection: Connection? = null
    var statement: Statement? = null
    var resultSet: ResultSet? = null

    try {
        // Connexion à la base de données
        connection = DriverManager.getConnection(url, user, password)

        // Création d'une requête SQL
        statement = connection.createStatement()
        resultSet = statement.executeQuery("SELECT * FROM employees")

        // Parcours des résultats de la requête
        while (resultSet.next()) {
            val id = resultSet.getInt("id")
            val firstName = resultSet.getString("first_name")
            val lastName = resultSet.getString("last_name")
            val department = resultSet.getString("department")
            val hireDate = resultSet.getDate("hire_date")
            val salary = resultSet.getBigDecimal("salary")

            println("ID: $id, Name: $firstName $lastName, Department: $department, Hire Date: $hireDate, Salary: $salary")
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        // Fermeture des ressources
        resultSet?.close()
        statement?.close()
        connection?.close()
    }
}