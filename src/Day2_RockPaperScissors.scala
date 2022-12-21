import zio.*

// https://adventofcode.com/2022/day/2

object Day2_RockPaperScissors extends ZIOAppDefault:

    def run = Console.printLine(getPoints(convertInput(test)).sum)

    val test = "C X\nC Y\nC X\nB X\nB Z\nA Z\nC Y\nC Z\nB Z\nC X\nB Y\nC Y\nC Y"

    enum Input(val value: Int):

        case Rock extends Input(1)
        case Paper extends Input(2)
        case Scissors extends Input(3)

    def convertInput(input: String): Array[(Input, Input)] =
        input.split("\n")
            .map(matchingInputs =>
                matchingInputs.replace(" ", ",")
                    .split(",")
            ).map(x =>
                x.map(char =>
                    char match
                        case "A" => Input.Rock
                        case "B" => Input.Paper
                        case "C" => Input.Scissors
                        case "X" => Input.Rock
                        case "Y" => Input.Paper
                        case "Z" => Input.Scissors
                        case _ => throw new RuntimeException("not a valid input")
                )
            ).map(_ match
                case Array(opponent, me) => (opponent, me)
                case _ => throw new RuntimeException("conversion failed")
            )

    def getPoints(convertedInput: Array[(Input, Input)]): Array[Int] =
        val it = convertedInput.map(it =>
            println(it)
            if(it._1.value == it._2.value) 6
            else if(it._1.value > it._2.value) 8
            else 1
        )
        it.foreach(println)
        it

