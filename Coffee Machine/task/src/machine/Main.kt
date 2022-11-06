package machine

enum class CoffeeTypes(val water: Int, val milk: Int, val coffee: Int, val price: Int) {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20,7),
    CAPPUCCINO(200,100,12,6)
}

class CoffeeMachine(
    private var moneyAmount: Int,
    private var waterAmount: Int,
    private var milkAmount: Int,
    private var coffeeBeansAmount: Int,
    private var cupAmount: Int) {

    var state = "action"

    private fun printState() {
        println("""
            
            The coffee machine has:
            $waterAmount ml of water
            $milkAmount ml of milk
            $coffeeBeansAmount g of coffee beans
            $cupAmount disposable cups
            $$moneyAmount of money
        """.trimIndent())
    }

    private fun takeAction() {
        println("\nI gave you $$moneyAmount")
        moneyAmount = 0
    }

    fun requestInput() {
        when (state) {
            "action" -> println("\nWrite action (buy, fill, take, remaining, exit):")
            "buy" -> println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
            "fillWater" -> println("\nWrite how many ml of water you want to add:")
            "fillMilk" -> println("Write how many ml of milk you want to add:")
            "fillCoffee" -> println("Write how many grams of coffee beans you want to add:")
            "fillCup" -> println("Write how many disposable cups you want to add:")
        }
    }

    fun processInput(input: String) {
        when (state) {
            "action" -> {
                when (input) {
                    "exit" -> state = "exit"
                    "remaining" -> printState()
                    "buy" -> state = "buy"
                    "fill" -> state = "fillWater"
                    "take" -> takeAction()
                }
            }
            "buy" -> {
                when (input) {
                    "back" -> state = "action"
                    else -> if (cupAmount == 0) {
                        println("Sorry, not enough cups!")
                        state = "action"
                    } else {
                        when (input) {
                            "1" -> {
                                if (waterAmount < CoffeeTypes.ESPRESSO.water) {
                                    println("Sorry, not enough water!")
                                    state = "action"
                                } else if (coffeeBeansAmount < CoffeeTypes.ESPRESSO.coffee) {
                                    println("Sorry, not enough coffee beans!")
                                    state = "action"
                                } else {
                                    println("I have enough resources, making you a coffee!")
                                    waterAmount -= CoffeeTypes.ESPRESSO.water
                                    coffeeBeansAmount -= CoffeeTypes.ESPRESSO.coffee
                                    cupAmount--
                                    moneyAmount += CoffeeTypes.ESPRESSO.price
                                    state = "action"
                                }
                            }
                            "2" -> {
                                if (waterAmount < CoffeeTypes.LATTE.water) {
                                    println("Sorry, not enough water!")
                                    state = "action"
                                } else if (milkAmount < CoffeeTypes.LATTE.milk) {
                                    println("Sorry, not enough milk!")
                                    state = "action"
                                } else if (coffeeBeansAmount < CoffeeTypes.LATTE.coffee) {
                                    println("Sorry, not enough coffee beans!")
                                    state = "action"
                                } else {
                                    println("I have enough resources, making you a coffee!")
                                    waterAmount -= CoffeeTypes.LATTE.water
                                    milkAmount -= CoffeeTypes.LATTE.milk
                                    coffeeBeansAmount -= CoffeeTypes.LATTE.coffee
                                    cupAmount--
                                    moneyAmount += CoffeeTypes.LATTE.price
                                    state = "action"
                                }
                            }
                            "3" -> {
                                if (waterAmount < CoffeeTypes.CAPPUCCINO.water) {
                                    println("Sorry, not enough water!")
                                    state = "action"
                                } else if (milkAmount < CoffeeTypes.CAPPUCCINO.milk) {
                                    println("Sorry, not enough milk!")
                                    state = "action"
                                } else if (coffeeBeansAmount < CoffeeTypes.CAPPUCCINO.coffee) {
                                    println("Sorry, not enough coffee beans!")
                                    state = "action"
                                } else {
                                    println("I have enough resources, making you a coffee!")
                                    waterAmount -= CoffeeTypes.CAPPUCCINO.water
                                    milkAmount -= CoffeeTypes.CAPPUCCINO.milk
                                    coffeeBeansAmount -= CoffeeTypes.CAPPUCCINO.coffee
                                    cupAmount--
                                    moneyAmount += CoffeeTypes.CAPPUCCINO.price
                                    state = "action"
                                }
                            }
                            else -> {
                                println("No such coffee type.")
                                state = "action"
                            }
                        }
                    }
                }
            }
            "fillWater" -> {
                waterAmount += input.toInt()
                state = "fillMilk"
            }
            "fillMilk" -> {
                milkAmount += input.toInt()
                state = "fillCoffee"
            }
            "fillCoffee" -> {
                coffeeBeansAmount += input.toInt()
                state = "fillCup"
            }
            "fillCup" -> {
                cupAmount += input.toInt()
                state = "action"
            }
        }
    }

}

fun main() {

    val coffeeMachine = CoffeeMachine(550, 400, 540, 120, 9)

    do {
        coffeeMachine.requestInput()
        val input = readln()
        coffeeMachine.processInput(input)
    } while (coffeeMachine.state != "exit")

}
