package com.example.projeto_motivation.data

import com.example.projeto_motivation.infra.MotivationConstants
import kotlin.random.Random

data class Phrase(val description: String, val categoryId: Int)

class Mock {

    private val sunny = MotivationConstants.FILTER.SUNNY
    val all = MotivationConstants.FILTER.ALL
    val happy = MotivationConstants.FILTER.HAPPY

    private val mListPhrases: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", happy),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", happy),
        Phrase("Quando está mais escuro, vemos mais estrelas!", happy),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", happy),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", happy),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", happy),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", sunny),
        Phrase("Você perde todas as chances que você não aproveita.", sunny),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sunny),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", sunny),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", sunny),
        Phrase("Se você acredita, faz toda a diferença.", sunny),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", sunny)
    )

    fun getPhrase(value: Int): String {
        val phraseHappy = mListPhrases.filter { (it.categoryId == happy) }
        val phraseSunny = mListPhrases.filter { (it.categoryId == sunny) }

        return when (value) {
            1 -> mListPhrases[Random.nextInt(0, mListPhrases.size)].description
            2 -> phraseHappy[Random.nextInt(0, phraseHappy.size)].description
            else -> phraseSunny[Random.nextInt(0, phraseSunny.size)].description
        }
    }
}