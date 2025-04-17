// Ejemplo de pruebas.sc
import Anagramas._



println("--- Pruebas lOcPal ---")
println(lOcPal("Scala")) 
println(lOcPal(""))      
println(lOcPal("repetido")) 

println("\n--- Pruebas lOcFrase ---")
val frase1 = List("Hola", "Scala")
println(lOcFrase(frase1)) 
val fraseVacia = List[String]()
println(lOcFrase(fraseVacia)) 

println("\n--- Diccionario por Ocurrencias (parcial) ---")

println(diccionarioPorOcurrencias.get(lOcPal("cosas")))
println(diccionarioPorOcurrencias.get(lOcPal("moco"))) 

println("\n--- Pruebas anagramasDePalabra ---")
println(anagramasDePalabra("roca")) 
println(anagramasDePalabra("como")) 
println(anagramasDePalabra("ocasos")) 

println("\n--- Pruebas combinaciones ---")
val occ1 = List(('a', 2), ('b', 1))
println(s"Combinaciones de $occ1:")
combinaciones(occ1).foreach(println)

println("\n--- Pruebas complemento ---")
val lOcTotal = List(('a', 2), ('b', 2), ('c', 1))
val slOcParcial = List(('a', 1), ('b', 2))
println(s"Complemento de $lOcTotal menos $slOcParcial:")
println(complemento(lOcTotal, slOcParcial)) 

println("\n--- Pruebas anagramasDeFrase ---")
val fraseAnagrama = List("Hola", "Sol")
val fraseFacil = List("Sol", "Ala")
// Anagramas: List("sol", "ala"), List("ala", "sol"), List("los", "ala"), List("ala", "los"), List("sal", "ola"), List("ola", "sal"), ...
println(s"Anagramas de $fraseFacil:")
anagramasDeFrase(fraseFacil).foreach(println)

// Prueba del PDF:
// val frasePDF = List("cosas", "como", "yo")
// println(s"Anagramas de $frasePDF:")
// anagramasDeFrase(frasePDF).foreach(println) // Usar el diccionario del PDF para esta prueba