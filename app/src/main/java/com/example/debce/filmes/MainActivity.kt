package com.example.debce.filmes

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun notificacao() {
            val channelId = "debora.com.filmes"

            val pedingIntent = PendingIntent.getActivity(this, 0, intent, 0)

            val mNotificationId = 1000

            val mNotification = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                Notification.Builder(this, channelId)
            } else {
                Notification.Builder(this)
            }.apply {
                setContentIntent(pedingIntent)
                //add um icone na notificação
                setSmallIcon(R.drawable.notification_icon_background)
                setAutoCancel(true)
                //título de notificação
                setContentTitle(sFilmes.selectedItem.toString())
                //mensagem de notificação
                setContentText("Mensagem")
            }.build()

            val nManager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            nManager.notify(mNotificationId, mNotification)
        }

        //Construindo um array com todos os itens da lista para aparecer no spinner
        // Futuramente isso poderá ser uma lista recebida do banco de dados
        val filmes = arrayOf("Como eu Era Antes de Você", "halloween", "Pé Pequeno", "Amigos Alienígenas", "50 Tons de Cinza")

        //Criando um modelo de como essa lista aparecerá no spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, filmes)

        //add o modelo no spinner
        sFilmes.adapter = adapter

        sFilmes.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                    val selecionado = parent!!.getItemAtPosition(position).toString()

                    when(position){
                        0 -> { // adicionando a história no campo de texto
                            txtResumo.text = (selecionado + "\nRico e bem sucedido, Will (Sam Claflin) leva uma vida repleta de conquistas, " +
                                    "viagens e esportes radicais até ser atingido por uma moto, ao atravessar " +
                                    "a rua em um dia chuvoso. O acidente o torna tetraplégico, obrigando-o " +
                                    "a permanecer em uma cadeira de rodas. A situação o torna depressivo e " +
                                    "extremamente cínico, para a preocupação de seus pais (Janet McTeer e Charles Dance). " +
                                    "É neste contexto que Louisa Clark (Emilia Clarke) é contratada para cuidar " +
                                    "de Will. De origem modesta, com dificuldades financeiras e sem grandes " +
                                    "aspirações na vida, ela faz o possível para melhorar o estado de espírito de Will e, " +
                                    "aos poucos, acaba se envolvendo com ele. " +
                                    "\n")
                            //tornando a imagem visivel
                            imgFilmes.visibility = View.VISIBLE
                            // alterando a imagem. Essa nova imagem está no pacote drawable do projeto
                            imgFilmes.setImageResource(R.drawable.antes)
                            // chamando a notificação
                            notificacao()
                        }

                        1 -> { // adicionando a história no campo de texto
                            txtResumo.text = (selecionado + "\nQuatro década depois de ter escapado do ataque de Michael Myers " +
                                    "vem uma noite de Halloween, Laurie Strode (Jamie Lee Curtis) terá " +
                                    "que confrontar o assassino mascarado pela última vez. Ela foi perseguida" +
                                    "pela memória de ter sua vida por um triz, mas dessa vez, quando Myers retorna " +
                                    " para a cidade de Haddonfield, ela está preparada. " +
                                    "\n")
                            //tornando a imagem visivel
                            imgFilmes.visibility = View.VISIBLE
                            // alterando a imagem. Essa nova imagem está no pacote drawable do projeto
                            imgFilmes.setImageResource(R.drawable.halloween)
                            // chamando a notificação
                            notificacao()
                        }

                        2 -> { // adicionando a história no campo de texto
                            txtResumo.text = (selecionado + "\nUm yeti, criatura conhecida como o Abominável Homem das Neves,  " +
                                    "está indo na contramão do que todos os seus semelhantes acreditam:" +
                                    "ele tem a certeza que os seres humanos, para eles até então um mito," +
                                    "realmente existem, mesmo que todos da sua espécie neguem com veemência." +
                                    "Mas ele não irá desistir tão fácil de provar sua tese. " +
                                    "\n")
                            //tornando a imagem visivel
                            imgFilmes.visibility = View.VISIBLE
                            // alterando a imagem. Essa nova imagem está no pacote drawable do projeto
                            imgFilmes.setImageResource(R.drawable.pequeno)
                            // chamando a notificação
                            notificacao()
                        }

                        3 -> { // adicionando a história no campo de texto
                            txtResumo.text = (selecionado + "\nA vida de Louis, um menino de doze anos, muda completamente quando  " +
                                    "a nave espacial de três alienígenas cai nos fundos do quintal de sua casa." +
                                    "Seu pai, um ufologista famoso, congelaria os novos amigos na primeira" +
                                    "oportunidade, por isso ele precisa protegê-los e ajudá-los a descobrir" +
                                    "o paradeiro da nave mãe, para que só assim eles consigam voltar para casa. "+
                                    "\n")
                            //tornando a imagem visivel
                            imgFilmes.visibility = View.VISIBLE
                            // alterando a imagem. Essa nova imagem está no pacote drawable do projeto
                            imgFilmes.setImageResource(R.drawable.alienigenas)
                            // chamando a notificação
                            notificacao()
                        }

                        4 -> { // adicionando a história no campo de texto
                            txtResumo.text = (selecionado + "\nAnastasia Steele (Dakota Johnson) é uma estudante de literatura de 21 anos,  " +
                                    "romântica e virgem. Uma dia ela deve entrevistar para o jornal da" +
                                    "faculdade o poderoso magnata Christian Grey (Jamie Dornan)." +
                                    "Nasce uma complexa relação entre ambos: com a descoberta amorosa" +
                                    "e sexual, Anastasia conhece os prazeres do sadomasoquismo, tornando-se o "+
                                    "objeto de submissão do sádico Grey." +
                                    "\n")
                            //tornando a imagem visivel
                            imgFilmes.visibility = View.VISIBLE
                            // alterando a imagem. Essa nova imagem está no pacote drawable do projeto
                            imgFilmes.setImageResource(R.drawable.tons)
                            // chamando a notificação
                            notificacao()
                        }
                    }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                txtResumo.text = ""
            }


        }

    }
}