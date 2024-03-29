fun main() {

    // Criação de conteúdos educaionais
 val pooJava = EducationalContent("poo em java",60,"java, Intellij",
     "Principais conceitos da orientação objeto usando Java")
 val boasPraticasJava = EducationalContent("Boas praticas em Java",120,"Java, Intellij",
     "Aqui vamos entender como construir um código limpo quando falamos em Java")

    //Criação do map que armazena o conteúdo que será inserido em uma determinada trilha
 val conteudoTrilhaJava = mutableListOf(pooJava, boasPraticasJava)

    // Criação de uma trilha de treinamento
 val trilhaJava  = TrainingProgram("Trilha Java",conteudoTrilhaJava)

    //  Criação de uma lista de Usuarios
 val userList = mutableListOf<User>()

    // Criando os usuarios
    val user1 = User(name = "João", registration = 1, level = Level.BASIC, punctuation = 0, training = trilhaJava)
    val user2 = User("Vanessa",2,Level.BASIC,0,trilhaJava)
    val user3 = User("JoãoPedro",3,Level.BASIC,0,trilhaJava)
    val user4 = User("Pablo",16,Level.BASIC,0,trilhaJava)

    // Adicionando os Usuarios
    userList.add(user1)
    userList.add(user2)
    userList.add(user3)
    userList.add(user4)

    // Chamando a classe que gerencia a matricula dos alunos
    val enrollmentManager = EnrollmentManager(userList,trilhaJava)

    enrollmentManager.studentEnrollment(userList)

    // Solicitação de retorno das matriculas
    val enrollmentByName  = enrollmentManager.getEnrollmentManageByName()

    // output dos dados
    println("User list 1:")
    enrollmentByName.values.forEach { println(it) }

    println("Enrollmente by name:")

    for ((name, user) in enrollmentByName) {
        println("name: $name, enrollment: ${user.registration}")
    }

}