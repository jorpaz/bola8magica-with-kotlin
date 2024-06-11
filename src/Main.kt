const val AFFIRMATIVE_ANSWER = "✅"
const val NEGATIVE_ANSWER = "❌"
const val DOUBTFUL_ANSWER = "?"

val respuestas = mapOf(
    "Sí" to AFFIRMATIVE_ANSWER,
    "Es cierto" to AFFIRMATIVE_ANSWER,
    "Totalmente" to AFFIRMATIVE_ANSWER,
    "Sin duda" to AFFIRMATIVE_ANSWER,
    "Pregunta en otro momento" to DOUBTFUL_ANSWER,
    "No puedo decirte en este momento" to DOUBTFUL_ANSWER,
    "Puede que si o puede que no" to DOUBTFUL_ANSWER,
    "No va a suceder" to NEGATIVE_ANSWER,
    "No cuentes con ello" to NEGATIVE_ANSWER,
    "Definitivamente no" to NEGATIVE_ANSWER,
    "No lo creo" to NEGATIVE_ANSWER,
)

fun main() {
    println("Hola, soy tu bola mágica creada en Kotilin.")
    println("¿Cuál de estas opciones deseas realizar?")
    println("1. Realizar una pregunta")
    println("2. Revisar todas las respuestas")
    println("3. Salir")

    val valorIngresado = readLine()

    when(valorIngresado){
        "1" -> askQuestion()
        "2" -> showAnswers()
        "3" -> exit()
        else -> showError()
    }
}

fun askQuestion(){
    println("Haz una pregunta")
    readLine()
    println("Buena pregunta, la respuesta es: ")

    val answerGenerate = respuestas.keys.random()
    println(answerGenerate)
}

fun showAnswers() {
    println("Selecciona una opción")
    println("1. Revisar todas las respuestas")
    println("2. Revisar solo las respuestas afirmativas")
    println("3. Revisar solo las respuestas dudosas")
    println("4. Revisar solo las respuestas negativas")

    val inOption = readLine()
    when(inOption){
        "1" -> showAnswersByType()
        "2" -> showAnswersByType(answerType = AFFIRMATIVE_ANSWER)
        "3" -> showAnswersByType(answerType = DOUBTFUL_ANSWER)
        "4" -> showAnswersByType(answerType = NEGATIVE_ANSWER)
        else -> println("Respuesta no valida. Adiós!")
    }
}

fun showAnswersByType(answerType: String = "TODOS"){
    when(answerType){
        "TODOS" -> respuestas.keys.forEach{answer -> println(answer)}
        AFFIRMATIVE_ANSWER -> respuestas.filterValues { values -> values == AFFIRMATIVE_ANSWER }
            .also { answersAffirmatives -> println(answersAffirmatives.keys) }
        NEGATIVE_ANSWER -> respuestas.filterValues { values -> values == NEGATIVE_ANSWER }
            .also { answersNegatives -> println(answersNegatives.keys) }

        DOUBTFUL_ANSWER -> respuestas.filterValues { values -> values == DOUBTFUL_ANSWER }
            .also { answersDoubtful -> println(answersDoubtful.keys) }
    }
}

fun exit() {
    println("Hasta luego!")
}

fun showError() {
    println("Vaya, parece que has elegido una opción invalida, intenta de nuevo!")
    askQuestion()
}