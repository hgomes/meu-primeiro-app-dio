package br.com.igorbag.meuprimeiroappdio.data

import br.com.igorbag.meuprimeiroappdio.presentation.Car

object CarFactory {

    val list = listOf<Car>(
        Car(1, "R$ 150.000,00", "300 KWh","200cv","30 min", "www.google.com"),
        Car(2, "R$ 250.000,00", "310 KWh","200cv","30 min", "www.google.com")
    )
}