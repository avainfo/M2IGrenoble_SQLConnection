package fr.avainfo

import java.sql.DriverManager

fun main() {
    val url = "jdbc:mysql://localhost:3306/test_database"  // URL de la base de données
    val user = "root"  // Nom d'utilisateur
    val password = "root"  // Mot de passe

    // Connexion à la base de données et gestion automatique des ressources
    DriverManager.getConnection(url, user, password).use { connection ->
        // Création d'un Statement pour exécuter les requêtes SQL
        connection.createStatement().use { statement ->
            // Exécution de la requête et récupération des résultats
            statement.executeQuery("SELECT * FROM employees").use { resultSet ->
                val employees = mutableListOf<Employee>()  // Liste pour stocker les employés

                // Parcours des résultats et ajout à la liste
                while (resultSet.next()) {
                    employees.add(resultSet.toEmployee())  // Conversion des résultats en objets Employee
                }

                // Affichage des employés
                for (employee in employees) {
                    println(employee)
                }
            }
        }
    }
}
