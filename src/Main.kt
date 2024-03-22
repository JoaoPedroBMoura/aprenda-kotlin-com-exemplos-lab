fun main() {
 val pooJava = EducationalContent("poo em java",60,"java, Intellij",
     "Principais conceitos da orientação objeto usando Java")
 val boasPraticasJava = EducationalContent("Boas praticas em Java",120,"Java, Intellij",
     "Aqui vamos entender como construir um código limpo quando falamos em Java")

 val conteudoTrilhaJava = mutableListOf(pooJava, boasPraticasJava)

 val trilhaJava  = TrainingProgram("Trilha Java",conteudoTrilhaJava)

 //Level types : BASIC, INTERMEDIARY, ADVANCED

 val user1 = User("João",1,Level.BASIC,1000,EnrollmentStatus.ENROLLED,trilhaJava,)
}