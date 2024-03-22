data class TrainingProgram(val name: String,private var contents: MutableList<EducationalContent>) {

    private val  training : MutableMap<String, MutableList<EducationalContent>> = mutableMapOf()

    init {
        training[name] = contents
    }

    fun updateTraining( name: String, content: EducationalContent){
        if(training.containsKey(name)){
            training[name]?.add(content)
        }else{
            training[name] = mutableListOf(content)
        }

    }

    @Throws(IllegalArgumentException::class)
    fun editContent(name: String, oldContent: EducationalContent, newContent: EducationalContent){

        if(training.containsKey(name)){

            val contents: MutableList<EducationalContent> = training[name]!!.toMutableList();
            val index : Int = contents.indexOf(oldContent);

            if (index > -1) {
                contents[index] = newContent
                training[name] = contents
            } else throw IllegalArgumentException("Non-existent index or negative index")

        } else {
            throw IllegalArgumentException("Non-existent training")
        }

    }

    fun editName(currentName: String, newName: String) {
        if (training.containsKey(currentName)) {

            val content = training.remove(currentName) // remove a chave correspondente no mapa, o nome da formação
            training[newName] = content ?: mutableListOf() //Caso content for null, será preenchido com uma lista vazia

        } else throw IllegalArgumentException("Non-existent training")
    }

    fun getTrainingMap(): Map<String, List<EducationalContent>>{
        return training
    }
}