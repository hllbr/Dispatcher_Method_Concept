package com.hllbr.dispatcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        main()
        /*
        Dispatcher =
        coroutineslerimizi farklı yapılarla çalıştırmamızı sağlıyor.

         */
    }
    fun main(){

       /*
        Dispatchers.Default ->CPU İNTENSİVE --> Görsel işleme çok uzun bir diziyi dizme Aritmatik olarak dizme vb... işlemlerde kullanılır.

        Dispatchers.IO -> INPUT/OUTPUT NETWORKİNG == İNTERNETE GİRİP VERİÇEKMEK BİR VERİ TABANINDAN VERİ ALMAK GİBİ İŞLEMLERİ YAPARKEN KULLANILIYOR.

        Dispatchers.Main -> Main threadimiz bunu direkt UI de yapmak gerekiyor kullanıcının görmesi istenen işlemleri UI da yapmak gerekiyor.Görseli aldın işledin kullanıcıya göstermek istedin bu işlemler main ile gerçekleştiriliyor.
        Aynı şekilde internetten veri çektin kullanıcıya göstermek istiyorsan kullanabilirsin

        Dispatchers.Unconfined ->Inherited Dispatcher --> nerden çağrıldıysa orayı inherit ediyor kalıtım alıyor.içerisinde çalıştırılan yere göre değişiyor.kendi ayarlıyor diyebiliriz.

        */
            runBlocking {
                launch (Dispatchers.Main){
                    //launch()<--Parantez içerisinde hangi Dispatchers ile çalışmak istediğimi söyleyebilirim.
                    println("Main Thread${Thread.currentThread().name}")
                }
                launch (Dispatchers.IO){
                    println("IO Thread${Thread.currentThread().name}")
                }
                launch (Dispatchers.Default){
                    println("Default Thread${Thread.currentThread().name}")
                }
                launch(Dispatchers.Unconfined) {
                    println("Unconfined ${Thread.currentThread().name}")
                }
            }
    }
}